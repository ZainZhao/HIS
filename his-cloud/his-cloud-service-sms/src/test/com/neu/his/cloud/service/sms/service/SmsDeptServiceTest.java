package com.neu.his.cloud.service.sms.service;

import com.neu.his.cloud.service.sms.ServiceSmsApplication;
import com.neu.his.cloud.service.sms.dto.sms.SmsDeptParam;
import lombok.ToString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Zain
 * @title: SmsDeptServiceTest
 * @projectName his-cloud
 * @description: TODO
 * @date 2019/6/1623:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceSmsApplication.class)
public class SmsDeptServiceTest {
    @Autowired
    SmsDeptService smsDeptService;

    @Test
    public void create(){
        SmsDeptParam smsDeptParam = new SmsDeptParam();
        smsDeptParam.setCatId(2);
        smsDeptParam.setName("新的");
        smsDeptParam.setStatus(1);
        smsDeptParam.setType(2);
        smsDeptParam.setCode("zzzzzz");
        System.out.println(smsDeptService.create(smsDeptParam));
    }


}