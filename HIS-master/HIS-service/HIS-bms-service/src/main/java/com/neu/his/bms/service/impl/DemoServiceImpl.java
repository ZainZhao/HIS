package com.neu.his.bms.service.impl;

import com.neu.his.bms.service.DemoService;
import org.springframework.stereotype.Service;


@Service
public class DemoServiceImpl implements DemoService {


    @Override
    public void test(){
        System.out.println("zzz");
    }

}
