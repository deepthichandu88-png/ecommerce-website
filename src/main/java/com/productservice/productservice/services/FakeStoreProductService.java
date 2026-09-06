package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakestoreclient.FakeStoreAdaptor;
import org.jspecify.annotations.Nullable;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
        public class FakeStoreProductService implements ProductService {
    private FakeStoreAdaptor fakeStoreAdaptor;

    FakeStoreProductService(FakeStoreAdaptor fakeStoreAdaptor) {
        this.fakeStoreAdaptor = fakeStoreAdaptor;
    }


    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        return genericProductDto;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        //Integrate the FakeStore API.
        //RestTemplate
        return fakeStoreAdaptor.getProductById(id);

    }

    @Override
    public List<GenericProductDto> getAllProducts() {
       return fakeStoreAdaptor.getAllProducts();
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return fakeStoreAdaptor.deleteProductById(id);
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return fakeStoreAdaptor.createProduct(genericProductDto);
        }

    @Override
    public void updateProductById() {
        //
    }
}
