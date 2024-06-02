package fr.esgi.User_Task.application;

import fr.esgi.User_Task.application.dto.tache.InTacheDto;
import fr.esgi.User_Task.application.mapper.TacheDtoToDomainMapper;
import fr.esgi.User_Task.domain.ports.Tache;
import fr.esgi.User_Task.domain.ports.api.TacheService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer {

    private final TacheService tacheService;
    private final TacheDtoToDomainMapper mapper;

    public DataInitializer(TacheService tacheService, TacheDtoToDomainMapper mapper) {
        this.tacheService = tacheService;
        this.mapper = mapper;
    }

    @PostConstruct
    public void initData() {
    List<InTacheDto> taches = Arrays.asList(
            new InTacheDto(1L, "Finir le CRUD", "Finir un crud c'est toujours plus sympa pour une démo non ?", LocalDate.now(), LocalDate.now().plusDays(1), false, 1L),
            new InTacheDto(2L, "Brûler les CORS", "Les CORS étant un enfer, il faut les éradiquer.", LocalDate.now(), LocalDate.now().plusDays(5), false, 1L),
            new InTacheDto(3L, "Faire un front", "Un front en React, c'est toujours plus sympa.", LocalDate.now().minusDays(3), LocalDate.now().plusDays(10), false, 1L),
            new InTacheDto(4L, "Faire un back", "Un back en Java, c'est toujours plus sympa.", LocalDate.now().minusDays(3), LocalDate.now().plusDays(10), true, 1L),
            new InTacheDto(5L, "Init Github", "Créer les répo gits", LocalDate.now().minusDays(3), LocalDate.now().minusDays(1), true, 1L)
    );

    taches.forEach(tacheDto -> {
        Tache tache = mapper.inDtoToDomain(tacheDto);
        tacheService.add(tache);
    });
}
}