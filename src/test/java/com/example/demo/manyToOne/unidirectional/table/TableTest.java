package com.example.demo.manyToOne.unidirectional.table;

import com.example.demo.BaseTest;
import com.example.demo.manyToOne.unidirectional.table.entity.Address;
import com.example.demo.manyToOne.unidirectional.table.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;

@EntityScan("com.example.demo.manyToOne.unidirectional.table")
public class TableTest extends BaseTest {

    @Test
    @Commit
    void tableTest() {
        User user = new User();
        user.setFirstName("Alex");

        User user2 = new User();
        user2.setFirstName("John");
        session.persist(user2);

        Address address = new Address();
        address.setStreet("Empty Street");
        address.setUser(user);

        session.persist(address);
    }
}
