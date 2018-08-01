package com.thegod.kafkaex.basic;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.time.Duration;
import java.util.Iterator;

public class SimpleKafkaConsumer {

    public static void consume() throws Exception{

        Consumer<Long, String> consumer = SimpleConsumer.createConsumer();
        ConsumerRecords<Long, String> records = consumer.poll(Duration.ofMillis(1000));

        Iterator<ConsumerRecord<Long, String>> consumerRecordIterator = records.iterator();

        while (consumerRecordIterator.hasNext()){
            ConsumerRecord<Long, String> record = consumerRecordIterator.next();
            System.out.println(record.key() + " ---> " + record.value());
            consumer.commitAsync();
        }

    }
}
