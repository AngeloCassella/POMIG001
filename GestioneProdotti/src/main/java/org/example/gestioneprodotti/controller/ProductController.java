package org.example.gestioneprodotti.controller;

import org.example.gestioneprodotti.models.Product;
import org.example.gestioneprodotti.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        // GET /products → restituisce tutti i prodotti.
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductByID(@PathVariable Long id) {
        // GET /products/{id} → restituisce un prodotto specifico.
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        // POST /products → aggiunge un nuovo prodotto.
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePutProduct(@PathVariable Long id, @RequestBody Product product) {
        // PUT /products/{id} → aggiorna un prodotto.
        if(productService.getProductById(id).getId() == product.getId()) {
            return ResponseEntity.ok(productService.updatePutProduct(id, product));
        } else {
            return ResponseEntity.badRequest().body("Error: Product not found");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePatchProduct(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        // PATCH /products/{id} → aggiorna un prodotto.
        Product product = productService.getProductById(id);
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Product.class, key);
            if(field != null) {
                field.setAccessible(true);
                if(key.equals("price")) {
                    ReflectionUtils.setField(field, product, BigDecimal.valueOf((Double) value));
                } else {
                    ReflectionUtils.setField(field, product, value);
                }
            }
        });
        return ResponseEntity.ok(productService.updatePatchProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        // DELETE /products/{id} → elimina un prodotto.
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted");
    }




}
