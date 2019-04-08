package com.qbk.util;

import com.qbk.properties.TableProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 *  启动类
 *  @author quboka
 */
@Component
public class ServerStartedRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        loadUnsplitTables();
    }

    /**
     * 加载不分库的表
     */
    private void loadUnsplitTables(){
        try {
            TableProperties tableProperties = SpringContextHolder.getBean("tableProperties");
            String tables = tableProperties.getTables();
            MyPreciseShardingAlgorithm.unsplitTables = Arrays.asList(tables.split(","));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}