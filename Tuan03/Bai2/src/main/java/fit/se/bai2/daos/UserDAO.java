package fit.se.bai2.daos;

import fit.se.bai2.models.User;
import fit.se.bai2.utils.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDAO {
    public UserDAO() {
    }

    public void addUser(User user){
        String sql = "INSERT INTO users (firstName, lastName, email, password, birthday, gender) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectDB.getConnection()){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getBirthday());
            statement.setString(6, user.getGender());
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Set<User> getAllUser(){
        String sql = "SELECT id, firstName, lastName, email, birthday, gender FROM users";
        Set<User> users = new HashSet<>();
        try(Connection conn = ConnectDB.getConnection()){
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getString("birthday"));
                user.setGender(rs.getString("gender"));
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
