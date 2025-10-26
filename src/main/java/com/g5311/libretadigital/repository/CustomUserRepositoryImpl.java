package com.g5311.libretadigital.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JdbcTemplate jdbc;

    public CustomUserRepositoryImpl(DataSource ds) {
        this.jdbc = new JdbcTemplate(ds);
    }

    @Override
    public List<Map<String, Object>> findByUsernameVulnerable(String username) {
        // **Vulnerable on purpose**: concatenamos la entrada del usuario
        String sql = "SELECT * FROM usuarios WHERE nombre = '" + username + "'";
        return jdbc.queryForList(sql);
    }
}