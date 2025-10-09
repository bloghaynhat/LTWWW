package iuh.fit.se;

import iuh.fit.se.entities.Employee;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setRole(resultSet.getString("role"));
        employee.setName(resultSet.getString("name"));
        return employee;
    }
}
