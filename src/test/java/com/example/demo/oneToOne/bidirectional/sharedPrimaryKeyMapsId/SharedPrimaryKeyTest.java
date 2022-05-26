package com.example.demo.oneToOne.bidirectional.sharedPrimaryKeyMapsId;

import com.example.demo.BaseTest;
import com.example.demo.oneToOne.bidirectional.sharedPrimaryKeyMapsId.entity.Address;
import com.example.demo.oneToOne.bidirectional.sharedPrimaryKeyMapsId.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

@EntityScan("com.example.demo.oneToOne.bidirectional.sharedPrimaryKeyMapsId")
public class SharedPrimaryKeyTest extends BaseTest {

    @Test
    @Commit
    void bidirectionalSharedPrimaryMapsIdTest() {
        User user = new User("John");

        Address address = new Address();
        address.setStreet("Empty street");

        user.setAddress(address);
        address.setUser(user);

        session.persist(user);
    }

    @Sql("/sql/onetoone_lazy_spk_bd.sql")
    @Test
    void bidirectionalSharedPrimaryKeyGeneratorLazyTest() {
        User user = session.get(User.class, 1L);
        Address address = user.getAddress();

//        Address address = session.get(Address.class, 1L);
//        User user = address.getUser();
    }
}
