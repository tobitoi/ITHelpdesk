package com.backend.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Tobitoi on 1/10/18.
 */
public interface ReporterDao {
    int addReporter(JSONObject jsonObject);
    int countReporter(JSONObject jsonObject);
    List<JSONObject> listReporter(JSONObject jsonObject);
    int updateReporter(JSONObject jsonObject);
}
