package fr.esgi.User_Task.infrastructure.mapper;

import fr.esgi.User_Task.domain.ports.Tache;
import fr.esgi.User_Task.infrastructure.entity.TacheEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TacheDomainToEntityMapper {
    TacheEntity domainToEntity(final Tache domain);
    Tache entityToDomain(final TacheEntity entity);
}
