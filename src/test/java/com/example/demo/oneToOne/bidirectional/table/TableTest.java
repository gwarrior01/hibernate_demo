package com.example.demo.oneToOne.bidirectional.table;

import com.example.demo.BaseTest;
import com.example.demo.oneToOne.bidirectional.table.entity.Address;
import com.example.demo.oneToOne.bidirectional.table.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

@EntityScan("com.example.demo.oneToOne.bidirectional.table")
public class TableTest extends BaseTest {

    @Test
    @Commit
    void bidirectionalTableTest() {
        User user = new User();
        user.setFirstName("John");

        session.persist(user);

        Address address = new Address();
        address.setStreet("Empty street");

//        session.persist(address);

        User otherUser = new User();
        otherUser.setFirstName("Mike");
        otherUser.setShippingAddress(address);
        address.setUser(otherUser);

        session.persist(otherUser);
    }

    @Sql("/sql/onetoone_lazy_table.sql")
    @Test
    void unidirectionalTableLazyTest() {
//        User user = session.get(User.class, 1L);
//        Address shippingAddress = user.getShippingAddress();

        Address address = session.get(Address.class, 2);
        User user = address.getUser();
    }

}
