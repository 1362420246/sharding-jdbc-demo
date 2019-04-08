package com.qbk.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 不分库的表配置
 * @author quboka
 */
@Component
@ConfigurationProperties(prefix="sharding.none")
@PropertySource("classpath:config.properties")
@Data
public class TableProperties {

    private String tables;

}
