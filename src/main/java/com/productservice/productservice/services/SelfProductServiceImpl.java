package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.lang.reflect.GenericArrayType;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public void getAllProducts() {

    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProductById() {

    }
//    @Override
//    public String getProductById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void getAllProducts() {
//
//    }
//
//    @Override
//    public void deleteProductById() {
//
//    }
//
//    @Override
//    public void createProduct() {
//
//    }
//
//    @Override
//    public void updateProductById() {
//
//    }
}
