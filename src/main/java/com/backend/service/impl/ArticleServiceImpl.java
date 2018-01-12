package com.backend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.backend.dao.ArticleDao;
import com.backend.service.ArticleService;
import com.backend.util.CommonUtil;
import com.backend.util.constant.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobitoi on 12/21/17.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addArticle(JSONObject jsonObject) {
        int maxTicket = articleDao.queryMaxTicket();
        maxTicket = maxTicket+1;

        jsonObject.put("ticket",maxTicket);
        articleDao.addArticle(jsonObject);
        System.out.println("==================================");
        System.out.println(jsonObject.getInteger("articleId"));
        System.out.println("==================================");
        return CommonUtil.successJson(maxTicket);
    }


    @Override
    public JSONObject listArticle(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = articleDao.countArticle(jsonObject);
        List<JSONObject> list = articleDao.listArticle(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateArticle(JSONObject jsonObject) {
        articleDao.updateArticle(jsonObject);
        return CommonUtil.successJson();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public JSONObject deleteArticle(JSONObject jsonObject) {
        List<JSONObject> article = (List<JSONObject>) articleDao.listArticle(jsonObject);
        if (article != null && article.size() > 0) {
            return CommonUtil.errorJson(ErrorEnum.E_10008);
        }
        article.remove(jsonObject);
        return CommonUtil.successJson();
    }
}
