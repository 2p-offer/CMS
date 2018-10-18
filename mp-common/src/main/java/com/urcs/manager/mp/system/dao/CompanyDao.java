package com.urcs.manager.mp.system.dao;

import com.urcs.manager.mp.system.domain.CompanyDO;

import java.util.List;
import java.util.Map;

/**
 * 企业
 * Created by wangyan on 2018/10/12.
 */
public interface CompanyDao {
    CompanyDO get(Long companyId);

    List<CompanyDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(CompanyDO company);

    int update(CompanyDO company);

    int remove(Long companyId);

    int batchRemove(Long[] companyIds);
}
