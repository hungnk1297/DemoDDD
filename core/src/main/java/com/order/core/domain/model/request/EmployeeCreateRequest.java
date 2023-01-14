package com.order.core.domain.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter


public class EmployeeCreateRequest {

    @ApiModelProperty(notes = "Id in case of updating")
    private Long id;

    @NotBlank
    @Size(min = 0, max = 50)
    private String name;

    private String phone;

    @NotBlank
    private String email;
}
