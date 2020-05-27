package com.simple.generator.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 申涛涛
 * @date 2020/5/26 21:50
 */
@Api(value = "测试类", tags = "测试类")
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "测试", tags = "测试类")
    @RequestMapping("/test1")
    public String test1() {
        return "hello!";
    }
}
