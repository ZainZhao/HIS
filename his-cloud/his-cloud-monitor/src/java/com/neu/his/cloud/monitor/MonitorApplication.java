package com.neu.his.cloud.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: MonitorApplication
 * @description: TODO
 * @author 赵煜
 * @date 2019/6/169:15
 */
@EnableEurekaClient
@SpringBootApplication
@EnableAdminServer   //spring boot 监控
public class MonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class,args);
    }
}
