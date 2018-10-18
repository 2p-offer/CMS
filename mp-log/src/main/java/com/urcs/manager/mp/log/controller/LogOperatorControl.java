package com.urcs.manager.mp.log.controller;
import com.urcs.manager.mp.common.controller.BaseController;
import com.urcs.manager.mp.common.utils.DateUtils;
import com.urcs.manager.mp.common.utils.PageUtils;
import com.urcs.manager.mp.log.api.LogOperatorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 文章内容
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-09 10:03:34
 */
@Controller
@RequestMapping("/log/operator")
public class LogOperatorControl extends BaseController {

	@Autowired
	LogOperatorService logOperatorService;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@GetMapping()
	@RequiresPermissions("log:operator")
	String bContent() {
		return "log/operator";
	}


	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("log:operator")
	public PageUtils list(@RequestParam Map<String, Object> params) {

		try {
			params.put("startTime", DateUtils.parse((String) params.get("startTimeStr")).getTime());
			params.put("endTime", DateUtils.parse((String) params.get("endTimeStr")).getTime());
		} catch (Exception e) {
			params.put("startTime", System.currentTimeMillis() - 60 * 1000);
			params.put("endTime",  System.currentTimeMillis());
			LOGGER.error("time parse error. user default time");

		}

		List<Object> objectList = logOperatorService.getOperatorList(params);
		PageUtils pageUtils = new PageUtils(objectList, logOperatorService.count(params));
		return pageUtils;
	}


}
