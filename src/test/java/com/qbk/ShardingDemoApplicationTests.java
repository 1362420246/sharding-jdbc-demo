package com.qbk;

import com.qbk.entity.UserEntity;
import com.qbk.mapper.UserMapper;
import com.qbk.service.UserService;
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
    private UserService userService ;

	@Autowired
	private UserMapper userMapper ;

	@Test
    public void insert(){
        userService.inser();
    }

    @Test
    public void getUser() {
        List<UserEntity> result1 = userMapper.getUser();
        System.out.println(result1);
    }

}

