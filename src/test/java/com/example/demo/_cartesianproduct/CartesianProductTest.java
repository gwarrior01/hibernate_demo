package com.example.demo._cartesianproduct;

import com.example.demo.BaseTest;
import com.example.demo._cartesianproduct.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.context.jdbc.Sql;

@EntityScan("com.example.demo._cartesianproduct")
public class CartesianProductTest extends BaseTest {

    @Sql("/sql/cartesianProduct.sql")
    @Test
    void cartesianProductTest() {
        User user = session.get(User.class, 1L);
    }

}
