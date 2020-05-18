package com.yida.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anttt
 * @version 1.0
 * @date 2020/5/18
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @PutMapping("/update")
    public String update(String name){
        return name;
    }


    @DeleteMapping("/del")
    public String del(String name){
        return name;
    }
}
