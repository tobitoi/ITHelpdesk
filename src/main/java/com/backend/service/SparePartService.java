package com.backend.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tobitoi on 1/10/18.
 */
public interface SparePartService {
    JSONObject addSparePart(JSONObject jsonObject);
    JSONObject listSparePart(JSONObject jsonObject);
    JSONObject updateSparePart(JSONObject jsonObject);
}
