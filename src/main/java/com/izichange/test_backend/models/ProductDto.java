package com.izichange.test_backend.models;

public class ProductDto {

    private String name;

    private Float priceHt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPriceHt() {
        return priceHt;
    }

    public void setPriceHt(Float priceHt) {
        this.priceHt = priceHt;
    }
}
