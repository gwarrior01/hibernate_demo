package com.example.demo.oneToMany._collectionUsing;

import com.example.demo.BaseTest;
import com.example.demo.oneToMany._collectionUsing.entity.Address;
import com.example.demo.oneToMany._collectionUsing.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;

@EntityScan("com.example.demo.oneToMany._collectionUsing")
public class CollectionUsingTest extends BaseTest {

    @Test
    @Commit
    void collectionUsingTest() {
        User user = new User();
        user.setFirstName("Alex");

        Address address = new Address();
        address.setStreet("Full street");
        address.setUser(user);

        user.getKnownAddresses().add(address);
        session.persist(user);
        session.flush();
        session.clear();


        Address address2 = new Address();
        address2.setStreet("New street");
        address2.setUser(user);

        User userFromDb = session.get(User.class, 1L);
        userFromDb.getKnownAddresses().add(address2);
        session.persist(userFromDb);

    }
}
