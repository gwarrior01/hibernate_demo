package com.example.demo._nplusone.batchfetching;

import com.example.demo.BaseTest;
import com.example.demo._nplusone.batchfetching.entity.Address;
import com.example.demo._nplusone.batchfetching.entity.User;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@EntityScan("com.example.demo._nplusone.batchfetching")
public class BatchFetchingTest extends BaseTest {

    @Sql("/sql/nplusone.sql")
    @Test
    void batchFetchingTest() {
//        List<User> users = session.createQuery("select u from users u").getResultList();
//        users.forEach(u -> u.getKnownAddresses().iterator().next());
        List<Address> addresses = session.createQuery("select a from address a").getResultList();
        addresses.forEach(a -> a.getUser().getFirstName());
    }

}
