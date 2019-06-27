package com.vincent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vincent on 2019-6-18 21:58
 */
@RestController
public class UserController {

    @GetMapping("/user/{name}")
    public Map<String,Object> getUser(@PathVariable("name") String userName) {
        Map<String,Object> data = new HashMap<>();
        data.put("id",userName);
        data.put("from","provider-A-2");
        return data;
    }

}
