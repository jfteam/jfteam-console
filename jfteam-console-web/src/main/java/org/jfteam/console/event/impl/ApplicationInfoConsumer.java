package org.jfteam.console.event.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fengwenping
 * Date: 2017-06-17
 * Time: 下午7:46
 */
@Component("applicationInfoConsumer")
public class ApplicationInfoConsumer implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationInfoConsumer.class);

    public void onMessage(Message message) {
        try {
            logger.info("接收到定时任务发送对消息>>>>  {}", ((TextMessage) message).getText());
        } catch (JMSException e) {
            logger.error("ApplicationInfoConsumer.onMessage() execute has a exception.", e.getStackTrace());
        }
    }
}
