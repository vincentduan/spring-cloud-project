package com.vincent.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * @author vincent
 * @time 2019-06-27 22:59
 */
@FeignClient("service-provider-A")
public interface FeignService {
    @GetMapping("/user/{name}")
    Map<String,Object> getUser(@PathVariable("name") String userName);
}
