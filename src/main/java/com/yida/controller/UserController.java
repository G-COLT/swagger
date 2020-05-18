package com.yida.controller;

import com.yida.entity.Result;
import com.yida.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author Anttt
 * @version 1.0
 * @date 2020/5/18
 */
@Api(tags = "用户相关的请求")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @ApiOperation("获取用户信息")
    @GetMapping("/get")
    public String get(){
        return "张三";
    }

    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名")
    })
    @PostMapping("/add")
    public String addUser(String id, String name){
        return name;
    }

    @GetMapping("/getUser")
    public Result getUser(){
        User user = new User("1", "用户");
        Result result = new Result(user,"成功",200);

        return result;
    }

    @ApiOperation("用户")
    @PostMapping(value = "/getUser2")
    public String getUser2(@RequestBody User user){
        System.out.println(user);
        return "你好";
    }
}
