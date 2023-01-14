package com.order.core.domain.service;

import com.order.core.domain.port.incoming.RetrieveEmployee;
import com.order.core.domain.port.outgoing.PersistEmployee;

public interface EmployeeService extends RetrieveEmployee, PersistEmployee {
}
