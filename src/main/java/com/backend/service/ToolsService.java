package com.backend.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tobitoi on 12/31/17.
 */
public interface ToolsService {
    JSONObject addTools(JSONObject jsonObject);
    JSONObject listTools(JSONObject jsonObject);
    JSONObject updateTools(JSONObject jsonObject);
    JSONObject listChart(JSONObject jsonObject);
    JSONObject deleteTools(JSONObject jsonObject);
    JSONObject listToolsCategory();
    JSONObject listStatus();
}
