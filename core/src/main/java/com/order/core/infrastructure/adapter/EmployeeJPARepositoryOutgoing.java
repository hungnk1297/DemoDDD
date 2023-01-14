package com.order.core.infrastructure.adapter;

import com.order.core.domain.model.Employee;
import com.order.core.domain.port.outgoing.EmployeeOutgoing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJPARepositoryOutgoing extends JpaRepository<Employee, Long> {
}
