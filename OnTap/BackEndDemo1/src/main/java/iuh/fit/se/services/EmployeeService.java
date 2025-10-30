package iuh.fit.se.services;

import iuh.fit.se.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO findById(int id);

    List<EmployeeDTO> findAll();

    EmployeeDTO save(EmployeeDTO dto);

    EmployeeDTO update(int id, EmployeeDTO dto);

    boolean deleteById(int id);
}
