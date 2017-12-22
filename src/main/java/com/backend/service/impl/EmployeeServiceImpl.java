package com.backend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.backend.dao.EmployeeDao;
import com.backend.service.EmployeeService;
import com.backend.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tobitoi on 12/21/17.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addEmployee(JSONObject jsonObject) {
        employeeDao.addEmployee(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listEmployee(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = employeeDao.countEmployee(jsonObject);
        List<JSONObject> list = employeeDao.listEmployee(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateEmployee(JSONObject jsonObject) {
        employeeDao.updateEmployee(jsonObject);
        return CommonUtil.successJson();
    }
}
