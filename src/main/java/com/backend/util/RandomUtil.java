package com.backend.util;

import java.util.UUID;

/**
 * Created by Tobitoi on 12/21/17.
 */
public class RandomUtil {

    public static String genarateId(String prefix) {
        String uuid = prefix + UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }
}
