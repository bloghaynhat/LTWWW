package iuh.fit.se.services;

import iuh.fit.se.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeAPIService {
    List<EmployeeDTO> findAll();

    EmployeeDTO findById(Integer id);

    EmployeeDTO create(EmployeeDTO dto);

    EmployeeDTO update(Integer id, EmployeeDTO dto);

    boolean delete(Integer id);
}
