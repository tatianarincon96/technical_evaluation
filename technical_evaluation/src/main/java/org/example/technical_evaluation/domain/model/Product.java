package org.example.technical_evaluation.domain.model;

public abstract class Product {
    private final ProductCode code;
    private Double defaultPrice;

    public Product(ProductCode code, Double defaultPrice) {
        this.code = code;
        this.defaultPrice = defaultPrice;
    }

    public ProductCode getCode() {
        return code;
    }

    public Double getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Double newPrice) {
        this.defaultPrice = newPrice;
    }
}
