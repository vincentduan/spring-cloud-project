package com.vincent.service;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;

import java.util.Map;

/**
 * Created by vincent on 2019-6-20 16:06
 */
public interface IndexService {

    /**
     * 往index中添加数据
     * @param indexName
     * @param type
     * @param data key--value型
     * @return
     */
    IndexResponse add(String indexName, String type, Map<String, Object> data);

    /**
     * 往index中添加数据
     * @param indexName
     * @param type
     * @param json_str json字符串型
     * @return
     */
    IndexResponse add(String indexName, String type, String json_str);

    /**
     * 更新数据
     * @param indexName
     * @param type
     * @param docId
     * @param data key--value型
     * @return
     */
    UpdateResponse update(String indexName, String type, String docId, Map<String, Object> data);

    /**
     *
     * @param indexName
     * @param type
     * @param docId
     * @param json_str json字符串型
     * @return
     */
    UpdateResponse update(String indexName, String type, String docId, String json_str);

    DeleteResponse delete(String indexName, String type, String docId);



}
