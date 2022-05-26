package com.example.demo;

import com.example.demo.sqltracker.AssertSqlCount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.example.demo.sqltracker.QueryCountInfoHolder.getQueryInfo;

@SpringBootTest
@Transactional
public abstract class BaseTest {

    @PersistenceContext
    protected EntityManager em;
    protected Session session;

    @BeforeEach
    public void setUp() {
        AssertSqlCount.reset();
        session = em.unwrap(Session.class);
    }

    @AfterTransaction
    public void showSqlCount() {
        System.out.print("\nSql count: " + getQueryInfo().countAll());
    }

    protected SessionFactory getSessionFactory() {
        return session.getSessionFactory();
    }

}
