package com.vincent.controller;

import com.vincent.service.IndexService;
import com.vincent.utils.ResponseVOUtil;
import com.vincent.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by vincent on 2019-6-20 16:05
 */
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @PostMapping("/add/{index}/{type}")
    public ResponseResult add(@RequestBody Map<String, String> data) {
        System.out.println(data);
        return ResponseVOUtil.success("success");
    }

}
