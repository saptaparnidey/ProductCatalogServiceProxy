package org.example.productcatalogserviceproxy.client.fakeStore.client;

import org.example.productcatalogserviceproxy.client.fakeStore.dto.FakeStoreProductDto;
import org.example.productcatalogserviceproxy.client.fakeStore.dto.FakeStoreRatingDto;
import org.example.productcatalogserviceproxy.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreAPIClient {

    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDto[] getFakeStoreProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class).getBody();
        return fakeStoreProductDtos;
    }

    public FakeStoreProductDto getFakeStoreProduct(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, id).getBody();
        return fakeStoreProductDto;
    }

    public FakeStoreProductDto createFakeStoreProduct(FakeStoreProductDto fakeStoreProductDto){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtos = restTemplate.postForEntity("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);
        return fakeStoreProductDtos.getBody();
    }

    public FakeStoreProductDto updateFakeStoreProduct(Long id, FakeStoreProductDto fakeStoreProductDto){
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        FakeStoreProductDto fsProductDto = restTemplate.patchForObject("https://fakestoreapi.com/products/{id}", fakeStoreProductDto, FakeStoreProductDto.class, id);
        return fsProductDto;
    }

    public void deleteFakeStoreProduct(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete("https://fakestoreapi.com/products/{id}", id);
    }
}
