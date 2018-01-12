package com.backend.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tobitoi on 1/7/18.
 */
public interface QualityService {
    JSONObject addQuality(JSONObject jsonObject);
    JSONObject listQuality(JSONObject jsonObject);
    JSONObject updateQuality(JSONObject jsonObject);
    JSONObject listEmployee();
    JSONObject deletQuality(JSONObject jsonObject);
    JSONObject listTools();
    JSONObject listChart(JSONObject jsonObject);
}
