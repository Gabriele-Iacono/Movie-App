package com.iacono.app.Movie.App.services;

import com.iacono.app.Movie.App.Exceptions.CustomerNotFoundException;
import com.iacono.app.Movie.App.entities.Customer;
import com.iacono.app.Movie.App.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Cliente non trovato con id: " + id);
        }
        return optionalCustomer.get();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updateCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Cliente non trovato con id:" + id);
        }
        Customer customer = optionalCustomer.get();
        customer.setName(updateCustomer.getName());
        customer.setEmail(updateCustomer.getEmail());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Cliente non trovato con id:" + id);
        }
         customerRepository.deleteById(id);
    }

}
