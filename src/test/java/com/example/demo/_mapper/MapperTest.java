package com.example.demo._mapper;

import com.example.demo.BaseTest;
import com.example.demo._mapper.dto.AuthorStatisticDto;
import com.example.demo._mapper.dto.UserDto;
import com.example.demo._mapper.entity.User;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Map;

@EntityScan("com.example.demo._mapper")
public class MapperTest extends BaseTest {

    @Sql("/sql/mapper.sql")
    @Test
    void mapperTest() {
        User user = session.get(User.class, 1L);
        UserDto userDto = (UserDto) session.createQuery("select u.firstName as firstName, count(a.id) as addressCount " +
                        "from users u left join u.knownAddresses a where u.id=:id group by u.firstName")
                .setParameter("id", 1L)
                .setResultTransformer(Transformers.aliasToBean(UserDto.class))
                .getSingleResult();
    }

    @Sql("/sql/mapper.sql")
    @Test
    void resultSetMappingTest() {
        AuthorStatisticDto authorStatistic = (AuthorStatisticDto) session.createNamedQuery("AuthorStatistic").getSingleResult();
    }

    @Sql("/sql/mapper.sql")
    @Test
    void resultSetToMapTest() {
        Map<String, Object> result = (Map<String, Object>) session.createQuery("select u.firstName as firstName, count(a.id) as addressCount " +
                        "from users u left join u.knownAddresses a where u.id=:id group by u.firstName")
                .setParameter("id", 1L)
                .setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE)
                .uniqueResult();
    }

}
