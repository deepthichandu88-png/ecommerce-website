package com.productservice.productservice.controller;

import com.productservice.productservice.dtos.ExceptionDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(ProductNotFoundException.class)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    //@ResponseBody()
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(
            ProductNotFoundException productNotFoundException
    ){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        exceptionDto.setMessage(productNotFoundException.getMessage());

        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);

    }

 //   @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
 //   private ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException(
 //           ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException
 //   ){
 //       return null;
 //   }

 //   private ResponseEntity<ExceptionDto> handleNullPointerException(
 //NullPointerException nullPointerException
 //   ){
 //       return null;
 //   }
}
