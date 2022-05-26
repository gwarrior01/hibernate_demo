package com.example.demo.lazyExtra;

import com.example.demo.BaseTest;
import com.example.demo.lazyExtra.entity.Address;
import com.example.demo.lazyExtra.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.context.jdbc.Sql;

@EntityScan("com.example.demo.lazyExtra")
public class LazyExtraTest extends BaseTest {

    @Sql("/sql/lazyExtra.sql")
    @Test
    void lazyExtraTest() {
        User user = session.get(User.class, 1L);
        int size = user.getKnownAddresses().size();
        Address firstAddress = user.getKnownAddresses().iterator().next();
    }

}
