package com.vincent.service;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;

import java.util.Map;

/**
 * Created by vincent on 2019-6-20 16:06
 */
public interface IndexService {

    IndexResponse add(String indexName, String type, Map<String, Object> data);

    UpdateResponse update(String indexName, String type, String docId, Map<String, Object> data);

    DeleteResponse delete(String indexName, String type, String docId);

}
