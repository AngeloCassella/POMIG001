package org.example.gestioneprodotti.controller;

import org.example.gestioneprodotti.models.Order;
import org.example.gestioneprodotti.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        // POST /orders → Crea un ordine per un utente.
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id) {
        // GET /orders/{id} → Ottiene i dettagli di un ordine.
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> cancelOrder(@PathVariable Long id) {
        // PUT /orders/{id}/cancel → Annulla un ordine.
        return ResponseEntity.ok(orderService.cacelOrder(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getOrdersByUser(@PathVariable Long id) {
        // GET /orders/user/{userId} → Restituisce gli ordini di un utente.
        return ResponseEntity.ok(orderService.getOrdersByUser(id));
    }

}
