package com.thegod.kafkaex.gov.extractor;

import com.google.gson.Gson;
import com.thegod.kafkaex.codetype.DataSourceType;

import java.io.FileNotFoundException;
import java.io.FileReader;

public abstract class IDataSource {

    String dataSrc;
    DataSourceType srcType;
    Class dataSrcMapperClass;

    abstract public void registerDataSource(String dataSrc);
    abstract public Object extractData(IDataSource dataSource);

    public Object readData(){

        if(srcType == DataSourceType.JSON){
            Gson gson = new Gson();

            try {
                System.out.println(dataSrc + "--" + dataSrcMapperClass);
                return gson.fromJson(new FileReader(dataSrc), dataSrcMapperClass);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
