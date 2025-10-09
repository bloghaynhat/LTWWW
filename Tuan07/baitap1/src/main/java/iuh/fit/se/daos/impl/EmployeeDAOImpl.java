package iuh.fit.se.daos.impl;

import iuh.fit.se.EmployeeMapper;
import iuh.fit.se.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class EmployeeDAOImpl implements iuh.fit.se.daos.EmployeeDAO {
    private JdbcTemplate jdbcTemplate;

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM employee",
                new EmployeeMapper());
    }

    @Override
    public int save(Employee employee) {
        String sql = "INSERT INTO employee (id, role, name) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, employee.getId(), employee.getRole(), employee.getName());
    }

    @Override
    public Employee getById(int id) {
        String sql = """
                SELECT * FROM employee WHERE id=?
                """;
        return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
    }

    @Override
    public Employee getByIdDirectMapper(int id) {
        String sql = """
                SELECT * FROM employee WHERE id=?
                """;
        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> new Employee(
                        rs.getInt("id"),
                        rs.getString("role"),
                        rs.getString("name")
                ), id);
    }
}
