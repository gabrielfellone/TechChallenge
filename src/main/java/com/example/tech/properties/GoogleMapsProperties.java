package com.example.tech.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
//@RefreshScope
@ConfigurationProperties("google-maps")
public class GoogleMapsProperties {

    //properties para config do google maps
}
