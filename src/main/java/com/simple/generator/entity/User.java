package com.simple.generator.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 申涛涛
 * @date 2020/5/26 21:51
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String nickname;
    private Integer age;
    private Integer gender;
}
