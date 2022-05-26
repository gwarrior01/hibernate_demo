package com.example.demo.oneToMany.bidirectional.table;

import com.example.demo.BaseTest;
import com.example.demo.oneToMany.bidirectional.table.entity.Address;
import com.example.demo.oneToMany.bidirectional.table.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

@EntityScan("com.example.demo.oneToMany.bidirectional.table")
public class TableTest extends BaseTest {

    @Test
    @Commit
    void bidirectionalTableTest() {
        User user = new User();
        user.setFirstName("John");

        Address address = new Address();
        address.setStreet("Empty street");

        Address address2 = new Address();
        address2.setStreet("Full street");

        user.getKnownAddresses().add(address);
        user.getKnownAddresses().add(address2);
        address.setUser(user);
        address2.setUser(user);

        session.persist(user);
    }

    @Sql("/sql/onetomany_lazy_table_bd.sql")
    @Test
    void bidirectionalTableLazyTest() {
        Address address = session.get(Address.class, 1);
        User user = address.getUser();
    }

}
