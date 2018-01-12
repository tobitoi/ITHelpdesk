package com.backend.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Tobitoi on 1/10/18.
 */
public interface ProblemsDao {
    int addProblems(JSONObject jsonObject);
    int countProblems(JSONObject jsonObject);
    List<JSONObject> listProblems(JSONObject jsonObject);
    int updateProblems(JSONObject jsonObject);
}
