package fr.esgi.User_Task.domain.ports.api;


import fr.esgi.User_Task.domain.ports.Utilisateur;
import fr.esgi.User_Task.domain.ports.spi.IUtilisateurDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UtilisateurService implements IUtilisateurService{

    private final IUtilisateurDao iUtilisateurDao;
    
    public UtilisateurService(IUtilisateurDao iUtilisateurDao) {
        this.iUtilisateurDao = iUtilisateurDao;
    }

                              @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur){
        return iUtilisateurDao.addUtilisateur(utilisateur);
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return this.iUtilisateurDao.getAllUtilisateurs();
    }

    @Override
    public Utilisateur getUtilisateurById(Long id) {
        return iUtilisateurDao.getUtilisateurById(id);
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        final Utilisateur foundUtilisateur = getUtilisateurById(utilisateur.getId());

        if(foundUtilisateur == null){
            throw new NoSuchElementException("Utilisateur not found with ID: " + utilisateur.getId());
        }

        return iUtilisateurDao.updateUtilisateur(utilisateur);
    }

    @Override
    public void deleteUtilisateur(Long id) {
        iUtilisateurDao.deleteUtilisateur(id); }
}