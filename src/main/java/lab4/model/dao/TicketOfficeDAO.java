package lab4.model.dao;

import lab4.model.entity.TicketOffice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TicketOfficeDAO implements GeneralDAO<TicketOffice> {


    private static final String GET_ALL = "SELECT * FROM bardyn_lab3.ticket_office";
    private static final String GET_ONE = "SELECT * FROM bardyn_lab3.ticket_office WHERE id=?";
    private static final String CREATE = "INSERT bardyn_lab3.ticket_office "
            + "(location_id) VALUES (?)";
    private static final String UPDATE = "UPDATE bardyn_lab3.ticket_office"
            + " SET location_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM bardyn_lab3.ticket_office WHERE id=?";

    @Override
    public List<TicketOffice> findAll() {
        List<TicketOffice> ticketOffices = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TicketOffice ticketOffice = new TicketOffice(
                        resultSet.getInt("id"),
                        resultSet.getInt("location_id")
                );
                ticketOffices.add(ticketOffice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketOffices;
    }

    @Override
    public TicketOffice findOne(Integer id) {
        TicketOffice ticketOffice = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ticketOffice = new TicketOffice(
                        resultSet.getInt("id"),
                        resultSet.getInt("location_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketOffice;
    }

    @Override
    public void create(TicketOffice ticketOffice) {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setInt(1, ticketOffice.getLocationId());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, TicketOffice ticketOffice) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setInt(1, ticketOffice.getLocationId());
            statement.setInt(2, id);

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
