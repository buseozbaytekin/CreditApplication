package com.springboot.creditApp.api;

import com.springboot.creditApp.dto.CustomerCreateDTO;
import com.springboot.creditApp.dto.CustomerUpdateDTO;
import com.springboot.creditApp.dto.CustomerViewDTO;
import com.springboot.creditApp.service.CustomerService;
import com.springboot.creditApp.util.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerCreateDTO customerCreateDTO){
        customerService.createCustomer(customerCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User created!"));
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerUpdateDTO customerUpdateDTO){
        final CustomerViewDTO customer = customerService.updateCustomer(id, customerUpdateDTO);
        return ResponseEntity.ok(customer);
    }
}
