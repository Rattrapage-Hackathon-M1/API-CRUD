package fr.esgi.User_Task.infrastructure.repository;

import fr.esgi.User_Task.infrastructure.entity.TacheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<TacheEntity, Long> {
}
