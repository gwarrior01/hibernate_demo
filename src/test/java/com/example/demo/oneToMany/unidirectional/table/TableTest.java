package com.example.demo.oneToMany.unidirectional.table;

import com.example.demo.BaseTest;
import com.example.demo.oneToMany.unidirectional.table.entity.Address;
import com.example.demo.oneToMany.unidirectional.table.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

import java.util.Set;

@EntityScan("com.example.demo.oneToMany.unidirectional.table")
public class TableTest extends BaseTest {

    @Test
    @Commit
    void unidirectionalTableTest() {
        User user = new User();
        user.setFirstName("Alex");

        Address address = new Address();
        address.setStreet("Empty Street");

        Address address2 = new Address();
        address2.setStreet("Full Street");

        user.getKnownAddresses().add(address);
        user.getKnownAddresses().add(address2);

        session.persist(user);

//        session.flush();
//        user.getKnownAddresses().remove(address);
//
    }

    @Sql("/sql/onetomany_lazy_table_ud.sql")
    @Test
    void unidirectionalTableLazyTest() {
        User user = session.get(User.class, 1L);
        Set<Address> knownAddresses = user.getKnownAddresses();
    }
}
