package com.zalopay.gameplay.receptionist.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonMapperConfig {
    @Bean
    JsonMapper jsonMapper(){
        return new JsonMapper();
    }
}
