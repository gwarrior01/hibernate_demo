package com.example.demo.oneToMany.unidirectional.table.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    /*
//    По умолчанию используется таблица для OneToMany, если не указать чего-то
//    другого. Без имени таблицы работает. Без JoinTable работает.
    @JoinTable(
            name = "users_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    */
    private Set<Address> knownAddresses = new HashSet<>();
}
