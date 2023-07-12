//package com.ivoyant.customerjourney.utils;
//
//import org.elasticsearch.common.xcontent.XContentBuilder;
//import org.elasticsearch.common.xcontent.XContentFactory;
//
//import java.io.IOException;
//
//public class MappingUtil {
//
//    public XContentBuilder getMappingBuilder(String indexName) throws IOException {
//        XContentBuilder mappingBuilder = XContentFactory.jsonBuilder();
//        if("customer".equalsIgnoreCase(indexName)){
//            mappingBuilder.startObject();
//            mappingBuilder.startObject("properties");
//            mappingBuilder.startObject("id");
//            mappingBuilder.field("type", "text");
//            mappingBuilder.endObject();
//            mappingBuilder.startObject("customerName");
//            mappingBuilder.field("type", "text");
//            mappingBuilder.endObject();
//            mappingBuilder.startObject("phoneNumber");
//            mappingBuilder.field("type", "text");
//            mappingBuilder.endObject();
//            mappingBuilder.endObject();
//            mappingBuilder.endObject();
//        }
//        return mappingBuilder;
//    }
//}
