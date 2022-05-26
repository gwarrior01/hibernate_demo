package com.example.demo.manyToMany.unidirectional;

import com.example.demo.BaseTest;
import com.example.demo.manyToMany.unidirectional.entity.Address;
import com.example.demo.manyToMany.unidirectional.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;

@EntityScan("com.example.demo.manyToMany.unidirectional")
public class UniManyToManyTest extends BaseTest {

    @Test
    @Commit
    void uniManyToManyTest() {
        User user = new User();
        user.setFirstName("Alex");

        Address address = new Address();
        address.setStreet("Empty street");

        Address address2 = new Address();
        address2.setStreet("Full street");

        user.getDeliveryAddresses().add(address);
        user.getDeliveryAddresses().add(address2);

        session.persist(user);
    }
}
