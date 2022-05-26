package com.example.demo.oneToMany._orderColumn;

import com.example.demo.BaseTest;
import com.example.demo.oneToMany._orderColumn.entity.Address;
import com.example.demo.oneToMany._orderColumn.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;

@EntityScan("com.example.demo.oneToMany._orderColumn.entity")
public class OrderColumnTest extends BaseTest {

    @Test
    @Commit
    void orderColumnTest() {
        User user = new User();
        user.setFirstName("Alex");

        Address address = new Address();
        address.setStreet("Full Street");

        Address address2 = new Address();
        address2.setStreet("Empty Street");

        user.getKnownAddresses().add(address);
        user.getKnownAddresses().add(address2);

        session.persist(user);
    }

}
