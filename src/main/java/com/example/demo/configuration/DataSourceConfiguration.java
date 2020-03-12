package com.example.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@Primary
@ConfigurationProperties(prefix = "datasource.primary")
public class DataSourceConfiguration {
    DataSource provideDataSource() {
        return DataSourceBuilder.create().build();
    }
}
