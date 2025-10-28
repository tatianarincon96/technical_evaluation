package org.example.technical_evaluation.infrastructure;

import org.example.technical_evaluation.application.service.BasketService;

// Se podria expandir agregando un controller
public class Controller {
    private final BasketService service;

    Controller(BasketService service) {
        this.service = new BasketService();
    }

    public void addProductToBasket() {
    }

    public Double calculateTotalPrice() {
        return service.calculateTotalPrice();
    }
}
