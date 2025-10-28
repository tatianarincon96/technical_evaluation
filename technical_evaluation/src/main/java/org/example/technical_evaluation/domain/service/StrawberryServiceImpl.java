package org.example.technical_evaluation.domain.service;

public class StrawberryServiceImpl implements IProductService {
    private final int quantity;
    private double DEFAULT_PRICE;

    public StrawberryServiceImpl(int quantity, double defaultPrice) {
        this.quantity = quantity;
        this.DEFAULT_PRICE = defaultPrice;
    }

    @Override
    public Double calculatePrice() {
        this.DEFAULT_PRICE = quantity >= 3 ? 4.5 : this.DEFAULT_PRICE;
        return this.DEFAULT_PRICE * quantity;
    }
}
