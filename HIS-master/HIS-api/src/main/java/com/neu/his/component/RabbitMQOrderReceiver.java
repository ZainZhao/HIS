package com.neu.his.component;

import com.neu.his.dms.service.DmsFeeRabbitMQService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "his.order.cancel")
public class RabbitMQOrderReceiver {
    private static Logger LOGGER = LoggerFactory.getLogger(RabbitMQOrderReceiver.class);

    @Autowired
    private DmsFeeRabbitMQService dmsFeeRabbitMQService;

    @RabbitHandler
    public void handle(String msg){
        LOGGER.info("receive order message msg:{}",msg);
        String[] temp = msg.split("&");
        if(temp.length != 2){
            LOGGER.warn("处方单超时处理失败： msg:{}",msg);
            return;
        }
        Long id = new Long(temp[0]);
        int type = Integer.parseInt(temp[1]);
        int handleCount = 0;
        if(type == 4){
            handleCount = dmsFeeRabbitMQService.herbalOutOfTime(id);
        }else if(type == 5){
            handleCount = dmsFeeRabbitMQService.medicineOutOfTime(id);
        }else{
            handleCount = dmsFeeRabbitMQService.nonDrugOutOfTime(id);
        }
        System.out.println("处理结果:" + handleCount);
    }

}
