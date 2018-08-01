package com.thegod.kafkaex.basic;


import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.FileReader;

public class SimpleKafkaProducer {


    public static void produceRecords(String recordFile) throws Exception{

        Producer<Long, String> simpleProducer = SimpleProducer.createProducer();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(recordFile));

        String record = null;
        while (( record = bufferedReader.readLine()) != null){

            Long key = (long)record.hashCode();
            ProducerRecord<Long, String> producerRecord = new ProducerRecord<>(IKafkaConstants.TOPIC_NAME, key, record);
            simpleProducer.send(producerRecord);
        }
    }
}
