package com.wy.manager.mp.system.service;

import com.wy.manager.mp.system.domain.UserDO;
import com.wy.manager.mp.system.domain.UserOnline;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
/**
 * @Author: wangyan
 * @Date: 2019/2/17
 */
@Service
public interface SessionService {
	List<UserOnline> list();

	List<UserDO> listOnlineUser();

	Collection<Session> sessionList();
	
	boolean forceLogout(String sessionId);
}
