package com.order.core.domain.port.outgoing;

import com.order.core.domain.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeOutgoing {

    Employee saveEmployee(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findByEmployeeId(Long id);
}
