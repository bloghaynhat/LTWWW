package iuh.fit.bai1.daos;

import iuh.fit.bai1.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public List<User> getAll();

    public User findById(int id);

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(int id);
}
