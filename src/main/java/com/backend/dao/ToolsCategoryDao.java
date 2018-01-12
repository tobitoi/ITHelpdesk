package com.backend.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Tobitoi on 12/30/17.
 */
public interface ToolsCategoryDao {
    int addToolsCategory(JSONObject jsonObject);
    int countToolsCategory(JSONObject jsonObject);
    List<JSONObject> listToolsCategory(JSONObject jsonObject);
    int updateToolsCategory(JSONObject jsonObject);
}
