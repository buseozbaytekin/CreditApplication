package com.springboot.creditApp.dto;

import com.springboot.creditApp.validator.UniqueCitizenNumber;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerCreateDTO {
    @NotNull(message = "{creditApp.constraints.firstName.NotNull.message}")
    @Size(min = 3, max = 24,message = "{creditApp.constraints.firstName.Size.message}")
    private String firstName;

    @NotNull(message = "{creditApp.constraints.lastName.NotNull.message}")
    @Size(min = 2, max = 24,message = "{creditApp.constraints.lastName.Size.message}")
    private String lastName;

    @NotNull(message = "{creditApp.constraints.citizenNumber.NotNull.message}")
    @Size(min = 1, max = 12,message = "{creditApp.constraints.citizenNumber.Size.message}")
    @UniqueCitizenNumber
    private String citizenNumber;
}
