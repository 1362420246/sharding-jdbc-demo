package com.qbk.entity;

import lombok.Builder;
import lombok.Data;

/**
 * Created by 86186 on 2019/2/1.
 */
@Data
@Builder
public class UserEntity {
    private Long userId ;
    private String userName ;
    private String password ;
}
