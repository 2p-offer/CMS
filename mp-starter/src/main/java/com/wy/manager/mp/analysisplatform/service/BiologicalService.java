package com.wy.manager.mp.analysisplatform.service;

import com.wy.manager.mp.analysisplatform.api.BiologicalArgs;
import com.wy.manager.mp.system.domain.UserDO;
import com.wy.manager.mp.system.vo.UserVO;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 2P on 19-3-25.
 */
public interface BiologicalService {
    //分页查询
    public List<BiologicalArgs> list(Map<String, Object> map);

    BiologicalArgs get(Long id);

    int count(Map<String, Object> map);

    int save(BiologicalArgs bio);

    int update(BiologicalArgs bio);

    int remove(String id);

    int batchremove(String[] ids);

    boolean exit(Map<String, Object> params);

}
