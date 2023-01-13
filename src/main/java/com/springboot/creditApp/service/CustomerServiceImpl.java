package com.springboot.creditApp.service;

import com.springboot.creditApp.dto.CustomerCreateDTO;
import com.springboot.creditApp.dto.CustomerUpdateDTO;
import com.springboot.creditApp.dto.CustomerViewDTO;
import com.springboot.creditApp.model.Customer;
import com.springboot.creditApp.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    CustomerRepository customerRepository;
    @Override
    public CustomerViewDTO getCustomerById(Long id) {
        return null;
    }

    @Override
    public List<CustomerViewDTO> getCustomer() {
        return null;
    }

    @Override
    public CustomerViewDTO createCustomer(CustomerCreateDTO customerCreateDTO) {
        final Customer customer = customerRepository.save(
                new Customer(customerCreateDTO.getCitizenNumber(),customerCreateDTO.getFirstName(),customerCreateDTO.getLastName())
        );
        return CustomerViewDTO.of(customer);
    }

    @Override
    public CustomerViewDTO updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO) {
        return null;
    }

    @Override
    public CustomerViewDTO deleteCustomer(Long id) {
        return null;
    }
}
