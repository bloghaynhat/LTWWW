package iuh.fit.se.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private int id;
    private String role;
    private String name;
    private Department department;

    public Employee(int id, String role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }
}
