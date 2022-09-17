package com.globomantics.productservice.repository;

import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.DBUnitExtension;
import com.globomantics.productservice.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({SpringExtension.class, DBUnitExtension.class})
@SpringBootTest
@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ProductRepository productRepository;

    public ConnectionHolder getConnectionHolder() {
        // Return a function that retrieves a connection from our data source
        return () -> dataSource.getConnection();
    }

    @Test
    void findById() {
    }

    @Test
    @DataSet("products.yml")
    void findAll() {
        List<Product> all = productRepository.findAll();
        assertEquals(2, all.size(), "2 products");
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