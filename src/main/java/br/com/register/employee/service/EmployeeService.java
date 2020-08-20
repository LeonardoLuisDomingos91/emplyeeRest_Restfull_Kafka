package br.com.register.employee.service;

import br.com.register.employee.domain.Employee;
import br.com.register.employee.exception.EmployeeNotFound;
import br.com.register.employee.mapper.EmployeeMapper;
import br.com.register.employee.repository.EmployeeRepository;
import br.com.register.employee.request.EmployeeRequest;
import br.com.register.employee.response.EmployeeResponse;
import br.com.register.employee.update.EmployeeUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public void save(EmployeeRequest employeeRequest){
        var employee = employeeMapper.updatingEmployeeToBeSaved(employeeRequest);
        employeeRepository.save(employee);
    }

    public EmployeeResponse bankEmployeeSearch(long id){
        Employee employeeExist = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFound("Employee Not Found"));
        EmployeeResponse employeeResponse = employeeMapper.settingEmployeeToEmployeeResponse(employeeExist);
        return employeeResponse;
    }

    public void searchForEmployeeToDelete(Long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()){
            employeeRepository.deleteById(id);
        }else{
            throw new EmployeeNotFound("Employee Not Found");
        }
    }

    public Employee seekingEmployeeToCange(Long id, EmployeeUpdate employeeUpdate){
        Employee employeeExist = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFound("Employee Not Found"));
        Employee employee = employeeMapper.changingEmployeeById(employeeExist, employeeUpdate);
        employeeRepository.save(employee);
        return employee;
    }
}
