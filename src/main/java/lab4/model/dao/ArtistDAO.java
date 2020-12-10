package lab4.model.dao;

import lab4.DatabaseConnector;
import lab4.model.entity.Artist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ArtistDAO implements GeneralDAO<Artist> {

    private static final String GET_ALL = "SELECT * FROM bardyn_lab3.artist";
    private static final String GET_ONE = "SELECT * FROM bardyn_lab3.artist WHERE id=?";
    private static final String CREATE = "INSERT bardyn_lab3.artist "
            + "(name, surname, age, alias) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE bardyn_lab3.artist"
            + " SET name=?, surname=?, age=?, alias=? WHERE id=?";
    private static final String DELETE = "DELETE FROM bardyn_lab3.artist WHERE id=?";

    @Override
    public List<Artist> findAll() {
        List<Artist> artists = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Artist artist = new Artist(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("alias")
                );
                artists.add(artist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artists;
    }


    @Override
    public Artist findOne(Integer id) {
        Artist artist = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                artist = new Artist(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("alias")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artist;
    }

    @Override
    public void create(Artist artist) {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(artist.getName()));
            statement.setString(2, String.valueOf(artist.getSurname()));
            statement.setInt(3, artist.getAge());
            statement.setString(4, String.valueOf(artist.getAlias()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Artist artist) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(artist.getName()));
            statement.setString(2, String.valueOf(artist.getSurname()));
            statement.setInt(3, artist.getAge());
            statement.setString(4, String.valueOf(artist.getAlias()));
            statement.setInt(5, id);

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




