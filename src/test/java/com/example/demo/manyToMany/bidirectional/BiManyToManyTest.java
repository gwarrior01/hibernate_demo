package com.example.demo.manyToMany.bidirectional;

import com.example.demo.BaseTest;
import com.example.demo.manyToMany.bidirectional.entity.Address;
import com.example.demo.manyToMany.bidirectional.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

@EntityScan("com.example.demo.manyToMany.bidirectional")
public class BiManyToManyTest extends BaseTest {

    @Test
    @Commit
    void biManyToManyTest() {
        User user = new User();
        user.setFirstName("Alex");

        User user2 = new User();
        user2.setFirstName("John");

        Address address = new Address();
        address.setStreet("Full street");

        Address address2 = new Address();
        address2.setStreet("Empty street");

        user.getDeliveryAddresses().add(address);
        user.getDeliveryAddresses().add(address2);

        session.persist(user);
        session.persist(user2);
    }

    @Sql("/sql/manytomany_bd.sql")
    @Test
    @Commit
    void removeTest() {
        User user = session.get(User.class, 1L);
        Address address = user.getDeliveryAddresses().iterator().next();
        user.getDeliveryAddresses().remove(address);
    }
}
