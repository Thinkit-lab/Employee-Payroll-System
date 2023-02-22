package com.devlon.payroll.jwt;

import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import javax.crypto.SecretKey;

@Configuration
@ConfigurationProperties(prefix = "application.jwt")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class JwtConfig {
       private String secretKey;
       private String tokenPrefix;
       private Integer tokenExpirationAfterDays;

       public String getAuthorizationHeader() {
           return HttpHeaders.AUTHORIZATION;
       }
}
