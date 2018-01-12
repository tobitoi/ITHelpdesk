package com.backend.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Tobitoi on 1/10/18.
 */
public interface ProccesDao {
    int addProccess(JSONObject jsonObject);
    int countProccess(JSONObject jsonObject);
    List<JSONObject> listProccess(JSONObject jsonObject);
    int updateProccess(JSONObject jsonObject);
}
