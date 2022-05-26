package com.example.demo.oneToOne.bidirectional.foreignKey.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "street")
    private String street;
    @OneToOne(
            mappedBy = "address",
            fetch = FetchType.LAZY
    )
//    @JoinColumn(name = "user_id")
    private User user;
}
