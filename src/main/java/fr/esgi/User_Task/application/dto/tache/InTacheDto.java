package fr.esgi.User_Task.application.dto.tache;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InTacheDto {
    private String titre;
    private String description;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private boolean isDone;
    private Long utilisateurId;

    public String getNom() {
        return titre;
    }

    public void setNom(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getLocalDateDebut() {
        return dateDebut;
    }
    
    public void setLocalDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    public LocalDate getLocalDateFin() {
        return dateFin;
    }
    
    public void setLocalDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public InTacheDto(String titre, String description, LocalDate dateDebut, LocalDate dateFin, boolean isDone) {
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.isDone = isDone;
    }
}
