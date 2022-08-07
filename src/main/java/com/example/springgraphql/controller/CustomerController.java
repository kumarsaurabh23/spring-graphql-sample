package com.example.springgraphql.controller;

import com.example.springgraphql.dao.CustomerDao;
import com.example.springgraphql.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CustomerController {

    @Autowired
    private CustomerDao dao;

    @QueryMapping
    public Flux<Customer> customers() {
        return dao.findAll();
    }

    @QueryMapping
    public Mono<Customer> customerById(@Argument Integer id) {
        return dao.findById(id);
    }

    @MutationMapping
    public Mono<Customer> saveCustomer(@Argument String name) {
        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        return dao.save(newCustomer);
    }
}
