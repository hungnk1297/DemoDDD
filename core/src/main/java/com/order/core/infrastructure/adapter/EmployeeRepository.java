package com.order.core.infrastructure.adapter;

import com.order.core.domain.model.Employee;
import com.order.core.domain.port.outgoing.EmployeeOutgoing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeRepository implements EmployeeOutgoing {

    private final EmployeeJPARepositoryOutgoing jpaRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return jpaRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<Employee> findByEmployeeId(Long id) {
        return jpaRepository.findById(id);
    }
}
