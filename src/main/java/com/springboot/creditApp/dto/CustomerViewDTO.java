package com.springboot.creditApp.dto;

import com.springboot.creditApp.model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class CustomerViewDTO implements Serializable {
    private String firstName;
    private String lastName;
    private String citizenNumber;

    public CustomerViewDTO(String firstName, String lastName, String citizenNumber) {
        firstName = this.firstName;
        lastName = this.lastName;
        citizenNumber = this.citizenNumber;
    }

    public static CustomerViewDTO of(Customer customer){
        return new CustomerViewDTO(customer.getFirstName(),customer.getLastName(),customer.getCitizenNumber());
    }

}
