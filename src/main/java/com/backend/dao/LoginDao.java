package com.backend.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Tobitoi on 12/21/17.
 */
public interface LoginDao {
    JSONObject getUser(@Param("username") String username, @Param("password") String password);
}
