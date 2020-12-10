package lab4.model.dao;

import lab4.DatabaseConnector;
import lab4.model.entity.Location;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO implements GeneralDAO<Location> {

    private static final String GET_ALL = "SELECT * FROM bardyn_lab3.location";
    private static final String GET_ONE = "SELECT * FROM bardyn_lab3.location WHERE id=?";
    private static final String CREATE = "INSERT bardyn_lab3.location "
            + "(name, address) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE bardyn_lab3.location"
            + " SET name=?, address=? WHERE id=?";
    private static final String DELETE = "DELETE FROM bardyn_lab3.location WHERE id=?";


    @Override
    public List<Location> findAll() {
        List<Location> locations = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Location location = new Location(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address")
                );
                locations.add(location);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public Location findOne(Integer id) {
        Location location = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                location = new Location(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    @Override
    public void create(Location location) {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(location.getName()));
            statement.setString(2, String.valueOf(location.getAddress()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Location location) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(location.getName()));
            statement.setString(2, String.valueOf(location.getAddress()));
            statement.setInt(3, id);

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
