package fr.esgi.User_Task.infrastructure.mapper;

import fr.esgi.User_Task.domain.ports.Utilisateur;
import fr.esgi.User_Task.infrastructure.entity.UtilisateurEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityToDomainUtilisateurMapper {
    Utilisateur toDomain(UtilisateurEntity entity);
    UtilisateurEntity toEntity(Utilisateur domain);
}

