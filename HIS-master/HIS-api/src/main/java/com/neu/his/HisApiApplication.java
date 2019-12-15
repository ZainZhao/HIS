package com.neu.his;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@NacosPropertySource(dataId = "HIS-api", autoRefreshed = true)

@SpringBootApplication
@EnableTransactionManagement    //启用事务
@EnableScheduling               //启用定时器
public class HisApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisApiApplication.class, args);
    }

}
