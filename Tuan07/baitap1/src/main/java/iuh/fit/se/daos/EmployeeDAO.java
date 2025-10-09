package iuh.fit.se.daos;

import iuh.fit.se.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

public interface EmployeeDAO {
    @Autowired
    void setDataSource(DataSource dataSource);

    List<Employee> getAll();

    int save(Employee employee);

    Employee getById(int id);

    Employee getByIdDirectMapper(int id);
}
