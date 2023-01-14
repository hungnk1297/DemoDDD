package com.order.core.domain.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeResponse {

    private Long id;

    private String name;

    private String phone;

    private String email;
}
