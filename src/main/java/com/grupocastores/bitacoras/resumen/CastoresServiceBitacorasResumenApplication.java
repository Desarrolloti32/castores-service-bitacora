package com.grupocastores.bitacoras.resumen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EntityScan({ "com.grupocastores.bitacoras.resumen.DTO", "com.grupocastores.bitacoras.resumen.service.domain"})
public class CastoresServiceBitacorasResumenApplication {

    public static void main(String[] args) {
        SpringApplication.run(CastoresServiceBitacorasResumenApplication.class, args);
    }

}
