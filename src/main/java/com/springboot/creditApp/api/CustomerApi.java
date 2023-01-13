package com.springboot.creditApp.api;

import com.springboot.creditApp.dto.CustomerViewDTO;
import com.springboot.creditApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerApi {
    private final CustomerService customerService;

    @GetMapping("{id}")
    public ResponseEntity<CustomerViewDTO> getCustomerById(@PathVariable Long id){
        final CustomerViewDTO customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
}
