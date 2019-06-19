package com.vincent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vincent on 2019-6-19 19:09
 */
@RestController
public class ConsumerController {

    // 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例
    @Autowired
    private RestTemplateBuilder builder;

    @Autowired
    private RestTemplate restTemplate;

    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return builder.build();
    }

    /**
     * Rest服务端使用RestTemplate发起http请求,然后得到数据返回给前端
     * @param username
     * @return
     */
    @GetMapping(value = "/gotoUser/{username}")
    @ResponseBody
    public Map<String, Object> getUser(@PathVariable("username") String username) {
        Map<String, Object> data = new HashMap<>();
        /**
         * 地址是http://service-provider
         * 而不是http://127.0.0.1:8082/
         * 因为他向注册中心注册了服务，服务名称service-provider-A,我们访问service-provider-A即可
         */
        data = restTemplate.getForObject("http://service-provider-A/user/" + username, Map.class);
        return data;
    }

}
