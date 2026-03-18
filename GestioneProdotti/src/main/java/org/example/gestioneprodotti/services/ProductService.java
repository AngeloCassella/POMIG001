package org.example.gestioneprodotti.services;

import org.example.gestioneprodotti.models.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


public interface ProductService {

    public Product createProduct(String name, String description, BigDecimal price);
    public Product createFakeProduct();
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product saveProduct(Product product);
    public Product updatePutProduct(Long id, Product product);
    public Product updatePatchProduct(Long id, Product product);
    public void deleteProduct(Long id);


}
