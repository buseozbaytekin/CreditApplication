package com.springboot.creditApp.service;

import com.springboot.creditApp.dto.CustomerCreateDTO;
import com.springboot.creditApp.dto.CustomerUpdateDTO;
import com.springboot.creditApp.dto.CustomerViewDTO;
import com.springboot.creditApp.exception.NotFoundException;
import com.springboot.creditApp.model.Customer;
import com.springboot.creditApp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public CustomerViewDTO getCustomerById(Long id) {
        final Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found exception"));
        return CustomerViewDTO.of(customer);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<CustomerViewDTO> getCustomer() {
        return customerRepository.findAll().stream().map(CustomerViewDTO::of).collect(Collectors.toList());
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
        final Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        customer.setFirstName(customerUpdateDTO.getFirstName());
        customer.setLastName(customerUpdateDTO.getLastName());
        final Customer updatedCustomer = customerRepository.save(customer);
        return CustomerViewDTO.of(updatedCustomer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
        final Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        customerRepository.deleteById(id);

    }
}
