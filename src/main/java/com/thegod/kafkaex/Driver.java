package com.thegod.kafkaex;

import com.thegod.kafkaex.genesis.IKafkaProducer;
import com.thegod.kafkaex.genesis.NaturalGasKafkaProducer;
import com.thegod.kafkaex.gov.extractor.IDataExtractor;
import com.thegod.kafkaex.gov.extractor.IDataSource;
import com.thegod.kafkaex.gov.extractor.NaturalGasDataExtractor;
import com.thegod.kafkaex.gov.extractor.NaturalGasDataSource;

public class Driver {

    private IDataSource dataSource;
    private IDataExtractor dataExtractor;
    private IKafkaProducer kafkaProducer;

    public static void main(String[] args) {

        Driver driver = new Driver();
        driver.start();

    }


    public void start(){

        dataSource = new NaturalGasDataSource();
        kafkaProducer = new NaturalGasKafkaProducer();
        dataExtractor = new NaturalGasDataExtractor(kafkaProducer, dataSource);

        dataExtractor.produce();
    }
}
