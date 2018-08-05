package com.thegod.kafkaex.genesis.serdes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class NaturalGasValueSerializer implements org.apache.kafka.common.serialization.Serializer {
    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public byte[] serialize(String s, Object o) {
        try {
            ByteArrayOutputStream byteArrayOutputStreamut = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStreamut);
            objectOutputStream.writeObject(o);
            objectOutputStream.close();
            byte[] b = byteArrayOutputStreamut.toByteArray();
            return b;
        } catch (IOException e) {
            return new byte[0];
        }
    }

    @Override
    public void close() {

    }
}
