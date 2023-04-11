//package com.anydoortrip.anydoortrip.apps.user.entity;
//
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Entity //这是实体类的注解
//@Table(name = "users") //指定对应的数据库表
//public class User implements Serializable {
//    //implements Serializable 是为了实现序列化，原则上每一个实体类都需要序列化
//
//    @Id //使用Id注解，表明这是主键
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成策略是自增型
//    @Column(name = "id")  //对应数据库的主键名
//    private Integer id;
//    //除了主键需要特殊声明以外，其他的只需要声明对应的列就行，注意name=""必须是数据库里面的字段名称，否则会报错
//    @Column(name = "username")
//    private String username;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "mobile_phone")
//    private String mobilePhone;
//
//    @Column(name = "email")
//    private String email;
//    @Column(name = "openid")
//    private String openid;
//    @Column(name = "password")
//    private String password;
//    @Column(name = "profile_photo")
//    private String profilePhoto;
//    @Column(name = "gender")
//    private Integer gender;
//    @Column(name = "birthday")
//    private LocalDate birthday;
//    @Column(name = "super_user")
//    private Boolean superUser;
//    @Column(name = "create_at")
//    private LocalDateTime createAt;
//    @Column(name = "update_at")
//    private LocalDateTime updateAt;
//    @Column(name = "level")
//    private Integer level;
//    @Column(name = "phone_country_code")
//    private String phoneCountryCode;
//
//    public User(Integer id, String username, String lastName, String firstName, String mobilePhone, String email, String openid, String password, String profilePhoto, Integer gender, LocalDate birthday, Boolean superUser, LocalDateTime createAt, LocalDateTime updateAt, Integer level, String phoneCountryCode) {
//        this.id = id;
//        this.username = username;
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.mobilePhone = mobilePhone;
//        this.email = email;
//        this.openid = openid;
//        this.password = password;
//        this.profilePhoto = profilePhoto;
//        this.gender = gender;
//        this.birthday = birthday;
//        this.superUser = superUser;
//        this.createAt = createAt;
//        this.updateAt = updateAt;
//        this.level = level;
//        this.phoneCountryCode = phoneCountryCode;
//    }
//
//    public User() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getMobilePhone() {
//        return mobilePhone;
//    }
//
//    public void setMobilePhone(String mobilePhone) {
//        this.mobilePhone = mobilePhone;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getOpenid() {
//        return openid;
//    }
//
//    public void setOpenid(String openid) {
//        this.openid = openid;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getProfilePhoto() {
//        return profilePhoto;
//    }
//
//    public void setProfilePhoto(String profilePhoto) {
//        this.profilePhoto = profilePhoto;
//    }
//
//    public Integer getGender() {
//        return gender;
//    }
//
//    public void setGender(Integer gender) {
//        this.gender = gender;
//    }
//
//    public LocalDate getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(LocalDate birthday) {
//        this.birthday = birthday;
//    }
//
//    public Boolean getSuperUser() {
//        return superUser;
//    }
//
//    public void setSuperUser(Boolean superUser) {
//        this.superUser = superUser;
//    }
//
//    public LocalDateTime getCreateAt() {
//        return createAt;
//    }
//
//    public void setCreateAt(LocalDateTime createAt) {
//        this.createAt = createAt;
//    }
//
//    public LocalDateTime getUpdateAt() {
//        return updateAt;
//    }
//
//    public void setUpdateAt(LocalDateTime updateAt) {
//        this.updateAt = updateAt;
//    }
//
//    public Integer getLevel() {
//        return level;
//    }
//
//    public void setLevel(Integer level) {
//        this.level = level;
//    }
//
//    public String getPhoneCountryCode() {
//        return phoneCountryCode;
//    }
//
//    public void setPhoneCountryCode(String phoneCountryCode) {
//        this.phoneCountryCode = phoneCountryCode;
//    }
//}
