package com.qbk.util;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.HostNameIdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.IPIdGenerator;
import io.shardingsphere.core.keygen.KeyGenerator;

import java.util.HashSet;
import java.util.Set;

/**
 *  自定义 主键生成
 */
public class IdKeyGenerator implements KeyGenerator {

    /**
     * 当当
     */
    private static IdGenerator idGenerator1 = new CommonSelfIdGenerator();
    private static IdGenerator idGenerator2 = new IPIdGenerator();
    private static IdGenerator idGenerator3 = new HostNameIdGenerator();
    /**
     * 雪花算法(snowflake)
     */
    private static SnowFlakeGenerator snowFlakeGenerator = new  SnowFlakeGenerator.Factory().create(0,0);

    @Override
    public Number generateKey() {
//        return idGenerator1.generateId();
//        return idGenerator2.generateId();
//        return idGenerator3.generateId();
        return snowFlakeGenerator.nextId();
    }

    public static void main(String[] args) throws InterruptedException {
        //测试是否有一样的
        Set ids = new HashSet<>();
        for (int i = 0; i < 10; i++) {
//            Number id = idGenerator3.generateId();
            Number id = snowFlakeGenerator.nextId();
            ids.add(id);
            System.out.println(id);
            //测试是否都是偶数
            Thread.sleep(1);
        }
        System.out.println(ids.size());
    }

}
