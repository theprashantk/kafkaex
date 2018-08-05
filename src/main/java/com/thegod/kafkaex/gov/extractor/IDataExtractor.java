package com.thegod.kafkaex.gov.extractor;

import com.thegod.kafkaex.genesis.IKafkaProducer;
import oracle.jvm.hotspot.jfr.Producer;

public interface IDataExtractor {

    public Producer registerProducer(IKafkaProducer kafkaProducer);
    public IDataSource registerDataSource(IDataSource dataSource);
    public void produce();
}
