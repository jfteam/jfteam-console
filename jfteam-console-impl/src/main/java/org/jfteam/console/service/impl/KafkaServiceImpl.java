package org.jfteam.console.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fengwenping
 * Date: 2017-08-30
 * Time: 下午11:31
 */
public class KafkaServiceImpl {

    static final Logger logger = LoggerFactory.getLogger(KafkaServiceImpl.class);

    public void processMessage(Map<String, Map<Integer, String>> msgs) {
        for (Map.Entry<String, Map<Integer, String>> entry :
                msgs.entrySet()) {
            System.out.println("Consumer Message received: ");
            logger.debug("Suchit Topic:" + entry.getKey());
            for (String msg : entry.getValue().values()) {
                logger.info("Suchit Consumed Message: " + msg);
            }
        }
    }
}
