package com.backend.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tobitoi on 12/21/17.
 */
public interface PermissionService {
    JSONObject getUserPermission(String username);
}
