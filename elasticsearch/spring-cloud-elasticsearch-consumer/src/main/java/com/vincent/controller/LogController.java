package com.vincent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vincent on 2019-6-20 21:02
 */
@RestController
public class LogController {
    @Autowired
    private RestTemplateBuilder builder;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return builder.build();
    }

    @GetMapping(value = "/log/{username}")
    @ResponseBody
    public Map<String, Object> getUser(@PathVariable("username") String username) {
        Map<String, Object> data = new HashMap<>();
        data.put("userName", "vincent_duan");
        data.put("passwordEn", "123456");
        String indexName = "log";
        String type = "type";
        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity("http://elasticsearch-curl-provider/add/"+indexName+"/" + type, data, Object.class);
        System.out.println(objectResponseEntity.getBody());
        return data;
    }
}
