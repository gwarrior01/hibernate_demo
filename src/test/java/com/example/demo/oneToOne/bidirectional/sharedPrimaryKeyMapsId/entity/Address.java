package com.example.demo.oneToOne.bidirectional.sharedPrimaryKeyMapsId.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity(name = "address")
@Getter
@Setter
public class Address {

    @Id
    private Long id;
    @Column(name = "street")
    private String street;
    @OneToOne()
    @MapsId()
    @JoinColumn(name = "id")
    private User user;
}
