package com.nesterrovv.web4.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class UserDTO {
    @NotBlank(message = "Необходимо указать имя")
    private String username;
    @NotBlank(message = "Необходимо указать пароль")
    private String password;
}