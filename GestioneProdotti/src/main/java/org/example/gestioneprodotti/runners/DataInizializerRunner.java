package org.example.gestioneprodotti.runners;

import com.github.javafaker.Faker;
import org.example.gestioneprodotti.models.Product;
import org.example.gestioneprodotti.models.User;
import org.example.gestioneprodotti.services.OrderService;
import org.example.gestioneprodotti.services.ProductService;
import org.example.gestioneprodotti.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataInizializerRunner implements CommandLineRunner {

    @Autowired ProductService productService;
    @Autowired UserService userService;
    @Autowired OrderService orderService;

    @Override
    public void run(String... args) throws Exception {

        if(productService.getAllProducts().size()==0){
            for (int i = 0; i < 10; i++) {
                productService.saveProduct(productService.createFakeProduct());
            }
        }

        if(userService.getAllUser().size()==0){
            for (int i = 0; i < 5; i++) {
                userService.saveUser(userService.createFakeUser());
            }
        }

        if(orderService.getOrders().size()==0){
            Faker  faker = new Faker();
            for (int i = 0; i < 10; i++) {
                User user = userService.getUserById((long) faker.number().numberBetween(1, 5));
                List<Product> products = new ArrayList<>();
                for (int j = 0; j < faker.number().numberBetween(1, 3); j++) {
                    products.add(productService.getProductById((long) faker.number().numberBetween(1, 10)));
                }
                orderService.saveOrder(orderService.createOrder(user, products));
            }
        }


    }
}
