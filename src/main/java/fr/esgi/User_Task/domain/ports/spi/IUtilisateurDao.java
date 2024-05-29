package fr.esgi.User_Task.domain.ports.spi;

import fr.esgi.User_Task.domain.ports.Utilisateur;

public interface IUtilisateurDao {

    Utilisateur addUtilisateur(Utilisateur domain);

    Utilisateur getUtilisateurById(Long id);

    Utilisateur updateUtilisateur(Utilisateur utilisateur);

    void deleteUtilisateur(Long id);
}
