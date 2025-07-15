package com.data.session_04.controller;

import com.data.session_04.model.Product;
import com.data.session_04.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView product(@RequestParam(value = "searchProductName", required = false) String searchProductName) {
        List<Product> productList;
        if (searchProductName != null && !searchProductName.trim().isEmpty()){
            productList = productService.searchProductByName(searchProductName);
        }else {
            productList = productService.getAll();
        }
        ModelAndView modelAndView = new ModelAndView("listProduct");
        modelAndView.addObject("products", productList);
        modelAndView.addObject("searchProductName", searchProductName);
        return modelAndView;
    }
}
