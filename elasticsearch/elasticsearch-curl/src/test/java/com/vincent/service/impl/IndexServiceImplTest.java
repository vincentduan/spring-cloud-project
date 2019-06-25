package com.vincent.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.vincent.service.IndexService;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IndexServiceImplTest {

    @Autowired
    private IndexService indexService;

    @Autowired
    private BulkProcessor bulkProcessor;

    @Test
    public void update() {
        String str = "{\"userName\": \"sofia\", \"age\": \"27\"}";
        UpdateResponse update = indexService.update("vincent_test", "type", "_lKfjGsBMwGPOzpfqDrX", str);
        System.out.println(update.getResult().toString());
    }

    @Test
    public void test() {
        for(int i = 0; i < 20000; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userName", "tom" + i);
            jsonObject.put("age", i);
            bulkProcessor.add(new IndexRequest("vincent_test", "type").source(jsonObject));
        }
        bulkProcessor.flush();
    }



}