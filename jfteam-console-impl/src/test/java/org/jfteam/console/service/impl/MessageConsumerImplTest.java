package org.jfteam.console.service.impl;

import org.jfteam.console.MessageConsumer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fengwenping
 * Date: 2017-08-30
 * Time: 下午11:11
 */
public class MessageConsumerImplTest {
    @Test
    public void execute() throws Exception {
        MessageConsumer messageConsumer = new MessageConsumerImpl();
        messageConsumer.execute("logger");
    }

}