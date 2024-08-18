package com.example.dbrouter.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = false)
@Data
public class ItemDTO extends BaseDTO {
    private Long id;
    @NotEmpty
    private String description;
}
