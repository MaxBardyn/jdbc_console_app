package lab4.model.dao;

import lab4.model.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements GeneralDAO<User> {


    private static final String GET_ALL = "SELECT * FROM bardyn_lab3.user";
    private static final String GET_ONE = "SELECT * FROM bardyn_lab3.user WHERE id=?";
    private static final String CREATE = "INSERT bardyn_lab3.user "
            + "(name, surname, age) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE bardyn_lab3.user"
            + " SET name=?, surname=?, age=? WHERE id=?";
    private static final String DELETE = "DELETE FROM bardyn_lab3.user WHERE id=?";


    @Override
    public List<User> findAll() {
        List<User> userArrayList = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age")
                );
                userArrayList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userArrayList;
    }

    @Override
    public User findOne(Integer id) {
        User user = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(user.getName()));
            statement.setString(2, String.valueOf(user.getSurname()));
            statement.setInt(3, user.getAge());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, User user) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(user.getName()));
            statement.setString(2, String.valueOf(user.getSurname()));
            statement.setInt(3, user.getAge());
            statement.setInt(4, id);

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
