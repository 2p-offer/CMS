package com.wy.manager.mp.system.controller;

import com.wy.manager.mp.common.annotation.Log;
import com.wy.manager.mp.common.controller.BaseController;
import com.wy.manager.mp.common.domain.Tree;
import com.wy.manager.mp.common.utils.MD5Utils;
import com.wy.manager.mp.common.utils.R;
import com.wy.manager.mp.common.utils.ShiroUtils;
import com.wy.manager.mp.system.config.ShiroConfig;
import com.wy.manager.mp.system.domain.MenuDO;
import com.wy.manager.mp.system.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MenuService menuService;
	ShiroConfig shiroConfig;

	@GetMapping({ "/", "" })
	String welcome(Model model) {

		return "redirect:/index";
	}

	@Log("请求访问主页")
	@GetMapping({ "/index" })
	String index(Model model) {
		List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
		model.addAttribute("menus", menus);
		model.addAttribute("name", getUser().getName());
		model.addAttribute("username", getUser().getUsername());
		return "index";
	}

	@GetMapping("/login")
	String login() {
		return "login";
	}

	@Log("登录")
	@PostMapping("/login")
	@ResponseBody
    R ajaxLogin(String username, String password) {

		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password,true);
		Subject subject = SecurityUtils.getSubject();
		try {

			subject.login(token);
//			shiroConfig.redisManager().set(new Date().toString().getBytes(),token.toString().getBytes());
			return R.ok();
		} catch (AuthenticationException e) {
			return R.error("用户或密码错误");
		}
	}

	@GetMapping("/logout")
	String logout() {
		ShiroUtils.logout();
		return "redirect:/login";
	}

	@GetMapping("/main")
	String main() {
		return "main";
	}

}
