package com.example.demo._entitygraph.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "UserAddressDistrict",
                attributeNodes = {
                        @NamedAttributeNode(value = "country"),
                        @NamedAttributeNode(
                                value = "knownAddresses",
                                subgraph = "AddressDistrict"
                        )
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = "AddressDistrict",
                                attributeNodes = {
                                        @NamedAttributeNode("district")
                                }
                        )
                }
        ),
        @NamedEntityGraph(
                name = "UserAddress",
                attributeNodes = {
                        @NamedAttributeNode(value = "country"),
                        @NamedAttributeNode(value = "knownAddresses")
                }
        )
})
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
            mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true
    )
    private Set<Address> knownAddresses = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

}
