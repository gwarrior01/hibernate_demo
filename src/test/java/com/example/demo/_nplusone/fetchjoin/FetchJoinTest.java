package com.example.demo._nplusone.fetchjoin;

import com.example.demo.BaseTest;
import com.example.demo._nplusone.fetchjoin.entity.Address;
import com.example.demo._nplusone.fetchjoin.entity.User;
import com.example.demo.sqltracker.AssertSqlCount;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@EntityScan("com.example.demo._nplusone.fetchjoin")
public class FetchJoinTest extends BaseTest {

    @Sql("/sql/nplusone.sql")
    @Test
    void fetchJoinTest() {
        List<User> users = session.createQuery("select u from users u left join fetch u.knownAddresses", User.class)
                .getResultList();
        users.forEach(u -> u.getKnownAddresses().iterator().next());
        AssertSqlCount.assertSelectCount(1);
    }

}
