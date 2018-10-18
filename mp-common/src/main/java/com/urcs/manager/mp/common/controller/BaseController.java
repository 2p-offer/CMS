package com.urcs.manager.mp.common.controller;

import com.urcs.manager.mp.common.utils.ShiroUtils;
import com.urcs.manager.mp.system.domain.UserDO;
import org.springframework.stereotype.Controller;

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