package fr.esgi.User_Task.application.mapper;

import fr.esgi.User_Task.application.dto.tache.InTacheDto;
import fr.esgi.User_Task.application.dto.tache.OutTacheDto;
import fr.esgi.User_Task.domain.ports.Tache;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TacheDtoToDomainMapper {
    Tache inDtoToDomain(final InTacheDto inDto);
    OutTacheDto domainToOutDto(final Tache domain);
}
