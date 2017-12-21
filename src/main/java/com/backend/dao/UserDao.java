package com.backend.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Tobitoi on 12/21/17.
 */
public interface UserDao {
    int countUser(JSONObject jsonObject);
    List<JSONObject> listUser(JSONObject jsonObject);
    List<JSONObject> getAllRoles();
    int addUser(JSONObject jsonObject);
    int updateUser(JSONObject jsonObject);
    List<JSONObject> listRole();
    List<JSONObject> listAllPermission();
    int insertRole(JSONObject jsonObject);
    int insertRolePermission(@Param("roleId") String roleId, @Param("permissions") List<Integer> permissions);
    int removeOldPermission(@Param("roleId") String roleId, @Param("permissions") List<Integer> permissions);
    int updateRoleName(JSONObject jsonObject);
    JSONObject getRoleAllInfo(JSONObject jsonObject);
    int removeRole(JSONObject jsonObject);
    int removeRoleAllPermission(JSONObject jsonObject);
}
