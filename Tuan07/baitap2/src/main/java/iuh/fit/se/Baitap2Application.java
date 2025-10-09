package iuh.fit.se;

import iuh.fit.se.entities.Department;
import iuh.fit.se.entities.Employee;
import iuh.fit.se.repositories.DepartmentRepository;
import iuh.fit.se.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class Baitap2Application {

    public static void main(String[] args) {
        SpringApplication.run(Baitap2Application.class, args);
    }
    @Bean
    CommandLineRunner initData(DepartmentRepository deptRepo, EmployeeRepository empRepo) {
        return args -> {
            // 1️⃣ Tạo các phòng ban
            Department it = new Department(null, "IT Department", null);
            Department hr = new Department(null, "Human Resources", null);
            deptRepo.saveAll(Arrays.asList(it, hr));

            // 2️⃣ Tạo các nhân viên
            Employee e1 = new Employee(null, LocalDate.of(1998, 5, 10), "Alice", it);
            Employee e2 = new Employee(null, LocalDate.of(2000, 1, 20), "Bob", it);
            Employee e3 = new Employee(null, LocalDate.of(1995, 3, 15), "Cathy", hr);

            empRepo.saveAll(Arrays.asList(e1, e2, e3));

            // In danh sách phòng ban
            System.out.println("\n Danh sách phòng ban:");
            deptRepo.findAll().forEach(d ->
                    System.out.println("ID: " + d.getDeptId() + " | Tên: " + d.getDeptName() + " | Nhân viên: " + d.getEmployees())
            );

            // In danh sách nhân viên
            System.out.println("\n Danh sách nhân viên:");
            empRepo.findAll().forEach(e -> {
                System.out.println("ID: " + e.getEmpId()
                        + " | Tên: " + e.getEmpName()
                        + " | Ngày sinh: " + e.getDob()
                        + " | Phòng ban: " + e.getDepartment().getDeptName());
            });
        };
    }
}
