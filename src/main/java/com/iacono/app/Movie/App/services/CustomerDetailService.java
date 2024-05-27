package com.iacono.app.Movie.App.services;

import com.iacono.app.Movie.App.entities.Customer;
import com.iacono.app.Movie.App.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class CustomerDetailService implements UserDetailsService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = repository.findByUsername(username);
        if (customer.isPresent()){
            var customerObj = customer.get();
          return User.builder()
                    .username(customerObj.getUsername())
                    .password(customerObj.getPassword())
                    .roles(getRoles(customerObj))
                    .build();
        }else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String[] getRoles(Customer customer) {
        if (customer.getRole() == null) {
            return new String[]{"USER"};
        }
        return customer.getRole().split(",");
    }



}
