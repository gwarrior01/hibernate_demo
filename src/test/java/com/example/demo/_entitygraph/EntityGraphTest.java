package com.example.demo._entitygraph;

import com.example.demo.BaseTest;
import com.example.demo._entitygraph.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@EntityScan("com.example.demo._entitygraph")
public class EntityGraphTest extends BaseTest {

    @Autowired
    private PlatformTransactionManager transactionManager;
    private TransactionTemplate transactionTemplate;

    @BeforeEach
    public void setUp() {
        super.setUp();
        transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @Sql("/sql/entityGraph.sql")
    @Test
    void entityGraphLoadTest() {
        User user = session.createQuery("select u from users u where u.id=:id", User.class)
                .setParameter("id", 1L)
                .setHint("javax.persistence.loadgraph", em.getEntityGraph("UserAddressDistrict"))
                .getSingleResult();

    }

    @Sql("/sql/entityGraph.sql")
    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void entityGraphFetchTest() {
        User user = transactionTemplate.execute(status -> {
            return session.createQuery("select u from users u where u.id=:id", User.class)
                    .setParameter("id", 1L)
                    .setHint("javax.persistence.fetchgraph", em.getEntityGraph("UserAddress"))
                    .getSingleResult();
        });

//        user.getKnownAddresses().iterator().next().getDistrict().getTitle();
    }


}
