package com.example.demo._nplusone.subselect;

import com.example.demo.BaseTest;
import com.example.demo._nplusone.subselect.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@EntityScan("com.example.demo._nplusone.subselect")
public class SubselectTest extends BaseTest {

    @Sql("/sql/nplusone.sql")
    @Test
    void subselectTest() {
        List<User> users = session.createQuery("select u from users u where u.id>:id")
                .setParameter("id", 10L)
                .getResultList();
        users.forEach(u -> u.getKnownAddresses().iterator().next());
    }

}
