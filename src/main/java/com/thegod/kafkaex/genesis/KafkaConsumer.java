package com.thegod.kafkaex.genesis;

import com.thegod.kafkaex.gov.model.resources.NaturalGasModel;
import org.apache.kafka.clients.consumer.Consumer;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumer<Long, NaturalGasModel> implements IKafkaConsumer<Long, NaturalGasModel>{

    @Override
    public Consumer createConsumer(Properties properties) {

        Consumer<Long, NaturalGasModel> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer(properties);
        consumer.subscribe(Collections.singletonList(properties.getProperty("topic")));

        return consumer;
    }
}
