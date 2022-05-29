package edu.sesame.bank;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

@Data
@ConfigurationProperties(prefix = "bank", ignoreUnknownFields = false)
public class BankProperties {

    private CorsConfiguration cors;

}
