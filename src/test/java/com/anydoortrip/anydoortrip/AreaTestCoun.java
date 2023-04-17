package com.anydoortrip.anydoortrip;



import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
public class AreaTestCoun {

    @Autowired
    private RestHighLevelClient client;


    @Test
    public  void es() throws Exception{
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));

        CreateIndexRequest createIndexRequest = new CreateIndexRequest("anydoor_trip");
        CreateIndexResponse createIndexResponse  =  client.indices().create(createIndexRequest,RequestOptions.DEFAULT);
        //根据索引对象信息创建索引
        client.close();



    }


    }

