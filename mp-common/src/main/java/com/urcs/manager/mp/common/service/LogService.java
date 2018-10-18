package com.urcs.manager.mp.common.service;

import com.urcs.manager.mp.common.domain.LogDO;
import com.urcs.manager.mp.common.domain.PageDO;
import com.urcs.manager.mp.common.utils.Query;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
