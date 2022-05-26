package com.example.demo.dirtyChecking;

import com.example.demo.BaseTest;
import com.example.demo.dirtyChecking.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

@EntityScan("com.example.demo.dirtyChecking")
public class DirtyCheckingTest extends BaseTest {

    @Sql("/sql/dirtyChecking.sql")
    @Commit
    @Test
    void dirtyCheckingTest() {
        //DefaultFlushEntityEventListener.dirtyCheck
        User user = session.get(User.class, 1L);
    }

}
