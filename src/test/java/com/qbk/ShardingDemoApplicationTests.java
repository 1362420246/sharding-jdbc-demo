package com.qbk;

import com.qbk.entity.UserEntity;
import com.qbk.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingDemoApplicationTests {

	@Autowired
	private UserMapper userMapper ;

	@Test
	public void insertUser() {

        UserEntity user1 = UserEntity.builder().userName("kk").build();
        UserEntity user2 = UserEntity.builder().userName("qbk").build();
        UserEntity user3 = UserEntity.builder().userName("quboka").build();

        int result1 = userMapper.insertUser(user1);
        int result2 = userMapper.insertUser(user2);
        int result3 = userMapper.insertUser(user3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }


    @Test
    public void getUser() {

        List<UserEntity> result1 = userMapper.getUser();

        System.out.println(result1);

        List<UserEntity> result2 = userMapper.getUser();

        System.out.println(result2);

    }

}

