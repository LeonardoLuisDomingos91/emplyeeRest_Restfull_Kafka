package br.com.register.employee.exception;

public class EmployeeNotFound extends RuntimeException{

    public EmployeeNotFound(String mensagem){
        super(mensagem);
    }
}
