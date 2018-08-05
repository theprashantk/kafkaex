package com.thegod.kafkaex.gov.extractor;

import com.thegod.kafkaex.codetype.DataSourceType;

public interface IDataSource {

    public void registerDataSource();
    public void extractData(IDataSource dataSource);
}
