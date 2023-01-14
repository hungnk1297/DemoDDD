package com.order.core.domain.port.incoming;

import com.order.core.domain.model.request.EmployeeCreateRequest;
import com.order.core.domain.model.response.EmployeeResponse;

import java.util.List;

public interface EmployeeIncoming {

    List<EmployeeResponse> allEmployee();

    EmployeeResponse findById(Long id);

    EmployeeResponse createEmployee(EmployeeCreateRequest employeeCreateRequest);
}
