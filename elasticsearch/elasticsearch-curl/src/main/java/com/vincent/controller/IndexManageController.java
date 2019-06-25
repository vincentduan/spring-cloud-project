package com.vincent.controller;

import com.alibaba.fastjson.JSONObject;
import com.vincent.service.IndexManageService;
import com.vincent.utils.ResponseVOUtil;
import com.vincent.vo.ResponseResult;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("indexManage")
public class IndexManageController {
    @Autowired
    IndexManageService indexManageService;

    @PostMapping("{indexName}/{type}")
    public ResponseResult createIndex(@PathVariable("indexName") String indexName, @PathVariable("type") String type, @RequestBody Map<String, String> map) throws Exception {

//        String json = "{\"properties\":{\"userName\":{\"type\":\"keyword\"},\"age\":{\"type\":\"keyword\"}}}";
//        JSONObject jsonObject = JSONObject.parseObject(json);
//        CreateIndexResponse response = indexManageService.createIndex(indexName, type, jsonObject);
        CreateIndexResponse response = indexManageService.createIndex(indexName, type, map);
//        System.out.println(response.isAcknowledged());
        return ResponseVOUtil.success(response);
    }

    @DeleteMapping("{indexName}")
    public ResponseResult deleteIndex(@PathVariable("indexName") String indexName) {
        DeleteIndexResponse deleteIndexResponse = indexManageService.deleteIndex(indexName);
//        System.out.println(deleteIndexResponse.isAcknowledged());
        return ResponseVOUtil.success(deleteIndexResponse);
    }

}
