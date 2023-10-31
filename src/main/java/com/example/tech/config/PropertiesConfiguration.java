package com.example.tech.config;

import com.example.tech.properties.GoogleMapsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({GoogleMapsProperties.class})
public class PropertiesConfiguration {
}
