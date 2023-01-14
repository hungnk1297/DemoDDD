package com.order.core.domain.service.impl;

import com.order.core.domain.model.Employee;
import com.order.core.domain.model.request.EmployeeCreateRequest;
import com.order.core.domain.model.response.EmployeeResponse;
import com.order.core.domain.service.EmployeeService;
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
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public EmployeeResponse createEmployee(EmployeeCreateRequest employeeCreateRequest) {
        Employee employee = Employee.builder()
                .name(employeeCreateRequest.getName())
                .email(employeeCreateRequest.getEmail())
                .phone(employeeCreateRequest.getPhone())
                .build();
        employee = employeeRepository.save(employee);

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
                .map(employee -> EmployeeResponse.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .phone(employee.getPhone())
                        .email(employee.getEmail())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse findById(Long id) {
        return employeeRepository.findById(id).stream()
                .map(employee -> EmployeeResponse.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .phone(employee.getPhone())
                        .email(employee.getEmail())
                        .build()
                ).findFirst().orElseThrow();
    }
}
