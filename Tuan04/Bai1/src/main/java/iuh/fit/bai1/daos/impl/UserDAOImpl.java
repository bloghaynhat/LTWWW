package iuh.fit.bai1.daos.impl;

import iuh.fit.bai1.entities.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements iuh.fit.bai1.daos.UserDAO {
    private final DataSource dataSource;

    public UserDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<User> getAll(){
        String sql = """
                SELECT id, name, email, birthday, password, gender FROM users
                """;
        List<User> list = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
        ){
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getNString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String birthday = rs.getString("birthday");
                String gender = rs.getString("gender");
                list.add(new User(id, name, email, password, birthday, gender));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public User findById(int id) throws SQLException {
        String sql = """
                SELECT id, name, email, birthday, password, gender FROM users
                WHERE id = ?
                """;
        try (Connection con = dataSource.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String birthday = rs.getString("birthday");
                String gender = rs.getString("gender");
                return new User(userId, name, email, password, birthday, gender);
            }
        }
        return null;
    }

    @Override
    public boolean addUser(User user) throws SQLException {
        String sql = """
                INSERT INTO users (name, email, password, birthday, gender) VALUES (?, ?, ?, ?, ?)
                """;
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setNString(1, user.getName());
            ps.setNString(2, user.getEmail());
            ps.setNString(3, user.getPassword());
            ps.setNString(4, user.getBirthday());
            ps.setNString(5, user.getGender());

            int row = ps.executeUpdate();
            return row > 0;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        String sql = """
                UPDATE users SET name = ?, email = ?, password = ?, birthday = ?, gender = ?
                WHERE id = ?
                """;
        try(Connection con = dataSource.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setNString(1, user.getName());
            ps.setNString(2, user.getEmail());
            ps.setNString(3, user.getPassword());
            ps.setNString(4, user.getBirthday());
            ps.setNString(5, user.getGender());
            ps.setInt(6, user.getId());
            int row = ps.executeUpdate();
            return row > 0;

        }
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        String sql = """
                DELETE FROM users WHERE id = ?
                """;
        try (Connection con = dataSource.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
            return row > 0;
        }
    }
}
