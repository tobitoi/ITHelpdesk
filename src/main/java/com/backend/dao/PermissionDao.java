package com.backend.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * Created by Tobitoi on 12/21/17.
 */
public interface PermissionDao {
    JSONObject getUserPermission(String username);
    Set<String> getAllMenu();
    Set<String> getAllPermission();
}
