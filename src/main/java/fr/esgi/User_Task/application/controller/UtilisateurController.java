package fr.esgi.User_Task.application.controller;


import fr.esgi.User_Task.application.dto.InUtilisateurDto;
import fr.esgi.User_Task.application.dto.OutUtilisateurDto;
import fr.esgi.User_Task.application.mapper.DtoToDomainUtilisateurMapper;
import fr.esgi.User_Task.domain.ports.api.UtilisateurService;
import fr.esgi.User_Task.domain.ports.Utilisateur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {
    private final DtoToDomainUtilisateurMapper mapper;
    private final UtilisateurService utilisateurService;
    public UtilisateurController(DtoToDomainUtilisateurMapper mapper, UtilisateurService utilisateurService) {
        this.mapper = mapper;
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/nouveau-utilisateur")
    public ResponseEntity add(@RequestBody final InUtilisateurDto body) {

        final Utilisateur utilisateurAdded = utilisateurService.addUtilisateur(this.mapper.toDomain(body));
        if (utilisateurAdded == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(this.mapper.toOutUtilisateurDto(utilisateurAdded),HttpStatus.CREATED);
    }

    @GetMapping("/get-utilisateur-by-id")
    public ResponseEntity getById(@RequestParam final Long id) {
        final OutUtilisateurDto outDto = this.mapper.toOutUtilisateurDto(this.utilisateurService.getUtilisateurById(id));
        return new ResponseEntity(outDto,HttpStatus.FOUND);
    }

    @PutMapping("/modifie-utilisateur")
    public ResponseEntity updateUtilisateur(@RequestBody final InUtilisateurDto inUtilisateurDto) {
        final Utilisateur domain = this.mapper.toDomain(inUtilisateurDto);

        try {
            final Utilisateur updatedUtilisateur = this.utilisateurService.updateUtilisateur(domain);
            return new ResponseEntity(this.mapper.toOutUtilisateurDto(updatedUtilisateur),HttpStatus.OK);
        } catch (final Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/supprimer-utilisateur")
    public ResponseEntity deleteUtilisateur(@RequestParam final Long id) {
        try {
            this.utilisateurService.deleteUtilisateur(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (final Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
