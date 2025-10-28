package org.example.technical_evaluation.domain.model;

import org.example.technical_evaluation.domain.service.CoffeeServiceImpl;
import org.example.technical_evaluation.domain.service.GreenTeaServiceImpl;
import org.example.technical_evaluation.domain.service.IProductService;
import org.example.technical_evaluation.domain.service.StrawberryServiceImpl;

public enum ProductCode {
    GR1 {
        public IProductService createInstance(int quantity, double defaultPrice) {
            return new GreenTeaServiceImpl(quantity, defaultPrice);
        }
    },
    SR1 {
        public IProductService createInstance(int quantity, double defaultPrice) {
            return new StrawberryServiceImpl(quantity, defaultPrice);
        }
    },
    CF1 {
        public IProductService createInstance(int quantity, double defaultPrice) {
            return new CoffeeServiceImpl(quantity, defaultPrice);
        }
    };

    public abstract IProductService createInstance(int quantity, double defaultPrice);
}
