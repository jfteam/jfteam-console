package org.jfteam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fengwenping
 * Date: 2017-08-30
 * Time: 下午11:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring.kafka.**.configs.xml"})
public class AppTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    @Qualifier("inputToKafka")
    MessageChannel messageChannel;

    @Autowired
    @Qualifier("inputFromKafka")
    PollableChannel pollableChannel;

    @Test
    public void sendMsg() throws Exception {

        for (int i = 0; i < 15; i++) {
            Message<String> message = new GenericMessage<>("test-------------" + (i + 100));
            boolean flag = messageChannel.send(message);

            LOGGER.info(flag + "=============" + (i + 100));
        }
        Message<?> received = pollableChannel.receive(10000);




        while (received != null) {
            LOGGER.info("|||" + received);
            received = pollableChannel.receive(10000);
        }
    }
}