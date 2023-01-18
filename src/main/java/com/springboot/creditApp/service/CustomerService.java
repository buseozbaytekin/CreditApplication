package com.springboot.creditApp.service;

import com.springboot.creditApp.dto.CustomerCreateDTO;
import com.springboot.creditApp.dto.CustomerUpdateDTO;
import com.springboot.creditApp.dto.CustomerViewDTO;

import java.util.List;

public interface CustomerService {

    CustomerViewDTO getCustomerById(Long id);
    List <CustomerViewDTO> getCustomer();
    CustomerViewDTO createCustomer(CustomerCreateDTO customerCreateDTO);
    CustomerViewDTO updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO);
    void deleteCustomer(Long id);
}
