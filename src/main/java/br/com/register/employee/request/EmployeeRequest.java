package br.com.register.employee.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EmployeeRequest {

    private String name;

    private String lastName;

    private String nickName;

    private String cpf;
}
