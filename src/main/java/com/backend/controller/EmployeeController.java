package com.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.backend.service.ArticleService;
import com.backend.service.EmployeeService;
import com.backend.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tobitoi on 12/21/17.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequiresPermissions("employee:list")
    @GetMapping("/listEmployee")
    public JSONObject listEmployee(HttpServletRequest request) {
        return employeeService.listEmployee(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("employee:add")
    @PostMapping("/addEmployee")
    public JSONObject addEmployee(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "userId,name,gender,deptId,street");
        return employeeService.addEmployee(requestJson);
    }

    @RequiresPermissions("employee:update")
    @PostMapping("/updateEmployee")
    public JSONObject updateEmployee(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "userId,name,gender,deptId,street");
        return employeeService.updateEmployee(requestJson);
    }
}
