package com.wy.manager.mp.common.service;

import com.wy.manager.mp.common.domain.LogDO;
import com.wy.manager.mp.common.domain.PageDO;
import com.wy.manager.mp.common.utils.Query;
import org.springframework.stereotype.Service;
/**
 * @Author: wangyan
 * @Date: 2019/2/21
 */
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
