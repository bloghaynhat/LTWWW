package iuh.fit.se.services;

import iuh.fit.se.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();
}
