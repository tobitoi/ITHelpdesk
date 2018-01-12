package com.backend.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tobitoi on 12/30/17.
 */
public interface ToolsCategoryService {
    JSONObject addToolsCategory(JSONObject jsonObject);
    JSONObject listToolsCategory(JSONObject jsonObject);
    JSONObject updateToolsCategory(JSONObject jsonObject);
}
