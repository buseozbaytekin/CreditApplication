package com.springboot.creditApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "citizen_number", nullable = false, length = 50)
    private String citizenNumber;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "birth_date",  length = 50)
    private LocalDate birthDate;
    @Column(name = "monthly_income",  length = 50)
    private int monthlyIncome;
    @Column(name = "phone_number",  length = 50)
    private String phoneNumber;
    @Column(name = "guarantee", length = 50)
    private String guarantee;//apply the guarantee type

    public Customer(String firstName, String lastName,String citizenNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenNumber = citizenNumber;
    }
}
