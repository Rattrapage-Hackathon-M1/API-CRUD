package fr.esgi.User_Task.domain.ports.spi;

import fr.esgi.User_Task.domain.ports.Tache;

import java.util.List;

public interface ITacheDao {
    public List<Tache> getAll();
    public Tache getOneTacheById(Long id);
    public Tache findByTitre(String titre);

    Tache getOneTacheByTitre(String titre);

    public Tache add(final Tache tache);
    public Tache updateTache(Tache tache);
    public void deleteTache(Long id);
}
