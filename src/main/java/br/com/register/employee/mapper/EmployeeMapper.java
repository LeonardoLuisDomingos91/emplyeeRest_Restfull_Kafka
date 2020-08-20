package br.com.register.employee.mapper;

import br.com.register.employee.domain.Employee;
import br.com.register.employee.request.EmployeeRequest;
import br.com.register.employee.response.EmployeeResponse;
import br.com.register.employee.update.EmployeeUpdate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee updatingEmployeeToBeSaved(EmployeeRequest employeeRequest){

        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setNickName(employeeRequest.getNickName());
        employee.setCpf(employeeRequest.getCpf());
        return employee;
    }

    public EmployeeResponse settingEmployeeToEmployeeResponse(Employee employee){
        var employeeResponse = new EmployeeResponse();
        employeeResponse.setName(employee.getName());
        employeeResponse.setNickName(employee.getNickName());
        return employeeResponse;
    }

    public Employee changingEmployeeById(Employee employee, EmployeeUpdate employeeUpdate){
        employee.setName(employeeUpdate.getName());
        employee.setLastName(employeeUpdate.getLastName());
        employee.setNickName(employeeUpdate.getNickName());
        return employee;
    }
}
