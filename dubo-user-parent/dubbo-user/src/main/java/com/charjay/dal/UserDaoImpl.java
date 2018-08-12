package com.charjay.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**

 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    JdbcTemplate userJdbcTemplate;

    public void updateUser() {
        userJdbcTemplate.execute
                ("update user set name='mic',mobile='1378088888'," +
                        "sex='male' where id=4");
    }
}
