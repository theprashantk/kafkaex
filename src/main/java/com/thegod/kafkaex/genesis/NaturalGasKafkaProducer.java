package com.thegod.kafkaex.genesis;

import com.thegod.kafkaex.basic.IKafkaConstants;
import com.thegod.kafkaex.exception.DataSourceNotFoundException;
import com.thegod.kafkaex.genesis.serdes.NaturalGasValueSerializer;
import com.thegod.kafkaex.gov.model.resources.NaturalGasModel;
import com.thegod.kafkaex.util.Commons;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class NaturalGasKafkaProducer<Long, NaturalGasModel> implements IKafkaProducer{

    Properties producerProperties;

    @Override
    public Producer createProducer(Properties properties) {
        return new KafkaProducer(properties);
    }


    @Override
    public Properties config() throws DataSourceNotFoundException {

        Properties properties = Commons.readProperty(Boolean.TRUE, Commons.KAFKA_PRODUCER_PROPERTY);
        producerProperties = new Properties();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getProperty(Commons.KAFKA_BROKER_SERVER_PROPERTY_NAME));
        producerProperties.put(ProducerConfig.CLIENT_ID_CONFIG, properties.getProperty(Commons.KAFKA_CLIENT_ID_PROPERTY_NAME));
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, NaturalGasValueSerializer.class.getName());
        producerProperties.put(Commons.KAFKA_NATURAL_GAS_TOPIC_PROPERTY_NAME, properties.getProperty(Commons.KAFKA_NATURAL_GAS_TOPIC_PROPERTY_NAME));

        return producerProperties;
    }
}
