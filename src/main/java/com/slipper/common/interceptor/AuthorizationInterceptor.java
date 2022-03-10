package com.slipper.common.interceptor;

import com.slipper.common.annotation.Login;
import com.slipper.common.exception.RunException;
import com.slipper.common.utils.Constant;
import com.slipper.common.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author gumingchen
 */
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Resource
    private JwtUtils jwt;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断接口是否需要登录
        Login login = method.getAnnotation(Login.class);
        if (login != null) {
            String token = request.getHeader(Constant.TOKEN_KEY);
            if (StringUtils.isBlank(token)) {
                throw new RunException(Constant.WARNING_CODE, "请先登录！");
            }
            if (!jwt.validate(token)) {
                throw new RunException(Constant.WARNING_CODE, "登录已过期，请先登录！");
            }
            int userId = (int)jwt.getClaims(token).get("id");

            request.setAttribute(Constant.USER_KEY, userId);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
