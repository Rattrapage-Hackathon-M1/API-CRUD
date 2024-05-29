package fr.esgi.User_Task.domain.ports.api;

import fr.esgi.User_Task.domain.ports.Tache;

import java.util.List;

public interface ITacheService {

    public List<Tache> recupererTaches();
    public Tache getOneTacheById(Long id);
    public Tache add(final Tache tache);
    public Tache updateTache(Tache tache);
    public void deleteTache(Long id);
}
