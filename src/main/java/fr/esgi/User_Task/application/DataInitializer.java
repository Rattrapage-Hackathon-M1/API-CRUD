package fr.esgi.User_Task.application;

import fr.esgi.User_Task.application.dto.tache.InTacheDto;
import fr.esgi.User_Task.application.mapper.TacheDtoToDomainMapper;
import fr.esgi.User_Task.domain.ports.Tache;
import fr.esgi.User_Task.domain.ports.api.TacheService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
                new InTacheDto("Tache 1", "Description 1", "2024-05-01", "2024-05-31", false),
                new InTacheDto("Tache 2", "Description 2", "2024-06-01", "2024-06-30", false)
        );

        taches.forEach(tacheDto -> {
            Tache tache = mapper.inDtoToDomain(tacheDto);
            tacheService.add(tache);
        });
    }
}