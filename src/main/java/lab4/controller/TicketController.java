package lab4.controller;

import lab4.model.dao.TicketDAO;
import lab4.model.entity.Ticket;

import java.util.List;

public class TicketController implements GeneralController<Ticket> {


    TicketDAO ticketDAO = new TicketDAO();

    @Override
    public List<Ticket> findAll() {
        return ticketDAO.findAll();
    }

    @Override
    public Ticket findOne(Integer id) {
        return ticketDAO.findOne(id);
    }

    @Override
    public void create(Ticket ticket) {
        ticketDAO.create(ticket);
    }

    @Override
    public void update(Integer id, Ticket ticket) {
        ticketDAO.update(id, ticket);
    }

    @Override
    public void delete(Integer id) {
        ticketDAO.delete(id);
    }
}
