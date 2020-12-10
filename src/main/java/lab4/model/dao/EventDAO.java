package lab4.model.dao;

import lab4.DatabaseConnector;
import lab4.model.entity.Event;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventDAO implements GeneralDAO<Event> {

    private static final String GET_ALL = "SELECT * FROM bardyn_lab3.event";
    private static final String GET_ONE = "SELECT * FROM bardyn_lab3.event WHERE id=?";
    private static final String CREATE = "INSERT bardyn_lab3.event "
            + "(name, location_id, artist_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE bardyn_lab3.event"
            + " SET name=?, location_id=?, artist_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM bardyn_lab3.event WHERE id=?";


    @Override
    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Event event = new Event(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("location_id"),
                        resultSet.getInt("artist_id")
                );
                events.add(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public Event findOne(Integer id) {
        Event event = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                event = new Event(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("location_id"),
                        resultSet.getInt("artist_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public void create(Event event) {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(event.getName()));
            statement.setString(2, String.valueOf(event.getLocationId()));
            statement.setString(3, String.valueOf(event.getArtistId()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Event event) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(event.getName()));
            statement.setString(2, String.valueOf(event.getLocationId()));
            statement.setString(3, String.valueOf(event.getArtistId()));
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
