package com.springboot.creditApp.service;

import com.springboot.creditApp.dto.CustomerCreateDTO;
import com.springboot.creditApp.dto.CustomerUpdateDTO;
import com.springboot.creditApp.dto.CustomerViewDTO;
import com.springboot.creditApp.exception.NotFoundException;
import com.springboot.creditApp.model.Customer;
import com.springboot.creditApp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
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
                new Customer(customerCreateDTO.getFirstName(),customerCreateDTO.getLastName(),customerCreateDTO.getCitizenNumber())
        );
        return CustomerViewDTO.of(customer);
    }

    @Override
    @Transactional
    public CustomerViewDTO updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO) {
        final Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found"));
        customer.setFirstName(customerUpdateDTO.getFirstName());
        customer.setLastName(customerUpdateDTO.getLastName());
        final Customer updatedCustomer = customerRepository.save(customer);
        return CustomerViewDTO.of(updatedCustomer);
    }

    @Override
    public CustomerViewDTO deleteCustomer(Long id) {
        return null;
    }
}
