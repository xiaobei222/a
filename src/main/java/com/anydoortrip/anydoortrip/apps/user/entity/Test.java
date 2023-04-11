//package com.anydoortrip.anydoortrip.apps.user.entity;
//
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//
//@Entity
//@Table(name = "test")
//public class Test implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
//    @Column(name = "user_id")
//    private User userId;
//
//
//    @Column(name = "text")
//    private String text;
//}
