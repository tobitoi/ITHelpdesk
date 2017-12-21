package com.backend.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tobitoi on 12/21/17.
 */
public interface UserService {
    JSONObject listUser(JSONObject jsonObject);
    JSONObject getAllRoles();
    JSONObject addUser(JSONObject jsonObject);
    JSONObject updateUser(JSONObject jsonObject);
    JSONObject listRole();
    JSONObject listAllPermission();
    JSONObject addRole(JSONObject jsonObject);
    JSONObject updateRole(JSONObject jsonObject);
    JSONObject deleteRole(JSONObject jsonObject);
}
