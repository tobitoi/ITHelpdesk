package com.backend.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tobitoi on 1/10/18.
 */
public interface ReporterService {
    JSONObject addReporter(JSONObject jsonObject);
    JSONObject listReporter(JSONObject jsonObject);
    JSONObject updateReporter(JSONObject jsonObject);
    JSONObject uploadImage(JSONObject jsonObject);
}
