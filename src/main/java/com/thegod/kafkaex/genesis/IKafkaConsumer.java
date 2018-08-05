package com.thegod.kafkaex.genesis;

import org.apache.kafka.clients.consumer.Consumer;

import java.util.Properties;

public interface IKafkaConsumer<K, V> {

    public Consumer createConsumer(Properties properties);
}
