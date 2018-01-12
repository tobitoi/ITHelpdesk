package com.backend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.backend.dao.SparePartDao;
import com.backend.service.SparePartService;
import com.backend.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tobitoi on 1/10/18.
 */
@Service
public class SparePartServiceImpl implements SparePartService{

    @Autowired
    private SparePartDao sparePartDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addSparePart(JSONObject jsonObject) {
        sparePartDao.addSparePart(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listSparePart(JSONObject jsonObject) {
       CommonUtil.fillPageParam(jsonObject);
       int count = sparePartDao.countSparePart(jsonObject);
       List<JSONObject> list = sparePartDao.listSparePart(jsonObject);
       return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateSparePart(JSONObject jsonObject) {
        sparePartDao.updateSparePart(jsonObject);
        return CommonUtil.successJson();
    }
}
