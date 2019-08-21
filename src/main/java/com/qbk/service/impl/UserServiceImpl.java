package com.qbk.service.impl;

import com.qbk.entity.UserEntity;
import com.qbk.mapper.UserMapper;
import com.qbk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper ;

    /**
     * ShardingSphere支持将普通的数据库连接池，转换为支持XA事务的连接池，对HikariCP, Druid和DBCP2连接池内置支持，无需额外配置。
     * 其它连接池需要用户实现DataSourceMapConverter的SPI接口进行扩展，可以参考io.shardingsphere.transaction.xa.convert.swap.HikariParameterSwapper的实现。
     *
     * 测试事务回滚 : 不分库，只分表 可以回滚。
     * 测试事务回滚 : 分库，分表 可以回滚。
     * 测试事务回滚 : 分库，不分表 可以回滚。
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void inser() {
        UserEntity user1 = UserEntity.builder().userName("kk").password("123456").build();
        UserEntity user2 = UserEntity.builder().userName("qbk").password("123456").build();
        UserEntity user3 = UserEntity.builder().userName("quboka").password("123456").build();

        int result1 = userMapper.insertUser(user1);
        //异常测试回滚
//        int i = 10/0;
        int result2 = userMapper.insertUser(user2);
        int result3 = userMapper.insertUser(user3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
