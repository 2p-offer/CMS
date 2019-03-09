package com.wy.manager.mp.common.controller;

import com.wy.manager.mp.common.utils.ShiroUtils;
import com.wy.manager.mp.system.domain.UserDO;
import org.springframework.stereotype.Controller;
/**
 * @Author: wangyan
 * @Date: 2019/2/12
 */
@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}