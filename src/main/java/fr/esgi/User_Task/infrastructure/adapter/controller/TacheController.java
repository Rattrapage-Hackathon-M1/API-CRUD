package fr.esgi.User_Task.infrastructure.adapter.controller;

import fr.esgi.User_Task.application.service.TacheService;
import fr.esgi.User_Task.domain.model.Tache;
import fr.esgi.User_Task.domain.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

    @Autowired
    private TacheService tacheService;

    @GetMapping
    public List<Tache> getAllTaches() {
        return tacheService.getAllTaches();
    }

    @GetMapping("/{id}")
    public Optional<Tache> getTacheById(@PathVariable Long id) {
        return tacheService.getTacheById(id);
    }

    @PostMapping
    public Tache createTache(@RequestBody Tache tache) {
        return tacheService.saveTache(tache);
    }

    @PutMapping("/{id}")
    public Tache updateTache(@PathVariable Long id, @RequestBody Tache tache) {
        tache.setId(id);
        return tacheService.saveTache(tache);
    }

    @DeleteMapping("/{id}")
    public void deleteTache(@PathVariable Long id) {
        tacheService.deleteTache(id);
    }
}
