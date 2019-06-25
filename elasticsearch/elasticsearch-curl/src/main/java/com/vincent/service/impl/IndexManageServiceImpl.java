package com.vincent.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.vincent.service.IndexManageService;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class IndexManageServiceImpl implements IndexManageService {

    @Autowired
    Client client;

    @Override
    public CreateIndexResponse createIndex(String indexName, String type, Map<String, String> mapping) throws Exception {
        CreateIndexRequestBuilder createIndexRequestBuilder = client.admin().indices().prepareCreate(indexName);
        XContentBuilder properties = XContentFactory.jsonBuilder().startObject().startObject("properties");
        Set<String> keys = mapping.keySet();
        for (String key : keys) {
            String value = mapping.get(key);
            properties.startObject(key).field("type", value).endObject();
        }
        properties.endObject().endObject();
        createIndexRequestBuilder.addMapping(type, properties);
        CreateIndexResponse createIndexResponse = createIndexRequestBuilder.get();
        return createIndexResponse;
    }

    @Override
    public CreateIndexResponse createIndex(String indexName, String type, JSONObject jsonObject) {
        CreateIndexRequestBuilder createIndexRequestBuilder = client.admin().indices().prepareCreate(indexName);
        createIndexRequestBuilder.addMapping(type, jsonObject);
        CreateIndexResponse createIndexResponse = createIndexRequestBuilder.get();
        return createIndexResponse;
    }

    @Override
    public CreateIndexResponse createIndex(String indexName) {
        CreateIndexRequestBuilder createIndexRequestBuilder = client.admin().indices().prepareCreate(indexName);
        CreateIndexResponse createIndexResponse = createIndexRequestBuilder.get();
        return createIndexResponse;
    }

    @Override
    public DeleteIndexResponse deleteIndex(String indexName) {
        DeleteIndexRequestBuilder deleteIndexRequestBuilder = client.admin().indices().prepareDelete(indexName);
        DeleteIndexResponse deleteIndexResponse = deleteIndexRequestBuilder.get();
        return deleteIndexResponse;
    }
}
