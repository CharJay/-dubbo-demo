package com.charjay.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**

 */
@Repository
public class OrderDaoImpl implements OrderDao{
    @Autowired
    JdbcTemplate orderJdbcTemplate;

    @Override
    public void insertOrder() {
        orderJdbcTemplate.execute("insert `order`(status,price,order_time) values(1,10,now())");
    }
}
