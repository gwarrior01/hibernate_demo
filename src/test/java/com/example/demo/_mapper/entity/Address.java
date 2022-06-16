package com.example.demo._mapper.entity;

import com.example.demo._mapper.dto.AuthorStatisticDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@NamedNativeQuery(name = "AuthorStatistic",
        query = "SELECT count(id) as authorCount, avg(age) as averageAge FROM authors",
        resultSetMapping = "AuthorStatisticMapping")
@SqlResultSetMapping(
        name = "AuthorStatisticMapping",
        classes = @ConstructorResult(
                targetClass = AuthorStatisticDto.class,
                columns = {
                        @ColumnResult(name = "authorCount", type = int.class),
                        @ColumnResult(name = "averageAge", type = int.class)
                }))
@Entity(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "street")
    private String street;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
