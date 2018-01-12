package com.backend.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Tobitoi on 1/10/18.
 */
public interface SparePartDao {
    int addSparePart(JSONObject jsonObject);
    int countSparePart(JSONObject jsonObject);
    List<JSONObject> listSparePart(JSONObject jsonObject);
    int updateSparePart(JSONObject jsonObject);
}
