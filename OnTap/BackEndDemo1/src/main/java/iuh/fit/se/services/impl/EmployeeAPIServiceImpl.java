package iuh.fit.se.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.dtos.EmployeeDTO;
import iuh.fit.se.services.EmployeeAPIService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeAPIServiceImpl implements EmployeeAPIService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();
    private final String API_URL = "http://localhost:8080/api/employee";

    @Override
    public List<EmployeeDTO> findAll() {
        ResponseEntity<Map> response = restTemplate.getForEntity(API_URL, Map.class);
        Object data = response.getBody().get("data");
        return mapper.convertValue(data, mapper.getTypeFactory().constructCollectionType(List.class, EmployeeDTO.class));
    }

    @Override
    public EmployeeDTO findById(Integer id) {
        ResponseEntity<Map> response = restTemplate.getForEntity(API_URL + "/" + id, Map.class);
        Object data = response.getBody().get("data");
        return mapper.convertValue(data, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        HttpEntity<EmployeeDTO> request = new HttpEntity<>(dto);
        ResponseEntity<Map> response = restTemplate.postForEntity(API_URL, request, Map.class);
        Object data = response.getBody().get("data");
        return mapper.convertValue(data, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO update(Integer id, EmployeeDTO dto) {
        HttpEntity<EmployeeDTO> request = new HttpEntity<>(dto);
        ResponseEntity<Map> response = restTemplate.exchange(API_URL + "/" + id, HttpMethod.PUT, request, Map.class);
        Object data = response.getBody().get("data");
        return mapper.convertValue(data, EmployeeDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        ResponseEntity<Map> response = restTemplate.exchange(API_URL + "/" + id, HttpMethod.DELETE, null, Map.class);
        return Boolean.TRUE.equals(response.getBody().get("data"));
    }
}
