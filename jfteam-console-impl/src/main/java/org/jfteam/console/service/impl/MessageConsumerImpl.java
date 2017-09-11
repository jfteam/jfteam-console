package org.jfteam.console.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.jfteam.console.MessageConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fengwenping
 * Date: 2017-08-30
 * Time: 下午10:53
 */
public class MessageConsumerImpl implements MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumerImpl.class);

    @Override
    public Boolean execute(String topic) throws Exception {
        String zookeeper = "localhost:2181";
        String groupId = "test";

        Map<String, Integer> topicMap = new HashMap<>();
        topicMap.put(topic, 2);
        ConsumerConnector consumer = Consumer.createJavaConsumerConnector(createConsumerConfig(zookeeper, groupId));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerStreamsMap = consumer.createMessageStreams(topicMap);
        List<KafkaStream<byte[], byte[]>> streamList = consumerStreamsMap.get(topic);
        for (final KafkaStream<byte[], byte[]> stream : streamList) {
            ConsumerIterator<byte[], byte[]> consumerIte = stream.iterator();
            while (consumerIte.hasNext())
                LOGGER.info("Message from Single Topic :: " + new String(consumerIte.next().message()));
        }
        if (consumer != null)
            consumer.shutdown();
        return null;
    }

    private static ConsumerConfig createConsumerConfig(String zookeeper, String groupId) {
        Properties props = new Properties();
        props.put("zookeeper.connect", zookeeper);
        props.put("group.id", groupId);
        props.put("zookeeper.session.timeout.ms", "500");
        props.put("zookeeper.sync.time.ms", "250");
        props.put("auto.commit.interval.ms", "1000");
        return new ConsumerConfig(props);
    }
}
