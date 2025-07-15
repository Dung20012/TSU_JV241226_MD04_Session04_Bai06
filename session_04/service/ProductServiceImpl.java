package com.data.session_04.service;

import com.data.session_04.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private List<Product> products;

    public ProductServiceImpl() {
        products = new ArrayList<>();
        products.add(new Product(1, "Khoai tây", 150000, 50, "Ngon"));
        products.add(new Product(2, "Cà rốt", 120000, 30, "Giòn"));
        products.add(new Product(3, "Hành tây", 200000, 40, "Ngọt"));
        products.add(new Product(4, "Cà chua", 180000, 25, "Tươi"));
        products.add(new Product(5, "Dưa chuột", 160000, 45, "Mọng nước"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public List<Product> searchProductByName(String searchProductName) {
        return products.stream()
                .filter(p -> p.getProductName().toLowerCase()
                        .contains(searchProductName.toLowerCase()))
                .collect(Collectors.toList());
    }
}
