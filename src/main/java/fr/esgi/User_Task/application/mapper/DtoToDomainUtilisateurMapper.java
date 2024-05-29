package fr.esgi.User_Task.application.mapper;

import fr.esgi.User_Task.application.dto.InUtilisateurDto;
import fr.esgi.User_Task.application.dto.OutUtilisateurDto;
import fr.esgi.User_Task.domain.ports.Utilisateur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DtoToDomainUtilisateurMapper {
    OutUtilisateurDto toOutUtilisateurDto(final Utilisateur domain);
    InUtilisateurDto toInUtilisateurDto(final Utilisateur domain);
    Utilisateur toDomain(final InUtilisateurDto inDto);
}
