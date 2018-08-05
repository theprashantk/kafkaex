package com.thegod.kafkaex.gov.extractor;

import com.thegod.kafkaex.genesis.IKafkaProducer;
import oracle.jvm.hotspot.jfr.Producer;

public interface IDataExtractor {

    public void registerProducer(IKafkaProducer kafkaProducer);
    public void registerDataSource(IDataSource dataSource);
    public void produce();
}
