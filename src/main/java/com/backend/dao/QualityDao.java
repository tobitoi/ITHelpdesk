package com.backend.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Tobitoi on 1/7/18.
 */
public interface QualityDao {
    int addQuality(JSONObject jsonObject);
    int countQuality(JSONObject jsonObject);
    List<JSONObject> listQuality(JSONObject jsonObject);
    int updateQuality(JSONObject jsonObject);
    int deleteQuality(JSONObject jsonObject);
    List<JSONObject>listEmployee();
    List<JSONObject> listTools();
    List<JSONObject>listQualityChart(JSONObject jsonObject);
}
