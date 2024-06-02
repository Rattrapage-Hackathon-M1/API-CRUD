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
            new InTacheDto(1L, "Tache 1", "Description 1", LocalDate.now(), LocalDate.now().plusDays(1), false, 1L),
            new InTacheDto(2L, "Tache 2", "Description 2", LocalDate.now(), LocalDate.now().plusDays(2), false, 1L)
    );

    taches.forEach(tacheDto -> {
        Tache tache = mapper.inDtoToDomain(tacheDto);
        tacheService.add(tache);
    });
}
}