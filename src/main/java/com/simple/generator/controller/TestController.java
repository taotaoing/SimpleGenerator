package com.simple.generator.controller;

import com.simple.generator.common.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
        List list = new ArrayList<>();
        PageList pageList = new PageList(list);
        return "hello!";
    }
}
