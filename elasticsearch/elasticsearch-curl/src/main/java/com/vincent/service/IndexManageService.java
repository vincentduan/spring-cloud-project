package com.vincent.service;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;

import java.util.Map;

/**
 * Created by vincent on 2019-6-20 16:45
 */
public interface IndexManageService {

    /**
     * 创建索引和mapping
     * @param indexName
     * @param type
     * @param mapping key=fieldName, value=type
     * @return
     */
    CreateIndexResponse createIndex(String indexName, String type, Map<String, String> mapping) throws Exception;

    /**
     * 创建索引和mapping ----> 通过JSONObject的方式来创建，更加灵活
     * @param indexName
     * @param type
     * @param jsonObject json 例如：{"properties":{"userName":{"type":"keyword"},"age":{"type":"keyword"}}}
     * @return
     */
    CreateIndexResponse createIndex(String indexName, String type, JSONObject jsonObject);

    /**
     * 仅创建索引
     * @param indexName
     * @return
     */
    CreateIndexResponse createIndex(String indexName);

    /**
     * 删除索引
     * @param indexName
     * @return
     */
    DeleteIndexResponse deleteIndex(String indexName);



}
