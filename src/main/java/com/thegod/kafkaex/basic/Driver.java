package com.thegod.kafkaex.basic;

public class Driver {

    public static void main(String[] args) throws Exception{

        SimpleKafkaProducer.produceRecords("/Users/thegod/Downloads/songs/SampleTextFile_1000kb.txt");
        SimpleKafkaConsumer.consume();

    }
}
