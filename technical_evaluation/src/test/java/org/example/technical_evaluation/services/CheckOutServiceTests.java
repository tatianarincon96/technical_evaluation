package org.example.technical_evaluation.services;

import org.example.technical_evaluation.application.service.BasketService;
import org.example.technical_evaluation.domain.model.Coffee;
import org.example.technical_evaluation.domain.model.GreenTea;
import org.example.technical_evaluation.domain.model.Strawberry;
import org.junit.jupiter.api.*;

import java.util.List;


public class CheckOutServiceTests {
    BasketService basketService;
    GreenTea greenTea;
    Strawberry strawberry;
    Coffee coffee;

    @BeforeEach
    void setUp() {
        basketService = new BasketService();
        greenTea = new GreenTea(3.11);
        strawberry = new Strawberry(5.00);
        coffee = new Coffee(11.23);
    }

    // Basket: GR1,SR1,GR1,GR1,CF1
    // Total price expected: £22.45
    @Test
    void checkoutFirstBasket() {
        basketService.addProducts(List.of(greenTea, strawberry, greenTea, greenTea, coffee));
        double total = basketService.calculateTotalPrice();

        Assertions.assertEquals(22.45, total);
    }

    @Test
    void checkoutSecondBasket() {
        basketService.addProducts(List.of(greenTea, greenTea));
        double total = basketService.calculateTotalPrice();

        Assertions.assertEquals(3.11, total);
    }

    @Test
    void checkoutThirdBasket() {
        basketService.addProducts(List.of(strawberry, strawberry, greenTea, strawberry));
        double total = basketService.calculateTotalPrice();

        Assertions.assertEquals(16.61, total);
    }

    @Test
    void checkoutFourthBasket() {
        basketService.addProducts(List.of(greenTea, coffee, strawberry, coffee, coffee));
        double total = basketService.calculateTotalPrice();

        Assertions.assertEquals(30.57, total);
    }
}
