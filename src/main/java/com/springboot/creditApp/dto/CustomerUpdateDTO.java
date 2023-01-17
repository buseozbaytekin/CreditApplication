package com.springboot.creditApp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerUpdateDTO {
    @NotNull(message = "{creditApp.constraints.firstname.NotNull.message}")
    @Size(min = 2, max = 32, message = "{creditApp.constraints.firstname.Size.message}")
    private String firstName;

    @NotNull(message = "{creditApp.constraints.lastname.NotNull.message}")
    @Size(min = 2, max = 32, message = "{creditApp.constraints.lastname.Size.message}")
    private String lastName;
}
