package org.example.productcatalogserviceproxy.service;

import org.example.productcatalogserviceproxy.client.fakeStore.client.FakeStoreAPIClient;
import org.example.productcatalogserviceproxy.client.fakeStore.dto.FakeStoreProductDto;
import org.example.productcatalogserviceproxy.model.Category;
import org.example.productcatalogserviceproxy.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class FakeStoreProductService implements IProductService {

    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductService(FakeStoreAPIClient fakeStoreAPIClient) {
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public List<Product> getProducts(){
        FakeStoreProductDto[] fakeStoreProductDtos = fakeStoreAPIClient.getFakeStoreProducts();
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(getProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product getProduct(Long id){
        return getProduct(fakeStoreAPIClient.getFakeStoreProduct(id));
    }

    @Override
    public Product createProduct(Product product){
        FakeStoreProductDto fakeStoreProductDto = getFakeStoreProductDto(product);
        FakeStoreProductDto responseFakeStoreProductDto = fakeStoreAPIClient.createFakeStoreProduct(fakeStoreProductDto);
        return getProduct(fakeStoreAPIClient.createFakeStoreProduct(responseFakeStoreProductDto));
    }

    @Override
    public Product updateProduct(Long id, Product product){
        FakeStoreProductDto fakeStoreProductDto = getFakeStoreProductDto(product);
        return getProduct(fakeStoreAPIClient.updateFakeStoreProduct(id, fakeStoreProductDto));
    }

    @Override
    public String deleteProduct(Long id){
        fakeStoreAPIClient.deleteFakeStoreProduct(id);
        return "Product deleted successfully for id: " + id;
    }

    private Product getProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getTitle());
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    private FakeStoreProductDto getFakeStoreProductDto(Product product){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        return fakeStoreProductDto;
    }
}
