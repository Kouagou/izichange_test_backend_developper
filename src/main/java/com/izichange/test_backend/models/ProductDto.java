package com.izichange.test_backend.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class ProductDto {

    @NotEmpty(message = "Le nom est requis")
    private String name;

    @Min(0)
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
