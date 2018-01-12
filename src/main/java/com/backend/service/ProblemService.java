package com.backend.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tobitoi on 1/10/18.
 */
public interface ProblemService {
    JSONObject addProblem(JSONObject jsonObject);
    JSONObject listProblem(JSONObject jsonObject);
    JSONObject updateProblem(JSONObject jsonObject);
}
