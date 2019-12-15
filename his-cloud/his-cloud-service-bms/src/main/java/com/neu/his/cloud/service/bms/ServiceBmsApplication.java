package com.neu.his.cloud.service.bms;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.neu.his.cloud.service.bms")
@EnableEurekaClient
@MapperScan("com.neu.his.cloud.service.bms.mapper")
public class ServiceBmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceBmsApplication.class,args);
    }
}
