package com.backend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.backend.dao.ProblemsDao;
import com.backend.service.ProblemService;
import com.backend.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tobitoi on 1/10/18.
 */
@Service
public class ProblemsServiceImpl implements ProblemService {

    @Autowired
    private ProblemsDao problemsDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addProblem(JSONObject jsonObject) {
        problemsDao.addProblems(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listProblem(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = problemsDao.countProblems(jsonObject);
        List<JSONObject> list = problemsDao.listProblems(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateProblem(JSONObject jsonObject) {
        problemsDao.updateProblems(jsonObject);
        return CommonUtil.successJson();
    }
}
