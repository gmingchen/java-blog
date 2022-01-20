package com.slipper.modules;

import com.slipper.common.utils.ShiroUtils;
import com.slipper.modules.user.model.dto.UserBasicDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 *
 * @author Loafer
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected UserBasicDto getUser() {
		return ShiroUtils.getUser();
	}

	protected int getUserId() {
		return ShiroUtils.getUserId();
	}
}
