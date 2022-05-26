package com.example.demo.oneToOne.bidirectional.foreignKey;

import com.example.demo.BaseTest;
import com.example.demo.oneToOne.bidirectional.foreignKey.entity.Address;
import com.example.demo.oneToOne.bidirectional.foreignKey.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

@EntityScan("com.example.demo.oneToOne.bidirectional.foreignKey")
public class ForeignKeyTest extends BaseTest {

    @Test
    @Commit
    void bidirectionalForeignKeyTest() {
        User user = new User();
        user.setFirstName("John");

        Address address = new Address();
        address.setStreet("Empty street");

        user.setAddress(address);
        address.setUser(user);

        session.persist(user);
    }

    @Sql("/sql/onetoone_lazy_fk.sql")
    @Test
    void bidirectionalForeignKeyLazyTest() {
        Address address = session.get(Address.class, 1);
        User user = address.getUser();

//        User user = session.get(User.class, 1L);
//        Address address = user.getAddress();


    }
}
