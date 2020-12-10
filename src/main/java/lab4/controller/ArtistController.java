package lab4.controller;

import lab4.model.dao.ArtistDAO;
import lab4.model.entity.Artist;

import java.util.List;

public class ArtistController implements GeneralController<Artist> {


    ArtistDAO artistDAO = new ArtistDAO();

    @Override
    public List<Artist> findAll() {
        return artistDAO.findAll();
    }

    @Override
    public Artist findOne(Integer id) {
        return artistDAO.findOne(id);

    }

    @Override
    public void create(Artist artist) {
        artistDAO.create(artist);

    }

    @Override
    public void update(Integer id, Artist artist) {
        artistDAO.update(id, artist);

    }

    @Override
    public void delete(Integer id) {
        artistDAO.delete(id);

    }
}
