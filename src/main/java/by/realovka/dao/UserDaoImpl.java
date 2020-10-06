package by.realovka.dao;

import by.realovka.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;


@Repository
public class UserDaoImpl implements UserDao{

    private Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createUser(User user){
        try {
            String sql = "INSERT INTO users_test VALUES (default, ?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, user.getName());
                ps.setString(2, user.getLogin());
                ps.setString(3, user.getPassword());
                ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> containsByLogin(String login) {
        try {
            String sql = "SELECT * FROM users_test WHERE login=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new User(rs.getString("login")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> containsUser(User user) {
        try {
            String sql = "SELECT * FROM users_test WHERE login=? AND password=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new User(rs.getString("name"), rs.getString("login"), rs.getString("password")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateUser(User oldUser, User newUser){
        try {
            String sql = "UPDATE users_test SET name=?, password=? WHERE login=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newUser.getName());
            ps.setString(2, newUser.getPassword());
            ps.setString(3, oldUser.getLogin());
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user){
        try{
            String sql = "DELETE FROM users_test WHERE login = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
