package com.backend.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tobitoi on 1/10/18.
 */
public interface ProccesService {
    JSONObject addProcces(JSONObject jsonObject);
    JSONObject listProcces(JSONObject jsonObject);
    JSONObject updateProcces(JSONObject jsonObject);
}
