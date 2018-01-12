package com.backend.controller;

import com.alibaba.fastjson.JSONObject;

import com.backend.service.ProblemService;
import com.backend.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tobitoi on 1/10/18.
 */
@RestController
@RequestMapping("/problems")
public class ProblemsController {

    @Autowired
    private ProblemService problemService;

    @RequiresPermissions("problems:list")
    @GetMapping("/listProblems")
    public JSONObject listProblems(HttpServletRequest request) {
        return problemService.listProblem(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("problems:add")
    @PostMapping("/addProblems")
    public JSONObject addProblems(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "kode,description");
        return problemService.addProblem(requestJson);
    }

    @RequiresPermissions("problems:update")
    @PostMapping("/updateProblems")
    public JSONObject updateProblems(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "kode,description");
        return problemService.updateProblem(requestJson);
    }
}
