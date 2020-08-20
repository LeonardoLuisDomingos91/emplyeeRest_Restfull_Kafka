package br.com.register.employee.controller;

import br.com.register.employee.domain.Employee;
import br.com.register.employee.request.EmployeeRequest;
import br.com.register.employee.response.EmployeeResponse;
import br.com.register.employee.service.EmployeeService;
import br.com.register.employee.update.EmployeeUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody EmployeeRequest employeeRequest){
        employeeService.save(employeeRequest);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        responseHeaders.add("mensagem " , "Employee created");

        return new ResponseEntity(responseHeaders,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> searchEmployee(@PathVariable Long id){
       EmployeeResponse employeeResponse = employeeService.bankEmployeeSearch(id);
        return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id){
        employeeService.searchForEmployeeToDelete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody EmployeeUpdate employeeUpdate){
        Employee employee = employeeService.seekingEmployeeToCange(id, employeeUpdate);
        return ResponseEntity.ok().body(employee);
    }
}
