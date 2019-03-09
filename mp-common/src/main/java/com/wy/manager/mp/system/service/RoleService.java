package com.wy.manager.mp.system.service;

import com.wy.manager.mp.system.domain.RoleDO;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author: wangyan
 * @Date: 2019/2/17
 */
@Service
public interface RoleService {

	RoleDO get(Long id);

	List<RoleDO> list();

	int save(RoleDO role);

	int update(RoleDO role);

	int remove(Long id);

	List<RoleDO> list(Long userId);

	int batchremove(Long[] ids);
}
