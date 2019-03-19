package com.qbk.util;

import io.shardingsphere.core.keygen.KeyGenerator;

/**
 *  自定义 主键生成
 */
public class IdKeyGenerator implements KeyGenerator {

    private static Integer id = 20;

    @Override
    public Number generateKey() {
        return id++;
    }
}
