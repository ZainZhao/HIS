package com.neu.his.cloud.service.dms;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.neu.his.cloud.service.dms")
@EnableEurekaClient
@MapperScan("com.neu.his.cloud.service.dms.mapper")

public class ServiceDmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDmsApplication.class,args);
    }
}
