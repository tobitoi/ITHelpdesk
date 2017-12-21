package com.backend.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tobitoi on 12/21/17.
 */
public interface LoginService {
    JSONObject authLogin(JSONObject jsonObject);
    JSONObject getUser(String username, String password);
    JSONObject getInfo();
    JSONObject logout();
}
