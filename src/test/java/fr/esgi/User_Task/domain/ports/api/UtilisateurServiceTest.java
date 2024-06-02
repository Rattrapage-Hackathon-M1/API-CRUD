package fr.esgi.User_Task.domain.ports.api;

import fr.esgi.User_Task.domain.ports.Utilisateur;
import fr.esgi.User_Task.domain.ports.spi.IUtilisateurDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UtilisateurServiceTest {
    private IUtilisateurDao iUtilisateurDao;
    private UtilisateurService utilisateurService;

    @BeforeEach
    public void setup() {
        iUtilisateurDao = Mockito.mock(IUtilisateurDao.class);
        utilisateurService = new UtilisateurService(iUtilisateurDao);
    }

    @Test
    public void testAddUtilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        Utilisateur expectedUtilisateur = new Utilisateur();

        when(iUtilisateurDao.addUtilisateur(utilisateur)).thenReturn(expectedUtilisateur);

        Utilisateur actualUtilisateur = utilisateurService.addUtilisateur(utilisateur);

        assertEquals(expectedUtilisateur, actualUtilisateur);
    }

    @Test
    public void testGetAllUtilisateurs() {
        Utilisateur utilisateur1 = new Utilisateur();
        Utilisateur utilisateur2 = new Utilisateur();
        List<Utilisateur> expectedUtilisateurs = Arrays.asList(utilisateur1, utilisateur2);

        when(iUtilisateurDao.getAllUtilisateurs()).thenReturn(expectedUtilisateurs);

        List<Utilisateur> actualUtilisateurs = utilisateurService.getAllUtilisateurs();

        assertEquals(expectedUtilisateurs, actualUtilisateurs);
    }


    public void testGetUtilisateurById() {
        Utilisateur expectedUtilisateur = new Utilisateur();
        Long id = 1L;

        when(iUtilisateurDao.getUtilisateurById(id)).thenReturn(expectedUtilisateur);

        Utilisateur actualUtilisateur = utilisateurService.getUtilisateurById(id);

        assertEquals(expectedUtilisateur, actualUtilisateur);
    }

    public void testUpdateUtilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        Utilisateur expectedUtilisateur = new Utilisateur();

        when(iUtilisateurDao.updateUtilisateur(utilisateur)).thenReturn(expectedUtilisateur);

        Utilisateur actualUtilisateur = utilisateurService.updateUtilisateur(utilisateur);

        assertEquals(expectedUtilisateur, actualUtilisateur);
    }

    @Test
    public void testDeleteUtilisateur() {
        Long id = 1L;

        utilisateurService.deleteUtilisateur(id);

        Mockito.verify(iUtilisateurDao).deleteUtilisateur(id);
    }
}