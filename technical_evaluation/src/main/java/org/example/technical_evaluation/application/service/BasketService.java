package org.example.technical_evaluation.application.service;

import org.example.technical_evaluation.domain.model.Product;
import org.example.technical_evaluation.domain.model.ProductCode;
import org.example.technical_evaluation.domain.service.IProductService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class BasketService {
    private final List<Product> products;
    private IProductService productService;

    public BasketService() {
        this.products = new ArrayList<>();
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public double calculateTotalPrice() {
        ProductCode[] productCodes = ProductCode.values();
        List<ProductCode> findCodesInBasket = Arrays.stream(productCodes)
                .filter(code -> this.products.stream()
                        .anyMatch(product -> product.getCode().equals(code))).toList();

        Double totalPrice = 0.0;
        for (ProductCode code : findCodesInBasket) {
            int quantity = this.products.stream().mapToInt(product -> product.getCode().equals(code) ? 1 : 0).sum();
            double defaultPrice = this.getDefaultPriceOfProduct(this.products, code);
            this.setService(code, quantity, defaultPrice);
            totalPrice += productService.calculatePrice();
        }
        BigDecimal bd = BigDecimal.valueOf(totalPrice);
        return bd.setScale(2, RoundingMode.DOWN).doubleValue();
    }

    private void setService(ProductCode code, int quantity, double defaultPrice) {
        this.productService = code.createInstance(quantity, defaultPrice);
    }

    private Double getDefaultPriceOfProduct(List<Product> products, ProductCode code) {
        return products.stream()
                .filter(product -> product.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con el código: " + code))
                .getDefaultPrice();
    }
}
