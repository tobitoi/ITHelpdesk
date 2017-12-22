package com.backend.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Tobitoi on 12/21/17.
 */
public interface EmployeeDao {
    int addEmployee(JSONObject jsonObject);
    int countEmployee(JSONObject jsonObject);
    List<JSONObject> listEmployee(JSONObject jsonObject);
    int updateEmployee(JSONObject jsonObject);
}
