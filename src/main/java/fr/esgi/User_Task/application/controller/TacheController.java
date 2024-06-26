package fr.esgi.User_Task.application.controller;

import fr.esgi.User_Task.application.dto.tache.InTacheDto;
import fr.esgi.User_Task.application.dto.tache.OutTacheDto;
import fr.esgi.User_Task.application.mapper.TacheDtoToDomainMapper;
import fr.esgi.User_Task.domain.ports.api.TacheService;
import fr.esgi.User_Task.domain.ports.Tache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(("/api/taches"))
public class TacheController {
    private final TacheDtoToDomainMapper mapper;
    private final TacheService tacheService;
    Logger logger = LoggerFactory.getLogger(TacheController.class);
    public TacheController(TacheDtoToDomainMapper mapper, TacheService tacheService) {
        this.mapper = mapper;
        this.tacheService = tacheService;
    }
    @GetMapping("/get-all-taches")
    public ResponseEntity<List<OutTacheDto>> recupererTaches() {
        List<Tache> taches = this.tacheService.recupererTaches();
        return new ResponseEntity<>(
                taches.stream()
                        .map(mapper::domainToOutDto)
                        .collect(Collectors.toList()
                        ),
                HttpStatus.OK
        );
    }

    @GetMapping("/get-tache-by-id/{id}")
    public ResponseEntity<OutTacheDto> getOneById(@PathVariable Long id) {
        logger.info("getOneById called with id: " + id);
        OutTacheDto tacheDto = this.mapper.domainToOutDto(this.tacheService.getOneTacheById(id));
        return new ResponseEntity<>(tacheDto, HttpStatus.OK);
    }


    @PostMapping("/nouveau-tache")
    public ResponseEntity addTache(@RequestBody final InTacheDto body) {
        final Tache domain = this.mapper.inDtoToDomain(body);
        final Tache nouveauTache = this.tacheService.add(domain);
        if(nouveauTache == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Tâche ajoutée avec succès", HttpStatus.CREATED);
    }

    @PutMapping("/modifie-tache/{id}")
    public ResponseEntity editTache(@RequestBody final Tache tache) {
        final Tache tacheModifie = this.tacheService.updateTache(tache);
        if(tacheModifie == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer-tache")
    public ResponseEntity deleteTache(@RequestParam final Long id) {
        try {
            this.tacheService.deleteTache(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
}
