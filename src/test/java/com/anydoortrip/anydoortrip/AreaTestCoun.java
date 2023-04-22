//package com.anydoortrip.anydoortrip;
//
//
//
//import com.anydoortrip.anydoortrip.apps.user.mapper.UserMapper;
//import com.anydoortrip.anydoortrip.apps.user.pojo.User;
//import com.anydoortrip.anydoortrip.apps.utlis.BCrypt;
//import com.anydoortrip.anydoortrip.apps.utlis.Jwt;
//import org.apache.http.HttpHost;
//import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
//import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
//import org.elasticsearch.client.*;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//
//@SpringBootTest
//public class AreaTestCoun {
//
//    @Autowired
//    private RestHighLevelClient client;
//
//    @Autowired
//    private UserMapper userMapper;
//    @Test
//    public  void es() throws Exception{
//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));
//
//        CreateIndexRequest createIndexRequest = new CreateIndexRequest("anydoor_trip");
//        CreateIndexResponse createIndexResponse  =  client.indices().create(createIndexRequest,RequestOptions.DEFAULT);
//        //根据索引对象信息创建索引
//        client.close();
//
//
//    }
//    @Test
//    void user(){
//
//
//        User user1 = new User();
//        user1.setUsername("小北");
//        user1.setMobilePhone("17679321910");
//        user1.setPassword("1212121");
//        user1.setCreateAt(LocalDateTime.now());
//        user1.setUpdateAt(LocalDateTime.now());
//        user1.setLevel(1);
//        boolean user = userMapper.addByMobile(user1);
//        BCrypt bCrypt = new BCrypt();
//        String password_hash = bCrypt.get_password_hash(user1.getPassword());
//        System.out.println(password_hash);
//        String token = Jwt.createToken(user1);
//        System.out.println(user);
//        System.out.println(token);
//    }
//
//    }
//
