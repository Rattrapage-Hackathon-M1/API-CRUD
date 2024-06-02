package fr.esgi.User_Task.domain.ports.api;


import fr.esgi.User_Task.domain.ports.Tache;
import fr.esgi.User_Task.domain.ports.spi.ITacheDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        List<Tache> taches = this.iTacheDao.getAll();
        for (Tache t : taches) {
            if (t.getTitre().equals(tache.getTitre())) {
                return null;
            }
        }
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
