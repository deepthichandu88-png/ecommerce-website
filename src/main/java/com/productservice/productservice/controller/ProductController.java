package com.productservice.productservice.controller;

import com.productservice.productservice.dtos.ExceptionDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {

        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id) {
        return productService.deleteProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
        return productService.createProduct(genericProductDto);
    }

    public void updateProduct() {

    }

   // @ExceptionHandler(ProductNotFoundException.class)
    //private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
      //  ExceptionDto exceptionDto = new ExceptionDto();
        //exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        //exceptionDto.setMessage(productNotFoundException.getMessage());

        //ResponseEntity responseEntity = new ResponseEntity(exceptionDto, HttpStatus.NOT_FOUND);
        //return responseEntity;
   // }
}


