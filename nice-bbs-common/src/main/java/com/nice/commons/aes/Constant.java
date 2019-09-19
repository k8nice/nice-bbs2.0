package com.nice.commons.aes;

import java.util.UUID;

/**
 * jwt相关类
 */
public class Constant {
    public static final String JWT_ID = UUID.randomUUID().toString();

    /**
     * 加密密文
     */
    public static final String JWT_SECRET = "666666666666666";
    public static final int JWT_TTL = 60*60*1000;  //millisecond
}
