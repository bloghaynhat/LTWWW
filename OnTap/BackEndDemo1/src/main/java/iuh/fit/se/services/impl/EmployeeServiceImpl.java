package iuh.fit.se.services.impl;

import iuh.fit.se.dtos.EmployeeDTO;
import iuh.fit.se.entities.Employee;
import iuh.fit.se.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements iuh.fit.se.services.EmployeeService {

    EmployeeRepository employeeRepository;
    ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    private EmployeeDTO toDTO(Employee employee){
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    private Employee toEntity(EmployeeDTO employeeDTO){
        return modelMapper.map(employeeDTO, Employee.class);
    }

    @Override
    public EmployeeDTO findById(int id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Can not find Employee with id: " + id));
        return toDTO(employee);
    }

    @Override
    public List<EmployeeDTO> findAll(){
        return employeeRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public EmployeeDTO save(EmployeeDTO dto) {
        Employee entity = toEntity(dto);
        Employee saved = employeeRepository.save(entity);
        return toDTO(saved);
    }

    @Override
    public EmployeeDTO update(int id, EmployeeDTO dto) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        modelMapper.map(dto, existing);
        Employee updated = employeeRepository.save(existing);
        return toDTO(updated);
    }

    @Override
    public boolean deleteById(int id){
        EmployeeDTO employeeDTO = findById(id);
        employeeRepository.deleteById(employeeDTO.getId());
        return true;
    }
}
