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

        UserEntity user1 = UserEntity.builder().userId(3).userName("kk").build();
        UserEntity user2 = UserEntity.builder().userId(4).userName("qbk").build();

        int result1 = userMapper.insertUser(user1);
        int result2 = userMapper.insertUser(user2);
        System.out.println(result1);
        System.out.println(result2);

    }


    @Test
    public void getUser() {

        List<UserEntity> result1 = userMapper.getUser();

        System.out.println(result1);

        List<UserEntity> result2 = userMapper.getUser();

        System.out.println(result2);

    }

}

