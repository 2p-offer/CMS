package com.urcs.manager.mp.system.controller;

import com.urcs.manager.mp.common.annotation.Log;
import com.urcs.manager.mp.common.config.Constant;
import com.urcs.manager.mp.common.controller.BaseController;
import com.urcs.manager.mp.common.utils.R;
import com.urcs.manager.mp.common.utils.ShiroUtils;
import com.urcs.manager.mp.system.domain.RoleDO;
import com.urcs.manager.mp.system.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/sys/role")
@Controller
public class RoleController extends BaseController {
	String prefix = "system/role";
	@Autowired
    RoleService roleService;

	@RequiresPermissions("sys:role:role")
	@GetMapping()
	String role() {
		return prefix + "/role";
	}

	@RequiresPermissions("sys:role:role")
	@GetMapping("/list")
	@ResponseBody()
	List<RoleDO> list() {
		List<RoleDO> roles = roleService.list();
		return roles;
	}

	@Log("添加角色")
	@RequiresPermissions("sys:role:add")
	@GetMapping("/add")
	String add(Model model) {
		model.addAttribute("isSystem",ShiroUtils.getUser().isSystem());
		return prefix + "/add";
	}

	@Log("编辑角色")
	@RequiresPermissions("sys:role:edit")
	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id, Model model) {

		RoleDO roleDO = roleService.get(id);

		model.addAttribute("isSystem",ShiroUtils.getUser().isSystem());
		model.addAttribute("role", roleDO);
		model.addAttribute("currentRoleLevel", roleDO.getLevel());
		return prefix + "/edit";
	}

	@Log("保存角色")
	@RequiresPermissions("sys:role:add")
	@PostMapping("/save")
	@ResponseBody()
	R save(RoleDO role) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		//添加角色的level
		//1.超管会选择添加角色的等级
		//2.企业管理只能添加等级为3的角色
		//3.普通管理不能添加角色

		if(!ShiroUtils.getUser().isSystem()){
			role.setLevel(2L);
			role.setCompanyId(ShiroUtils.getUser().getCompanyId());
		}else{
			switch (role.getLevel().toString()){
				case "0":
					role.setCompanyId(0L);
					break;
				case "1":
//					role.setCompanyId(ShiroUtils.getUser().getCompanyId());
					//TODO 超级管理员输入企业名称之后，暂时无法获得companyId，先放在这123
					role.setCompanyId(123L);
			}
		}
		if (roleService.save(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("更新角色")
	@RequiresPermissions("sys:role:edit")
	@PostMapping("/update")
	@ResponseBody()
	R update(RoleDO role,Long currentRoleLevel) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if(currentRoleLevel.longValue()==roleService.get(ShiroUtils.getUser().getRoleIds().get(0)).getLevel().longValue()){
			return  R.error(1, "不可编辑同级别角色");
		}
		if (roleService.update(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("删除角色")
	@RequiresPermissions("sys:role:remove")
	@PostMapping("/remove")
	@ResponseBody()
	R save(Long id) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (roleService.remove(id) > 0) {
			return R.ok();
		} else {
			return R.error(1, "删除失败");
		}
	}
	
	@RequiresPermissions("sys:role:batchRemove")
	@Log("批量删除角色")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] ids) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		int r = roleService.batchremove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}
