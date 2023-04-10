package com.anydoortrip.anydoortrip.apps.User.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity //这是实体类的注解
@Table(name = "users") //指定对应的数据库表
public class User implements Serializable {
    //implements Serializable 是为了实现序列化，原则上每一个实体类都需要序列化

    @Id //使用Id注解，表明这是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成策略是自增型
    @Column(name = "id")  //对应数据库的主键名
    private long id;
    //除了主键需要特殊声明以外，其他的只需要声明对应的列就行，注意name=""必须是数据库里面的字段名称，否则会报错
    @Column(name = "username")
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User() {
    }

    public User(long id, String username) {
        this.id = id;
        this.username = username;
    }
}
