package com.backend.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tobitoi on 12/21/17.
 */
public interface EmployeeService {
    JSONObject addEmployee(JSONObject jsonObject);
    JSONObject listEmployee(JSONObject jsonObject);
    JSONObject updateEmployee(JSONObject jsonObject);
}
