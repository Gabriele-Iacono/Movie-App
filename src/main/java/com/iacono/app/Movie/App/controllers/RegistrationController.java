package com.iacono.app.Movie.App.controllers;


import com.iacono.app.Movie.App.entities.Customer;
import com.iacono.app.Movie.App.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RegistrationController {
    @Autowired
   private CustomerRepository customerRepository;
    @Autowired
    @Lazy
   private PasswordEncoder passwordEncoder;
    @Transactional
    @PostMapping("/register/user")
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);

    }
}
