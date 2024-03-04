package com.heroku.szallasportal.config;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.username}")
    private String dbUsername;
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        config.setPassword(dbPassword);
        config.setUsername(dbUsername);
        return new HikariDataSource(config);
    }
}