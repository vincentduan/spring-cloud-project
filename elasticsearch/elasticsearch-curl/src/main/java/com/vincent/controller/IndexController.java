package com.vincent.controller;

import com.vincent.service.IndexService;
import com.vincent.utils.ResponseVOUtil;
import com.vincent.vo.ResponseResult;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by vincent on 2019-6-20 16:05
 */
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @PostMapping("/add/{indexName}/{type}")
    public ResponseResult add(@PathVariable("indexName") String indexName, @PathVariable("type") String type, @RequestBody Map<String, Object> data) {
        IndexResponse add = indexService.add(indexName, type, data);
        System.out.println(ResponseVOUtil.success(add));
        return ResponseVOUtil.success(add);
    }

    @PostMapping("/addstr/{indexName}/{type}")
    public ResponseResult addByStr(@PathVariable("indexName") String indexName, @PathVariable("type") String type, @RequestParam("str") String str) {
        IndexResponse add = indexService.add(indexName, type, str);
        return ResponseVOUtil.success(add);
    }

}
