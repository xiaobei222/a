//package com.anydoortrip.anydoortrip.apps.utlis;
//
//import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
//import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestHighLevelClient;
//
//import org.elasticsearch.client.indices.GetIndexResponse;
//import org.elasticsearch.common.xcontent.XContentBuilder;
//import org.elasticsearch.common.xcontent.XContentFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.elasticsearch.client.indices.GetIndexRequest;
//import java.io.IOException;
//import java.util.Arrays;
//
//@Service
//public class ElasticsearchService {
//
//    @Autowired
//    private RestHighLevelClient client;
//
//    public void createIndex() throws IOException {
//        String indexName = "anydoor_trip";
//
//        XContentBuilder builder = XContentFactory.jsonBuilder()
//                .startObject()
//                .startObject("properties")
//                .startObject("id")
//                .field("type", "keyword")
//                .endObject()
//                .startObject("name")
//                .field("type", "text")
//                .endObject()
//                .startObject("create_at")
//                .field("type", "date")
//                .endObject()
//                .startObject("update_at")
//                .field("type", "date")
//                .endObject()
//                .endObject()
//                .endObject();
//
//        CreateIndexRequest request = new CreateIndexRequest(indexName)
//                .mapping(builder.toString());
//
//        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
//
//        if (response.isAcknowledged()) {
//            // handle success
//        } else {
//            // handle failure
//            String errorReason = response.getError().getReason();
//            // 获取更多失败原因信息
//        }
//    }
//    public void listIndexes() throws IOException {
//        // Get the list of indexes
//        GetIndexResponse response = client.indices().get(new GetIndexRequest("*"), RequestOptions.DEFAULT);
//
//        // Print the index names and their basic information
//        Arrays.stream(response.getIndices())
//                .forEach(index -> System.out.println("Index name: " + index));
//    }
//}
