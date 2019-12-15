package com.neu.his.cloud.service.dms.component;

import com.neu.his.cloud.service.dms.domain.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQOrderSender {
    private static Logger LOGGER = LoggerFactory.getLogger(RabbitMQOrderSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Long orderId,int type,final long delayTimes){
        //发送信息格式：id&类型（1检查\检验\处置 4草药 5成药）
        String msg = orderId + "&" + type;
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange(),
                                    QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey(),
                                    msg,
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        //给消息设置延迟毫秒值
                         message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                         return message;
                 }
        });
        LOGGER.info("send order message msg:{}",msg);
    }
}