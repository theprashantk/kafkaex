package com.thegod.kafkaex.genesis;

import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;

public interface IKafkaProducer<K,V> {

    public Producer createProducer(Properties properties);
    public Properties config();
}
