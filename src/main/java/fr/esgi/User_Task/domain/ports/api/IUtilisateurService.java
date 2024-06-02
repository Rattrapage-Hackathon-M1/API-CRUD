package fr.esgi.User_Task.domain.ports.api;

import fr.esgi.User_Task.domain.ports.Utilisateur;

public interface IUtilisateurService {

        Utilisateur addUtilisateur(Utilisateur utilisateur);

        Utilisateur getUtilisateurById(Long id);

        Utilisateur updateUtilisateur(Utilisateur utilisateur);

        void deleteUtilisateur(Long id);

        Iterable<Utilisateur> getAllUtilisateurs();
}
