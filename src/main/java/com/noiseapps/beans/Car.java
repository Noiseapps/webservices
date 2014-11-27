package com.noiseapps.beans;

import javax.xml.bind.annotation.*;


@XmlRootElement
public class Car {

    private int id;

    private String brandName;

    private String modelName;

    public Car() {

    }

    public Car(int id, String brandName, String modelName) {
        this.id = id;
        this.brandName = brandName;
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }

    @XmlElement
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @XmlElement
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
