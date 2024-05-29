package fr.esgi.User_Task.domain.repository;

import fr.esgi.User_Task.domain.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
