package com.example.demo.oneToOne.unidirectional.foreignKey;

import com.example.demo.BaseTest;
import com.example.demo.oneToOne.unidirectional.foreignKey.entity.Address;
import com.example.demo.oneToOne.unidirectional.foreignKey.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;

@EntityScan("com.example.demo.oneToOne.unidirectional.foreignKey")
public class ForeignKeyTest extends BaseTest {

    @Test
    @Commit
    void unidirectionalForeignKeyTest() {
        User user = new User();
        user.setFirstName("John");

        Address address = new Address();
        address.setStreet("Empty street");

        user.setAddress(address);

        session.persist(user);
    }

}
