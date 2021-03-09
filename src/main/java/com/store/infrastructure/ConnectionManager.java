package com.store.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConnectionManager {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getConnection(){
        return this.jdbcTemplate;
    }

    public Object queryObject(String query, Object[] inputs, Class clazz){
        return getConnection().queryForObject(query,inputs,Long.class);
    }

}
