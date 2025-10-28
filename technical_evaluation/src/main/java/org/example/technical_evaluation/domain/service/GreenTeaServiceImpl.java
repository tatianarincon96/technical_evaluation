package org.example.technical_evaluation.domain.service;

import org.example.technical_evaluation.domain.model.Coffee;

public class GreenTeaServiceImpl implements IProductService {
    private int quantity;
    private final double DEFAULT_PRICE;

    public GreenTeaServiceImpl(int quantity, double defaultPrice) {
        this.quantity = quantity;
        this.DEFAULT_PRICE = defaultPrice;
    }

    @Override
    public Double calculatePrice() {
        int freeTeas = quantity / 2;
        quantity -= freeTeas;
        return this.DEFAULT_PRICE * quantity;
    }
}
