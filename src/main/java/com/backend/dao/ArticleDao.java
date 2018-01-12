package com.backend.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Tobitoi on 12/21/17.
 */
public interface ArticleDao {
    int addArticle(JSONObject jsonObject);
    int countArticle(JSONObject jsonObject);
    List<JSONObject> listArticle(JSONObject jsonObject);
    int updateArticle(JSONObject jsonObject);
    int queryMaxTicket();
}
