package com.qbk.mapper;


import com.qbk.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    int insertUser(UserEntity userEntity);

    List<UserEntity> getUser();


}