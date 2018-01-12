package com.backend.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Tobitoi on 12/21/17.
 */
public interface ArticleService {
    JSONObject addArticle(JSONObject jsonObject);
    JSONObject listArticle(JSONObject jsonObject);
    JSONObject updateArticle(JSONObject jsonObject);
    JSONObject deleteArticle(JSONObject jsonObject);
}
