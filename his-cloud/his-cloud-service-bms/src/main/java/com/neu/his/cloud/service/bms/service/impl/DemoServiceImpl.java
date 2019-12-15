package com.neu.his.cloud.service.bms.service.impl;


import com.neu.his.cloud.service.bms.service.DemoService;
import org.springframework.stereotype.Service;


@Service
public class DemoServiceImpl implements DemoService {


    @Override
    public void test(){
        System.out.println("zzz");
    }

}
