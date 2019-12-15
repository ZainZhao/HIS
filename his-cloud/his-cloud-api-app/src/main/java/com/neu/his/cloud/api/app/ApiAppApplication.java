package com.neu.his.cloud.api.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.neu.his.cloud.api.app")
@EnableFeignClients
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableHystrix
public class ApiAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiAppApplication.class,args);
    }
}
