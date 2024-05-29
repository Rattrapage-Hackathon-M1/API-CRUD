package fr.esgi.User_Task.domain.ports.api;


import fr.esgi.User_Task.domain.ports.Tache;
import fr.esgi.User_Task.domain.ports.spi.ITacheDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheService implements ITacheService {
    private final ITacheDao iTacheDao;

    public TacheService(ITacheDao iTacheDao) {
        this.iTacheDao = iTacheDao;
    }

    @Override
    public List<Tache> recupererTaches() {
        return this.iTacheDao.getAll();
    }

    @Override
    public Tache getOneTacheById(final Long id) {
        return this.iTacheDao.getOneTacheById(id);
    }

    @Override
    public Tache add(Tache tache) {
        return this.iTacheDao.add(tache);
    }

    @Override
    public Tache updateTache(Tache tache) {
        return this.iTacheDao.updateTache(tache);
    }

    @Override
    public void deleteTache(Long id) {
        this.iTacheDao.deleteTache(id);
    }
}
