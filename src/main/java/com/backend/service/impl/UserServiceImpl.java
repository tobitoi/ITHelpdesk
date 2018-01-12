package com.backend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.backend.dao.UserDao;
import com.backend.service.UserService;
import com.backend.util.CommonUtil;
import com.backend.util.constant.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by Tobitoi on 12/21/17.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public JSONObject listUser(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = userDao.countUser(jsonObject);
        List<JSONObject> list = userDao.listUser(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject addUser(JSONObject jsonObject) {
        userDao.addUser(jsonObject);
        System.out.println(jsonObject.getInteger("userId"));
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject getAllRoles() {
        List<JSONObject> roles = userDao.getAllRoles();
        return CommonUtil.successPage(roles);
    }

    @Override
    public JSONObject updateUser(JSONObject jsonObject) {
        userDao.updateUser(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listRole() {
        List<JSONObject> roles = userDao.listRole();
        return CommonUtil.successPage(roles);
    }

    @Override
    public JSONObject listAllPermission() {
        List<JSONObject> permissions = userDao.listAllPermission();
        return CommonUtil.successPage(permissions);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public JSONObject addRole(JSONObject jsonObject) {
        userDao.insertRole(jsonObject);
        userDao.insertRolePermission(jsonObject.getString("roleId"), (List<Integer>) jsonObject.get("permissions"));
        return CommonUtil.successJson();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public JSONObject updateRole(JSONObject jsonObject) {
        String roleId = jsonObject.getString("roleId");
        List<Integer> newPerms = (List<Integer>) jsonObject.get("permissions");
        JSONObject roleInfo = userDao.getRoleAllInfo(jsonObject);
        Set<Integer> oldPerms = (Set<Integer>) roleInfo.get("permissionIds");
        dealRoleName(jsonObject, roleInfo);
        saveNewPermission(roleId, newPerms, oldPerms);
        removeOldPermission(roleId, newPerms, oldPerms);
        return CommonUtil.successJson();
    }

    private void dealRoleName(JSONObject paramJson, JSONObject roleInfo) {
        String roleName = paramJson.getString("roleName");
        if (!roleName.equals(roleInfo.getString("roleName"))) {
            userDao.updateRoleName(paramJson);
        }
    }

    private void saveNewPermission(String roleId, Collection<Integer> newPerms, Collection<Integer> oldPerms) {
        List<Integer> waitInsert = new ArrayList<>();
        for (Integer newPerm : newPerms) {
            if (!oldPerms.contains(newPerm)) {
                waitInsert.add(newPerm);
            }
        }
        if (waitInsert.size() > 0) {
            userDao.insertRolePermission(roleId, waitInsert);
        }
    }


    private void removeOldPermission(String roleId, Collection<Integer> newPerms, Collection<Integer> oldPerms) {
        List<Integer> waitRemove = new ArrayList<>();
        for (Integer oldPerm : oldPerms) {
            if (!newPerms.contains(oldPerm)) {
                waitRemove.add(oldPerm);
            }
        }
        if (waitRemove.size() > 0) {
            userDao.removeOldPermission(roleId, waitRemove);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public JSONObject deleteRole(JSONObject jsonObject) {
        JSONObject roleInfo = userDao.getRoleAllInfo(jsonObject);
        List<JSONObject> users = (List<JSONObject>) roleInfo.get("users");
        if (users != null && users.size() > 0) {
            return CommonUtil.errorJson(ErrorEnum.E_10008);
        }
        userDao.removeRole(jsonObject);
        userDao.removeRoleAllPermission(jsonObject);
        return CommonUtil.successJson();
    }
}
