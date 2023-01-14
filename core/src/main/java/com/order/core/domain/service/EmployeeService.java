package com.order.core.domain.service;

import com.order.core.domain.model.Employee;
import com.order.core.domain.model.request.EmployeeCreateRequest;
import com.order.core.domain.model.response.EmployeeResponse;
import com.order.core.domain.port.incoming.EmployeeIncoming;
import com.order.core.infrastructure.adapter.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService implements EmployeeIncoming {

    private final EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeResponse createEmployee(EmployeeCreateRequest employeeCreateRequest) {
        Employee employee = Employee.builder()
                .name(employeeCreateRequest.getName())
                .email(employeeCreateRequest.getEmail())
                .phone(employeeCreateRequest.getPhone())
                .build();
        employee = employeeRepository.saveEmployee(employee);

        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .phone(employee.getPhone())
                .email(employee.getEmail())
                .build();
    }

    @Override
    public List<EmployeeResponse> allEmployee() {
        return employeeRepository.findAll().stream()
                .map(employee ->
                        EmployeeResponse.builder()
                                .id(employee.getId())
                                .name(employee.getName())
                                .phone(employee.getPhone())
                                .email(employee.getEmail())
                                .build()).collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse findById(Long id) {
        return employeeRepository.findByEmployeeId(id)
                .map(employee -> EmployeeResponse.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .phone(employee.getPhone())
                        .email(employee.getEmail())
                        .build()
                ).orElseThrow();
    }
}
