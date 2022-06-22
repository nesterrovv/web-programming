package com.nesterrovv.web4.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class DataDTO {
    @NotBlank
    private Double x;
    @NotBlank
    private Double y;
    @NotBlank
    private Double r;
}
