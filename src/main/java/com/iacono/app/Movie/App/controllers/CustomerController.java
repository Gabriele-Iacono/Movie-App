package com.iacono.app.Movie.App.controllers;

import com.iacono.app.Movie.App.entities.Customer;
import com.iacono.app.Movie.App.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

// API
//GET /customers: Recuperare tutti i clienti.
//GET /customers/{id}: Recuperare i dettagli di un cliente specifico.
//POST /customers: Aggiungere un nuovo cliente.
//PUT /customers/{id}: Aggiornare i dettagli di un cliente esistente.
//DELETE /customers/{id}: Eliminare un cliente.

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customers/{id}")
     public ResponseEntity <Customer> getCustomerById(@PathVariable Long id){
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);

    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return ResponseEntity.status(201).body(newCustomer);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity <Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer updateCustomer) {
        Customer customer = customerService.updateCustomer(id, updateCustomer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
















}
