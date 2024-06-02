package fr.esgi.User_Task.domain.ports.api;

import fr.esgi.User_Task.domain.ports.Tache;
import fr.esgi.User_Task.domain.ports.spi.ITacheDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TacheServiceTest {
    private ITacheDao iTacheDao;
    private TacheService tacheService;

    @BeforeEach
    public void setup() {
        iTacheDao = Mockito.mock(ITacheDao.class);
        tacheService = new TacheService(iTacheDao);
    }

    @Test
    public void testRecupererTaches() {
        Tache tache1 = new Tache();
        Tache tache2 = new Tache();
        List<Tache> expectedTaches = Arrays.asList(tache1, tache2);

        when(iTacheDao.getAll()).thenReturn(expectedTaches);

        List<Tache> actualTaches = tacheService.recupererTaches();

        assertEquals(expectedTaches, actualTaches);
    }

    @Test
    public void testGetOneTacheById() {
        Tache expectedTache = new Tache();
        Long id = 1L;

        when(iTacheDao.getOneTacheById(id)).thenReturn(expectedTache);

        Tache actualTache = tacheService.getOneTacheById(id);

        assertEquals(expectedTache, actualTache);
    }

    @Test
    public void testAdd() {
        Tache tache = new Tache();
        Tache expectedTache = new Tache();

        when(iTacheDao.add(tache)).thenReturn(expectedTache);

        Tache actualTache = tacheService.add(tache);

        assertEquals(expectedTache, actualTache);
    }

    @Test
    public void testUpdateTache() {
        Tache tache = new Tache();
        Tache expectedTache = new Tache();

        when(iTacheDao.updateTache(tache)).thenReturn(expectedTache);

        Tache actualTache = tacheService.updateTache(tache);

        assertEquals(expectedTache, actualTache);
    }
}