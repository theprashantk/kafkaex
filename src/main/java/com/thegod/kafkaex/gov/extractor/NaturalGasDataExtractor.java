package com.thegod.kafkaex.gov.extractor;

import com.thegod.kafkaex.basic.IKafkaConstants;
import com.thegod.kafkaex.codetype.DataSourceType;
import com.thegod.kafkaex.exception.DataSourceNotFoundException;
import com.thegod.kafkaex.genesis.IKafkaProducer;
import com.thegod.kafkaex.genesis.NaturalGasKafkaProducer;
import com.thegod.kafkaex.gov.model.resources.NaturalGasModel;
import com.thegod.kafkaex.util.Commons;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class NaturalGasDataExtractor implements IDataExtractor{

    IDataSource naturalGasDataSource;
    IKafkaProducer naturalGasKafkaProducer;
    Properties properties;
    public NaturalGasDataExtractor(IKafkaProducer kafkaProducer, IDataSource dataSource){

        registerProducer(kafkaProducer);
        registerDataSource(dataSource);

    }

    @Override
    public void registerProducer(IKafkaProducer kafkaProducer) {
        naturalGasKafkaProducer = kafkaProducer;
    }

    @Override
    public void registerDataSource(IDataSource dataSource) {
       naturalGasDataSource = dataSource;
    }

    @Override
    public void produce() {
        Producer producer = null;
        try {
             properties = naturalGasKafkaProducer.config();
             producer = naturalGasKafkaProducer.createProducer(properties);
        } catch (DataSourceNotFoundException e) {
            e.printStackTrace();
            return;
        }


        while (true){
            NaturalGasModel naturalGasModel = (NaturalGasModel) naturalGasDataSource.readData();
            Long key = (long)naturalGasModel.hashCode();
            ProducerRecord<Long, NaturalGasModel> producerRecord = new ProducerRecord<>(properties.getProperty(Commons.KAFKA_NATURAL_GAS_TOPIC_PROPERTY_NAME), key, naturalGasModel);
            producer.send(producerRecord);
        }
    }
}
