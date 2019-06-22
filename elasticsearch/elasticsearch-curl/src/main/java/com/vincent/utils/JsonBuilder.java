package com.vincent.utils;

import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by vincent on 2019-6-20 16:15
 */
public class JsonBuilder {

    public static XContentBuilder buildJonByMap(Map<String, Object> map){
        try {
            XContentBuilder xContentBuilder = jsonBuilder().startObject();
            Set<String> keySet = map.keySet();
            for(String key: keySet){
                xContentBuilder.field(key, map.get(key));
            }
            xContentBuilder.endObject();
            return xContentBuilder;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
