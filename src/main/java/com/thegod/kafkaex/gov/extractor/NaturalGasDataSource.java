package com.thegod.kafkaex.gov.extractor;

import com.thegod.kafkaex.codetype.DataSourceType;
import com.thegod.kafkaex.exception.DataSourceNotFoundException;
import com.thegod.kafkaex.gov.model.resources.NaturalGasModel;
import com.thegod.kafkaex.util.Commons;

import java.util.Properties;

public class NaturalGasDataSource extends IDataSource{

    public  NaturalGasDataSource(){
        registerDataSource(Commons.KAFKA_NATURAL_GAS_DATASRC_PROPERTY_NAME);
    }

    @Override
    public void registerDataSource(String dataSrc) {
        Properties properties = null;
        try {
            properties = Commons.readProperty(Boolean.TRUE, Commons.KAFKA_PRODUCER_PROPERTY);
            this.dataSrc = properties.getProperty(Commons.KAFKA_NATURAL_GAS_DATASRC_PROPERTY_NAME);
            this.srcType = DataSourceType.JSON;
            this.dataSrcMapperClass = NaturalGasModel.class;
        } catch (DataSourceNotFoundException e) {
            e.printStackTrace();
            return;
        }

    }

    @Override
    public Object extractData(IDataSource dataSource) {
        return null;
    }
}
