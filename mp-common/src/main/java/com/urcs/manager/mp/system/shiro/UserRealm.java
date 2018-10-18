package com.urcs.manager.mp.system.shiro;

import com.urcs.manager.mp.common.config.ApplicationContextRegister;
import com.urcs.manager.mp.common.utils.ShiroUtils;
import com.urcs.manager.mp.system.dao.RoleDao;
import com.urcs.manager.mp.system.dao.UserDao;
import com.urcs.manager.mp.system.dao.UserRoleDao;
import com.urcs.manager.mp.system.domain.UserDO;
import com.urcs.manager.mp.system.domain.UserRoleDO;
import com.urcs.manager.mp.system.service.MenuService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.*;

public class UserRealm extends AuthorizingRealm {
/*	@Autowired
	UserDao userMapper;
	@Autowired
	MenuService menuService;*/

	//用户授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		Long userId = ShiroUtils.getUserId();
		MenuService menuService = ApplicationContextRegister.getBean(MenuService.class);
		Set<String> perms = menuService.listPerms(userId);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(perms);
		return info;
	}

	//用户认证，重点在于将principals 赋值
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		Map<String, Object> map = new HashMap<>(16);
		map.put("username", username);
		String password = new String((char[]) token.getCredentials());

		UserDao userMapper = ApplicationContextRegister.getBean(UserDao.class);
		RoleDao roleMapper= ApplicationContextRegister.getBean(RoleDao.class);
		UserRoleDao userRoleMapper= ApplicationContextRegister.getBean(UserRoleDao.class);
		// 查询用户信息
		UserDO user = userMapper.list(map).get(0);

		//添加用户的其他信息
        Map<String,Object> userInfo=new HashMap<>();
        userInfo.put("userId",user.getUserId());
        //获取到登陆用户所有角色
        List<UserRoleDO> roleList = userRoleMapper.list(userInfo);
//        给登陆用户信息的roleIds赋值
        List<Long> roleIds=new ArrayList<>();
        for(UserRoleDO roleDO:roleList){
            roleIds.add(roleDO.getRoleId());
        }
        user.setRoleIds(roleIds);
        Long userLevel=roleMapper.get(roleList.get(0).getRoleId()).getLevel();
        if(userLevel==0){
            user.setSystem(true);;
        }else{
            user.setSystem(false);
        }


        // 账号不存在
		if (user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}

		// 密码错误
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码不正确");
		}

		// 账号锁定
		if (user.getStatus() == 0) {
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}
