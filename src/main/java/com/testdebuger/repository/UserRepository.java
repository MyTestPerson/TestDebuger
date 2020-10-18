package com.testdebuger.repository;

import com.testdebuger.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final
    JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public User getUserDetailEmailPasswordEnabled(String email) {

        String sql = "SELECT email, password, enabled FROM user WHERE email=?";

        return jdbcTemplate.queryForObject(sql, new UserMapper(), email);
    }


}
