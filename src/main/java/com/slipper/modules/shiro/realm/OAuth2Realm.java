package com.slipper.modules.shiro.realm;

import com.alibaba.druid.support.json.JSONUtils;
import com.slipper.common.utils.Constant;
import com.slipper.common.utils.JwtUtils;
import com.slipper.common.utils.R;
import com.slipper.modules.shiro.service.ShiroService;
import com.slipper.modules.shiro.token.OAuth2Token;
import com.slipper.modules.user.model.dto.UserBasicDto;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author gumingchen
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {
    @Resource
    ShiroService shiroService;
    @Resource
    private JwtUtils jwt;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 身份验证（凭证验证-token） TODO: 验证token是否有效
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 用户请求携带的token凭证
        String token = (String)authenticationToken.getPrincipal();
        // 验证凭证
        if (!jwt.validate(token)) {
            // 凭证不正确
            String message = JSONUtils.toJSONString(R.error(Constant.TOKEN_EXPIRE_CODE, Constant.TOKEN_EXPIRE));
            throw new IncorrectCredentialsException(message);
        }
        // 获取用户信息
        int userId = (int)jwt.getClaims(token).get("id");
        UserBasicDto user = shiroService.queryUserById(userId);
        // 用户验证
        if (user == null || user.getStatus() == 0) {
            String message = JSONUtils.toJSONString(R.error(Constant.WARNING_CODE, "账户已被冻结，请联系管理员！"));
            throw new LockedAccountException(message);
        }
        if (user.getAuthor() == 0) {
            String message = JSONUtils.toJSONString(R.error(Constant.NOT_ALLOWED_CODE, Constant.NOT_ALLOWED));
            throw new LockedAccountException(message);
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, token, getName());

        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
