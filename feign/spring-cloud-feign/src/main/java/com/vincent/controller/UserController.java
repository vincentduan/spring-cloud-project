package com.vincent.controller;

import com.vincent.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author vincent
 * @time 2019-06-27 23:05
 */
@RestController
public class UserController {
    @Autowired
    FeignService feignService;

    @GetMapping("/user/{userName}")
    public Map<String, Object> getUser(@PathVariable("userName") String userName){
        Map<String, Object> user = feignService.getUser(userName);
        System.out.println(user);
        return user;
    }
}
