package com.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.backend.service.ProccesService;
import com.backend.service.SparePartService;
import com.backend.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tobitoi on 1/10/18.
 */
@RestController
@RequestMapping("/proccess")
public class ProccessController {

    @Autowired
    private ProccesService proccesService;

    @RequiresPermissions("proccess:list")
    @GetMapping("/listProccess")
    public JSONObject listProccess(HttpServletRequest request) {
        return proccesService.listProcces(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("proccess:add")
    @PostMapping("/addProccess")
    public JSONObject addProccess(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "kode,description");
        return proccesService.addProcces(requestJson);
    }

    @RequiresPermissions("proccess:update")
    @PostMapping("/updateProccess")
    public JSONObject updateProccess(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "kode,description");
        return proccesService.updateProcces(requestJson);
    }
}
