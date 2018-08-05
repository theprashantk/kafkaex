package com.thegod.kafkaex.genesis;

import com.thegod.kafkaex.exception.DataSourceNotFoundException;
import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;

public interface IKafkaProducer<K,V> {

    public Producer createProducer(Properties properties);
    public Properties config() throws DataSourceNotFoundException;
}
