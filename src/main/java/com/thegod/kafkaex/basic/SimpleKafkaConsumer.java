package com.thegod.kafkaex.basic;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.time.Duration;
import java.util.Iterator;

public class SimpleKafkaConsumer {

    public static void consume() throws Exception{

        Consumer<Long, String> consumer = SimpleConsumer.createConsumer();
        while (true){
            ConsumerRecords<Long, String> records = consumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord record: records){
                System.out.println(record.key() + " ---> " + record.value());
                consumer.commitAsync();
            }
        }

    }
}
