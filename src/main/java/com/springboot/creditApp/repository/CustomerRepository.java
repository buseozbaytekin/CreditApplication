package com.springboot.creditApp.repository;

import com.springboot.creditApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
    boolean existsCustomerByUsername(String customername);
}
