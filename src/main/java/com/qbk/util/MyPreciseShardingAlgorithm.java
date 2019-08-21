package com.qbk.util;


import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;
import java.util.List;

/**
 * 分片策略
 * @author quboka
 */
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    public static List<String> unsplitTables ;

    /**
     *  删除
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
     /*   //数据源名
        for (String dbName : availableTargetNames) {
            //表名
            String logicTableName = shardingValue.getLogicTableName();
            //列名
            //String columnName = shardingValue.getColumnName();
            //值
            //Long value = shardingValue.getValue();
            if (unsplitTables != null && unsplitTables.contains(logicTableName)){
                return dbName;
            } else if(dbName.endsWith(shardingValue.getValue() % 2 + "")) {
                return dbName;
            }
        }
        throw new IllegalArgumentException();*/

        for (String dbName : availableTargetNames) {
            if (availableTargetNames.size() == 1){
                return dbName;
            } else if (dbName.endsWith(shardingValue.getValue() % 2 + "")) {
                return dbName;
            }
        }
        throw new IllegalArgumentException();
    }

}
