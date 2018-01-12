package com.backend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.backend.dao.QualityDao;
import com.backend.service.QualityService;
import com.backend.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tobitoi on 1/7/18.
 */
@Service
public class QualityServiceImpl implements QualityService {

    @Autowired
    private QualityDao qualityDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addQuality(JSONObject jsonObject) {
        qualityDao.addQuality(jsonObject);
        return CommonUtil.successJson();
    }

    @Override

    public JSONObject listQuality(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = qualityDao.countQuality(jsonObject);
        List<JSONObject> qualityDaos = qualityDao.listQuality(jsonObject);
        return CommonUtil.successPage(jsonObject,qualityDaos,count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateQuality(JSONObject jsonObject) {
        qualityDao.updateQuality(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listEmployee() {
        List<JSONObject> employee = qualityDao.listEmployee();
        return CommonUtil.successPage(employee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject deletQuality(JSONObject jsonObject) {
        qualityDao.deleteQuality(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listTools() {
        List<JSONObject> tools = qualityDao.listTools();
        return CommonUtil.successPage(tools);
    }

    @Override
    public JSONObject listChart(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> qualityChart = qualityDao.listQualityChart(jsonObject);
        return CommonUtil.successPage(qualityChart);
    }

}
