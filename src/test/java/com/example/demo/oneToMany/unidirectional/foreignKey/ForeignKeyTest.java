package com.example.demo.oneToMany.unidirectional.foreignKey;

import com.example.demo.BaseTest;
import com.example.demo.oneToMany.unidirectional.foreignKey.entity.Address;
import com.example.demo.oneToMany.unidirectional.foreignKey.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

import java.util.Set;

@EntityScan("com.example.demo.oneToMany.unidirectional.foreignKey")
public class ForeignKeyTest extends BaseTest {

    @Test
    @Commit
    void foreignKeyTest() {
        User user = new User();
        user.setFirstName("Alex");

        Address address1 = new Address();
        address1.setStreet("Empty street");

        Address address2 = new Address();
        address2.setStreet("Full street");

        user.getKnownAddresses().add(address1);
        user.getKnownAddresses().add(address2);

        session.persist(user);
    }

    @Sql("/sql/onetomany_lazy_fk_ud.sql")
    @Test
    void unidirectionalForeignKeyTest() {
        User user = session.get(User.class, 1L);
        Set<Address> knownAddresses = user.getKnownAddresses();
    }
}
