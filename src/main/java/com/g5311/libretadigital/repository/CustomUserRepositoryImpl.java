package com.g5311.libretadigital.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.g5311.libretadigital.model.User;

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
    public List<User> findByUsernameVulnerable(String username) {
        // **Vulnerable on purpose**: concatenamos la entrada del usuario
        String lower = username == null ? "" : username.toLowerCase();
        String sql = "SELECT * FROM usuarios WHERE LOWER(nombre) LIKE '%" + lower + "%'";
        System.out.println("SQL vulnerable: " + sql);
        return jdbc.query(sql, (rs, rowNum) -> {
            User u = new User();
            u.setAuth0Id(rs.getString("auth0id")); // ajustá si la columna se llama auth0Id o auth0_id
            u.setNombre(rs.getString("nombre"));
            u.setEmail(rs.getString("email"));
            u.setRol(rs.getString("rol"));
            return u;
        });
    }
}