package com.example.demo.oneToOne.unidirectional.sharedPrimaryKey.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @OneToOne(
//            optional = false,
//            fetch = FetchType.LAZY
    )
    @PrimaryKeyJoinColumn
    private Address address;

    public User(Long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
}
