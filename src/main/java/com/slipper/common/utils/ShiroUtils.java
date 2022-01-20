package com.slipper.common.utils;//package com.slipper.core.common.utils;

import com.slipper.modules.user.entity.UserEntity;
import com.slipper.modules.user.model.dto.UserBasicDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Shiro 工具类
 *
 * @author Loafer
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public class ShiroUtils {

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static UserBasicDto getUser() {
        return (UserBasicDto) SecurityUtils.getSubject().getPrincipal();
    }

    public static int getUserId() {
        return getUser().getId();
    }

    public static String getIp() {
        return getSubject().getSession().getHost();
    }

}
