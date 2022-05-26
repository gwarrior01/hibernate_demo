package com.example.demo.oneToOne.unidirectional.sharedPrimaryKey;

import com.example.demo.BaseTest;
import com.example.demo.oneToOne.unidirectional.sharedPrimaryKey.entity.Address;
import com.example.demo.oneToOne.unidirectional.sharedPrimaryKey.entity.User;
import org.assertj.core.api.Assertions;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

@EntityScan("com.example.demo.oneToOne.unidirectional.sharedPrimaryKey")
public class SharedPrimaryKeyTest extends BaseTest {

    @Test
    @Commit
    void unidirectionalSharedPrimaryKeyTest() {
        Address address = new Address();
        address.setStreet("Empty street");
        session.persist(address);

        User user = new User(address.getId(), "John");
        user.setAddress(address);

        session.persist(user);
    }

    @Sql("/sql/onetoone_lazy_spk.sql")
    @Test
    void unidirectionalSharedPrimaryKeyLazyTest() {
        User user = session.get(User.class, 1L);
        Assertions.assertThat(Hibernate.isInitialized(user.getAddress())).isTrue();
    }
}
