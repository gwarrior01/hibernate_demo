package com.example.demo.lazyInitialization;

import com.example.demo.BaseTest;
import com.example.demo.lazyInitialization.entity.Address;
import com.example.demo.lazyInitialization.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Set;

@EntityScan("com.example.demo.lazyInitialization")
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class LazyInitializationTest extends BaseTest {

    @Autowired
    private PlatformTransactionManager transactionManager;
    private TransactionTemplate transactionTemplate;

    @BeforeEach
    public void setUp() {
        super.setUp();
        transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @Sql("/sql/onetomany_lazy_fk_bd.sql")
    @Test
    void bidirectionalForeignKeyLazyTest() {
        User userEntity = transactionTemplate.execute(status -> {
            User user = session.get(User.class, 1L);
            status.setRollbackOnly();
            return user;
        });
//        userEntity.getKnownAddresses().size();

        Set<Address> adresses = transactionTemplate.execute(status -> {
            Set<Address> knownAddresses = userEntity.getKnownAddresses();
            return knownAddresses;
        });
        adresses.size();
    }

}
