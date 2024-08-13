package edu.gdou.pensionlens.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        // 注册自定义的 DoubleSerializer
        module.addSerializer(Double.class, new DoubleSerializer());
        objectMapper.registerModule(module);
        return objectMapper;
    }
}
