package com.qbk.controller;


import com.qbk.mapper.UserMapper;
import io.shardingsphere.core.constant.properties.ShardingProperties;
import io.shardingsphere.core.jdbc.core.ShardingContext;
import io.shardingsphere.core.jdbc.core.connection.ShardingConnection;
import io.shardingsphere.core.jdbc.core.datasource.ShardingDataSource;
import io.shardingsphere.core.util.DataSourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by 86186 on 2019/1/31.
 */
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper ;

    @Autowired
    private ShardingDataSource dataSource;

    @GetMapping("/test")
    public String test(){

        ShardingConnection connection = dataSource.getConnection();
        Map<String, DataSource> dataSourceMap = dataSource.getDataSourceMap();
        ShardingContext shardingContext = dataSource.getShardingContext();
        ShardingProperties shardingProperties = dataSource.getShardingProperties();

        System.out.println(connection);
        System.out.println(dataSourceMap);
        System.out.println(shardingContext);
        System.out.println(shardingProperties);
        System.out.println("test");
        return "ss";
    }

}
