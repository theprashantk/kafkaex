package com.thegod.kafkaex.genesis;

import com.thegod.kafkaex.gov.model.resources.NaturalGasModel;
import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;

public class KafkaProducer implements IKafkaProducer<Long, NaturalGasModel>{

    @Override
    public Producer createProducer(Properties properties) {
        return new org.apache.kafka.clients.producer.KafkaProducer(properties);
    }
}
