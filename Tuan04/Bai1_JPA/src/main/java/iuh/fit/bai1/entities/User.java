package iuh.fit.bai1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 8, max = 50, message = "Name must be between 8 and 50 characters")
    @Column(nullable = false, length = 50)
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email should be valid")
    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, message = "Password must be at least 6 character")
    private String password;

    @Past(message = "Birthday must be in the past")
    private LocalDate birthday;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "Male|Female", message = "Gender must be Male or Female")
    private String gender;

    public User() {
    }

    public User(String name, String email, String password, LocalDate birthday, String gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
    }

    public User(int id, String name, String email, String password, LocalDate birthday, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
