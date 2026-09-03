package com.productservice.productservice.controller;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private ProductService productService;

    // @Autowires OPTIONAL
    //Constructor Injection.
    ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }
    // @Autowired
    //public void setProductService(ProductService productService){
    // this.productService = productService;
//}
    //localhost:8080/products/12345
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){

        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){
       return productService.deleteProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }

    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long id){

    }


}
