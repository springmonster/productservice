package com.globomantics.productservice.service;

import com.globomantics.productservice.model.Product;
import com.globomantics.productservice.repository.ProductRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductServicePracticeTest {

    @Autowired
    private ProductService service;

    @MockBean
    private ProductRepository repository;


    @Test
    void findById() {
    }

    @Test
    @DisplayName("Test findAll")
    void findAll() {
        List<Product> mockList = Lists.newArrayList(
                new Product(1, "p1", 1, 1),
                new Product(2, "p2", 2, 2)
        );

        doReturn(mockList).when(repository).findAll();

        List<Product> productList = service.findAll();

        assertEquals(2, productList.size(), "findAll should return 2 products");
    }

    @Test
    void update() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }
}