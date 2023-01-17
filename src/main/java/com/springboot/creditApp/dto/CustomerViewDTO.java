package com.springboot.creditApp.dto;

import com.springboot.creditApp.model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public final class CustomerViewDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String citizenNumber;

    public CustomerViewDTO(String firstName, String lastName, String citizenNumber) {
        this.firstName = firstName ;
        this.lastName = lastName;
        this.citizenNumber = citizenNumber;
    }

    public static CustomerViewDTO of(Customer customer){
      return new CustomerViewDTO(customer.getFirstName(),customer.getLastName(),customer.getCitizenNumber());
  }

}
