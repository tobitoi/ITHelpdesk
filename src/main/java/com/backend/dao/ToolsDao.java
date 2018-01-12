package com.backend.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Tobitoi on 12/31/17.
 */
public interface ToolsDao {
    int addTools(JSONObject jsonObject);
    int countTools(JSONObject jsonObject);
    List<JSONObject> listTools(JSONObject jsonObject);
    int updateTools(JSONObject jsonObject);
    int deleteTools(JSONObject jsonObject);
    List<JSONObject>listToolsChart(JSONObject jsonObject);
    List<JSONObject> listToolsCategory();
    List<JSONObject> listStatus();

}
