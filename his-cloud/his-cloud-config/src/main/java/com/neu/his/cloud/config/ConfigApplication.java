package com.neu.his.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: ConfigApplication
 * @description: TODO
 * @author Zain
 * @date 2019/6/1520:41
 */

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient  //服务的提供者

public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class,args);
    }

}
