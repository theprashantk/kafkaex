package com.thegod.kafkaex.util;


import com.thegod.kafkaex.codetype.DataSourceType;
import com.thegod.kafkaex.exception.DataSourceNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Commons {

    public static final String KAFKA_PRODUCER_PROPERTY = "/producer.properties";
    public static final String KAFKA_BROKER_SERVER_PROPERTY_NAME = "kafka.broker.server";
    public static final String KAFKA_CLIENT_SERVER_PROPERTY_NAME = "";
    public static final String KAFKA_CLIENT_ID_PROPERTY_NAME = "kafka.client.id";
    public static final String KAFKA_NATURAL_GAS_TOPIC_PROPERTY_NAME = "naturalgas.topic.name";
    public static final String KAFKA_NATURAL_GAS_DATASRC_PROPERTY_NAME = "naturalgas.datasource.localtion";

    public static Properties readProperty(boolean isResouceProperty, String fileName) throws DataSourceNotFoundException {

        Properties properties =  new Properties();
        try {
            if(isResouceProperty){
                properties.load(Commons.class.getResourceAsStream(KAFKA_PRODUCER_PROPERTY));
            }else{
                properties.load(new FileReader(fileName));
            }

        } catch (IOException e) {
            String message = null;
            if(isResouceProperty){
                message = "SEVERE: Property File " + fileName + " Not Found";
            }
            throw new DataSourceNotFoundException(message);
        }
        return properties;
    }
}
