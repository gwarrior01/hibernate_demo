package com.example.demo.oneToOne.bidirectional.sharedPrimaryKeyGenerator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "address")
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(generator = "addressKeyGenerator")
    @GenericGenerator(
            name = "addressKeyGenerator",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user")
    )
    private Long id;
    @Column(name = "street")
    private String street;
    @OneToOne(
            optional = false
    )
    @PrimaryKeyJoinColumn
    private User user;

    public Address(User user) {
        this.user = user;
    }
}
