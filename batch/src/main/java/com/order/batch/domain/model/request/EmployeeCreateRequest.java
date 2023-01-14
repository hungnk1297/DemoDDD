package com.order.core.domain.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EmployeeCreateRequest {

    private Long id;

    @NotBlank
    @Size(min = 0, max = 50)
    private String name;

    private String phone;

    @NotBlank
    private String email;
}
