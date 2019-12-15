package com.neu.his.cloud.service.pms;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.neu.his.cloud.service.pms")
@EnableEurekaClient
@MapperScan("com.neu.his.cloud.service.pms.mapper")
public class ServicePmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicePmsApplication.class,args);
    }
}
