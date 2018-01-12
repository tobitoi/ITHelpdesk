package com.backend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.backend.dao.ToolsDao;
import com.backend.service.ToolsService;
import com.backend.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Tobitoi on 12/31/17.
 */
@Service
public class ToolsServiceImpl implements ToolsService {
    @Autowired
    private ToolsDao toolsDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addTools(JSONObject jsonObject) {
        toolsDao.addTools(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listTools(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = toolsDao.countTools(jsonObject);
        List<JSONObject> toolsDaos = toolsDao.listTools(jsonObject);
        return CommonUtil.successPage(jsonObject,toolsDaos,count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateTools(JSONObject jsonObject) {
        toolsDao.updateTools(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listChart(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> toolsChart = toolsDao.listToolsChart(jsonObject);
        return CommonUtil.successPage(toolsChart);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject deleteTools(JSONObject jsonObject) {
        toolsDao.deleteTools(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listToolsCategory() {
        List<JSONObject> category = toolsDao.listToolsCategory();
        return CommonUtil.successPage(category);
    }

    @Override
    public JSONObject listStatus() {
        List<JSONObject> status = toolsDao.listStatus();
        return CommonUtil.successPage(status);
    }
}
