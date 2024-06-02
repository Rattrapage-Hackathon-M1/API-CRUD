package fr.esgi.User_Task.infrastructure.repository;

import fr.esgi.User_Task.infrastructure.entity.TacheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TacheRepository extends JpaRepository<TacheEntity, Long> {
    Optional<TacheEntity> findByTitre(String titre);
}
