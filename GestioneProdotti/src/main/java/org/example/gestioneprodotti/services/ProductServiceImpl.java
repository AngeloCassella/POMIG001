package org.example.gestioneprodotti.services;

import org.example.gestioneprodotti.models.Product;
import org.example.gestioneprodotti.repositories.ProductRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired @Qualifier("createProduct") ObjectProvider<Product> createProductObjectProvider;
    @Autowired @Qualifier("createFakeProduct") ObjectProvider<Product> createFakeProductObjectProvider;
    @Autowired ProductRepository productRepository;

    @Override
    public Product createProduct(String name, String description, BigDecimal price) {
        Product product = createProductObjectProvider.getObject();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        return product;
    }

    @Override
    public Product createFakeProduct() {
        return createFakeProductObjectProvider.getObject();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public Product updatePutProduct(Long id, Product product) {
        if(Objects.equals(id, product.getId())){
            productRepository.save(product);
        }
        return product;
    }

    @Override
    public Product updatePatchProduct(Long id, Product product) {
        if(Objects.equals(id, product.getId())){
            productRepository.save(product);
        }
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
