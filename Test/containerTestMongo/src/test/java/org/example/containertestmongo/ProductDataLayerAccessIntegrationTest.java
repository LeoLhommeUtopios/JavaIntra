package org.example.containertestmongo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductDataLayerAccessIntegrationTest extends AbstractBaseIntegrationTest{

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void givenProductRepository_whenSaveAndRetrieveProduct_thenOK() {
        Product product = new Product("Milk", "1L Milk", 10);

        Product createdProduct = productRepository.save(product);
        Optional<Product> optionalProduct = productRepository.findById(createdProduct.getId());

        Assertions.assertThat(optionalProduct.isPresent()).isTrue();

        Product retrievedProduct = optionalProduct.get();
        Assertions.assertThat(retrievedProduct.getId()).isEqualTo(product.getId());
    }

    @Test
    public void givenProductRepository_whenFindByName_thenOK() {
        Product product = new Product("Apple", "Fruit", 10);

        Product createdProduct = productRepository.save(product);
        Optional<Product> optionalProduct = productRepository.findByName(createdProduct.getName());

        Assertions.assertThat(optionalProduct.isPresent()).isTrue();

        Product retrievedProduct = optionalProduct.get();
        Assertions.assertThat(retrievedProduct.getId()).isEqualTo(product.getId());
    }

}
