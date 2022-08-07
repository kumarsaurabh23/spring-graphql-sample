package com.example.springgraphql.dao;

import com.example.springgraphql.dto.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends ReactiveCrudRepository<Customer, Integer> {

}
