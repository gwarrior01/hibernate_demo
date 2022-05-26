package com.example.demo.oneToMany._orderColumn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    @OrderColumn(name = "address_position", nullable = false)
    private List<Address> knownAddresses = new ArrayList<>();
}
