package fr.esgi.User_Task.infrastructure.mapper;

import fr.esgi.User_Task.domain.ports.Tache;
import fr.esgi.User_Task.infrastructure.entity.TacheEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TacheDomainToEntityMapper {
    @Mapping(source = "utilisateur.id", target = "utilisateurId")
    TacheEntity domainToEntity(Tache domain);

    @Mapping(source = "utilisateurId", target = "utilisateur.id")
    Tache entityToDomain(TacheEntity entity);
}

