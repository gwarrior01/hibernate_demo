package com.example.demo.oneToOne.bidirectional.sharedPrimaryKeyGenerator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @OneToOne(
//            fetch = FetchType.LAZY,
//            optional = false,
            mappedBy = "user",
            cascade = CascadeType.PERSIST
    )
    private Address address;

    public User(String firstName) {
        this.firstName = firstName;
    }
}
