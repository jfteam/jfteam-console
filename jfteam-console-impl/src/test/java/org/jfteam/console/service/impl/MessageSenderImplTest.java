package org.jfteam.console.service.impl;

import org.jfteam.console.MessageSender;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fengwenping
 * Date: 2017-08-30
 * Time: 下午10:26
 */
public class MessageSenderImplTest {

    @Test
    public void sendMessage() throws Exception {
        MessageSender messageSender = new MessageSenderImpl();
        final Boolean result = messageSender.sendMessage("logger", "test");
    }

}