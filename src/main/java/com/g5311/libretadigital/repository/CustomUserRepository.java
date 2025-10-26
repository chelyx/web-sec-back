package com.g5311.libretadigital.repository;

import java.util.List;
import java.util.Map;

public interface CustomUserRepository {
    List<Map<String, Object>> findByUsernameVulnerable(String username);
}
