package br.com.register.employee.repository;

import br.com.register.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
