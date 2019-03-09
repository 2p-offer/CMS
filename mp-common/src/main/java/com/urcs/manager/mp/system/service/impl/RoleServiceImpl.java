package com.urcs.manager.mp.system.service.impl;

import com.urcs.manager.mp.common.utils.ShiroUtils;
import com.urcs.manager.mp.system.dao.RoleDao;
import com.urcs.manager.mp.system.dao.RoleMenuDao;
import com.urcs.manager.mp.system.dao.UserDao;
import com.urcs.manager.mp.system.dao.UserRoleDao;
import com.urcs.manager.mp.system.domain.RoleDO;
import com.urcs.manager.mp.system.domain.RoleMenuDO;
import com.urcs.manager.mp.system.domain.UserDO;
import com.urcs.manager.mp.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class RoleServiceImpl implements RoleService {

    public static final String ROLE_ALL_KEY = "\"role_all\"";

    public static final String DEMO_CACHE_NAME = "role";

    @Autowired
    RoleDao roleMapper;
    @Autowired
    RoleMenuDao roleMenuMapper;
    @Autowired
    UserDao userMapper;
    @Autowired
    UserRoleDao userRoleMapper;

    @Override
    public List<RoleDO> list() {
        //添加权限管理
        UserDO user = ShiroUtils.getUser();
        Long companyId = user.getCompanyId();
        Map<String, Object> params = new HashMap<>(16);
//        if(companyId!=0){
//            params.put("companyId",companyId);
////            Long rid = userRoleMapper.listRoleId(user.getUserId()).get(0);
////            roleMapper.get(rid).getLevel();
//            params.put("level","1");
//        }
        List<RoleDO> roles = roleMapper.list(params);
        return roles;
    }


    @Override
    public List<RoleDO> list(Long userId) {
        List<Long> rolesIds = userRoleMapper.listRoleId(userId);
//        UserDO user = ShiroUtils.getUser();
//        Long companyId=user.getCompanyId();
        Map<String, Object> params = new HashMap<>(16);
//        if(companyId!=0){
//            params.put("companyId",companyId);
////            Long rid = userRoleMapper.listRoleId(user.getUserId()).get(0);
////            roleMapper.get(rid).getLevel();
//            params.put("level","1");
//        }
        List<RoleDO> roles = roleMapper.list(params);
        for (RoleDO roleDO : roles) {
            roleDO.setRoleSign("false");
            for (Long roleId : rolesIds) {
                if (Objects.equals(roleDO.getRoleId(), roleId)) {
                    roleDO.setRoleSign("true");
                    break;
                }
            }
        }
        return roles;
    }

    @Transactional
    @Override
    public int save(RoleDO role) {
        //如果添加的是超级管理员，则获得所有菜单权限
//        if(role.getLevel()==0){
//        List<Long> longs = roleMenuMapper.listMenuIdByRoleId(role.getRoleId());
//        role.setMenuIds(longs);
//        }
        int count = roleMapper.save(role);
        List<Long> menuIds = role.getMenuIds();
        Long roleId = role.getRoleId();
        List<RoleMenuDO> rms = new ArrayList<>();
        for (Long menuId : menuIds) {
            RoleMenuDO rmDo = new RoleMenuDO();
            rmDo.setRoleId(roleId);
            rmDo.setMenuId(menuId);
            rms.add(rmDo);
        }
        roleMenuMapper.removeByRoleId(roleId);
        if (rms.size() > 0) {
            int i = roleMenuMapper.batchSave(rms);
        }
        return count;
    }

    @Transactional
    @Override
    public int remove(Long id) {
        int count = roleMapper.remove(id);
        userRoleMapper.removeByRoleId(id);
        roleMenuMapper.removeByRoleId(id);
        return count;
    }

    @Override
    public RoleDO get(Long id) {
        RoleDO roleDO = roleMapper.get(id);
        return roleDO;
    }

    @Override
    public int update(RoleDO role) {
        int r = roleMapper.update(role);
        List<Long> menuIds = role.getMenuIds();
        Long roleId = role.getRoleId();
        roleMenuMapper.removeByRoleId(roleId);
        List<RoleMenuDO> rms = new ArrayList<>();
        for (Long menuId : menuIds) {
            RoleMenuDO rmDo = new RoleMenuDO();
            rmDo.setRoleId(roleId);
            rmDo.setMenuId(menuId);
            rms.add(rmDo);
        }
        if (rms.size() > 0) {
            roleMenuMapper.batchSave(rms);
        }
        return r;
    }

    @Override
    public int batchremove(Long[] ids) {
        int r = roleMapper.batchRemove(ids);
        return r;
    }

}
