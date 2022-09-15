package com.globomantics.productservice.web;

import com.globomantics.productservice.model.Product;
import com.globomantics.productservice.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerPracticeTest {

    @MockBean
    private ProductService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /product/1 - Found")
    void getProduct() throws Exception {
        Product mockProduct = new Product(1, "Product Name", 10, 1);
        doReturn(Optional.of(mockProduct)).when(service).findById(1);

        mockMvc.perform(MockMvcRequestBuilders.get("/product/{id}", 1))
                // 1
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

                // 2
                .andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
                .andExpect(header().string(HttpHeaders.LOCATION, "/product/1"))

                // 3
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Product Name")))
                .andExpect(jsonPath("$.quantity", is(10)))
                .andExpect(jsonPath("$.version", is(1)));
    }

    @Test
    void getProducts() {
    }

    @Test
    void createProduct() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }
}