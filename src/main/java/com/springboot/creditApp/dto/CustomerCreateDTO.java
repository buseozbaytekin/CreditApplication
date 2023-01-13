package com.springboot.creditApp.dto;

import com.springboot.creditApp.validator.UniqueCitizenNumber;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerCreateDTO {
    @NotNull(message = "{backend.constraints.userName.NotNull.message}")
    @Size(min = 5, max = 24,message = "{backend.constraints.userName.Size.message}")
    private String firstName;

    @NotNull(message = "{backend.constraints.userName.NotNull.message}")
    @Size(min = 5, max = 24,message = "{backend.constraints.userName.Size.message}")
    private String lastName;

    @NotNull(message = "{backend.constraints.userName.NotNull.message}")
    @Size(min = 5, max = 24,message = "{backend.constraints.userName.Size.message}")
    @UniqueCitizenNumber
    private String citizenNumber;
}
