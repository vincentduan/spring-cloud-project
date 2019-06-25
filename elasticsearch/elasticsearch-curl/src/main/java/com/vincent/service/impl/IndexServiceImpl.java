package com.vincent.service.impl;

import com.vincent.service.IndexService;
import com.vincent.utils.JsonBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by vincent on 2019-6-20 16:06
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    Client client;

    @Override
    public IndexResponse add(String indexName, String type, Map<String, Object> data) {
        XContentBuilder xContentBuilder = JsonBuilder.buildXContentBuilderByMap(data);
        IndexResponse indexResponse = client.prepareIndex(indexName, type).setSource(xContentBuilder).get();
        return indexResponse;
    }

    @Override
    public IndexResponse add(String indexName, String type, String json_str) {
        XContentBuilder xContentBuilder = JsonBuilder.buildXContentBuilderByJson(json_str);
        IndexResponse indexResponse = client.prepareIndex(indexName, type).setSource(xContentBuilder).get();
        return indexResponse;
    }

    @Override
    public UpdateResponse update(String indexName, String type, String docId, Map<String, Object> data) {
        XContentBuilder xContentBuilder = JsonBuilder.buildXContentBuilderByMap(data);
        UpdateResponse updateResponse = client.prepareUpdate(indexName, type, docId).setDoc(xContentBuilder).get();
        return updateResponse;
    }

    @Override
    public UpdateResponse update(String indexName, String type, String docId, String json_str) {
        XContentBuilder xContentBuilder = JsonBuilder.buildXContentBuilderByJson(json_str);
        UpdateResponse updateResponse = client.prepareUpdate(indexName, type, docId).setDoc(xContentBuilder).get();
        return updateResponse;
    }

    @Override
    public DeleteResponse delete(String indexName, String type, String docId) {
        DeleteResponse response = client.prepareDelete(indexName, type, docId).get();
        return response;
    }


}
