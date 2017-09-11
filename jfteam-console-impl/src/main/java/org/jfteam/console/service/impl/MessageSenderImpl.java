package org.jfteam.console.service.impl;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.jfteam.console.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fengwenping
 * Date: 2017-08-30
 * Time: 下午9:07
 */
@Service
public class MessageSenderImpl implements MessageSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSenderImpl.class);

    private static final String SERIALIZER_CLASS = "kafka.serializer.StringEncoder"; // 序列化类

    public Boolean sendMessage(String topic, String message) throws Exception {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");//kafka服务器
        /**
         * 0表示不等待结果返回<br/>
         * 1表示等待至少有一个服务器返回数据接收标识<br/>
         * -1表示必须接收到所有的服务器返回标识，及同步写入<br/>
         * */
        props.put("request.required.acks", "0");
        /**
         * 内部发送数据是异步还是同步
         * sync：同步, 默认
         * async：异步
         */
        props.put("producer.type", "async");
        /**
         * 设置序列化的类
         * 可选：kafka.serializer.StringEncoder
         * 默认：kafka.serializer.DefaultEncoder
         */
        props.put("serializer.class", SERIALIZER_CLASS);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer(props);
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
        producer.send(record, (recordMetadata, exception) -> {
            if (exception != null) {
                LOGGER.error("kafka发送消息失败.", exception);
                return;
            }
        });
        return Boolean.TRUE;
    }
}
