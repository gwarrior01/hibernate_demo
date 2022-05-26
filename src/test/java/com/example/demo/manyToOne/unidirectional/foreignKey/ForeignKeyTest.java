package com.example.demo.manyToOne.unidirectional.foreignKey;

import com.example.demo.BaseTest;
import com.example.demo.manyToOne.unidirectional.foreignKey.entity.Address;
import com.example.demo.manyToOne.unidirectional.foreignKey.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;

@EntityScan("com.example.demo.manyToOne.unidirectional.foreignKey")
public class ForeignKeyTest extends BaseTest {

    @Test
    @Commit
    void foreignKeyTest() {
        User user = new User();
        user.setFirstName("Alex");

        Address address = new Address();
        address.setStreet("Empty Street");
        address.setUser(user);

        session.persist(address);
    }
}
