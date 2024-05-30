package fr.esgi.User_Task.infrastructure.repository;

import fr.esgi.User_Task.infrastructure.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {
}
