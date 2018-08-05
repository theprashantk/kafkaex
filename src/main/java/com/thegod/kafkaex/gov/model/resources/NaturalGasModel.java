package com.thegod.kafkaex.gov.model.resources;

import java.util.List;

public class NaturalGasModel {

    private List<NaturalGasConsumption> fields = null;

    private List<List<String>> data = null;

    public List<NaturalGasConsumption> getFields() {
        return fields;
    }

    public void setFields(List<NaturalGasConsumption> fields) {
        this.fields = fields;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}
