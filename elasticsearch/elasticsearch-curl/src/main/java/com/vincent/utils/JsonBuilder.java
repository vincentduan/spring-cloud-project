package com.vincent.utils;

import org.elasticsearch.common.xcontent.*;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by vincent on 2019-6-20 16:15
 */
public class JsonBuilder {

    public static XContentBuilder buildXContentBuilderByMap(Map<String, Object> map) {
        try {
            XContentBuilder xContentBuilder = jsonBuilder().startObject();
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                xContentBuilder.field(key, map.get(key));
            }
            xContentBuilder.endObject();
            return xContentBuilder;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static XContentBuilder buildXContentBuilderByJson(String json_str) {
        try (XContentParser parser = XContentFactory.xContent(XContentType.JSON).createParser(NamedXContentRegistry.EMPTY,json_str)) {
            XContentBuilder builder = jsonBuilder().copyCurrentStructure(parser);
            return builder;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
