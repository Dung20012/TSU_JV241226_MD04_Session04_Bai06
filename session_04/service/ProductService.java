package com.data.session_04.service;

import com.data.session_04.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAll();
    List<Product> searchProductByName(String searchProductName);
}
