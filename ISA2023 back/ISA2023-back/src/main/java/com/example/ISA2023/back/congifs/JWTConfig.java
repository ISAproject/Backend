package com.example.ISA2023.back.congifs;

import com.example.ISA2023.back.services.JWTService;
import com.example.ISA2023.back.services.impl.JWTServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfig {
    @Bean
    public JWTService jwtService() {
        return new JWTServiceImpl(); // Assuming JWTServiceImpl implements JWTService
    }
}
