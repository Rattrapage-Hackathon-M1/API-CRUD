package fr.esgi.User_Task.infrastructure.adapter;

import fr.esgi.User_Task.application.mapper.TacheDtoToDomainMapper;
import fr.esgi.User_Task.domain.ports.Tache;
import fr.esgi.User_Task.domain.ports.spi.ITacheDao;
import fr.esgi.User_Task.infrastructure.entity.TacheEntity;
import fr.esgi.User_Task.infrastructure.mapper.TacheDomainToEntityMapper;
import fr.esgi.User_Task.infrastructure.repository.TacheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TacheDao implements ITacheDao {
    private final TacheRepository tacheRepository;
    private final TacheDtoToDomainMapper tacheDtoToDomainMapper;
    private final TacheDomainToEntityMapper tacheDomainToEntityMapper;

    public TacheDao(TacheRepository tacheRepository, TacheDtoToDomainMapper tacheDtoToDomainMapper, TacheDomainToEntityMapper tacheDomainToEntityMapper) {
        this.tacheRepository = tacheRepository;
        this.tacheDtoToDomainMapper = tacheDtoToDomainMapper;
        this.tacheDomainToEntityMapper = tacheDomainToEntityMapper;
    }

    @Override
    public List<Tache> getAll() {
        List<TacheEntity> tacheEntities = this.tacheRepository.findAll();
        return tacheEntities.stream()
                .map(this.tacheDomainToEntityMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Tache getOneTacheById(Long id) {
        final TacheEntity tacheEntity = this.tacheRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tache not found"));

        return this.tacheDomainToEntityMapper.entityToDomain(tacheEntity);
    }

    @Override
    public Tache add(final Tache tache) {
        final TacheEntity entity = this.tacheDomainToEntityMapper.domainToEntity(tache);
        return this.tacheDomainToEntityMapper.entityToDomain(this.tacheRepository.save(entity));
    }

    @Override
    public Tache updateTache(Tache tache) {
        Optional<TacheEntity> entityToUpdate = this.tacheRepository.findById(tache.getId());
        if (entityToUpdate.isEmpty()) {
            throw new NoSuchElementException("Tache not found with ID: " + tache.getId());
        }

        final TacheEntity savedEntity = this.tacheRepository.save(this.tacheDomainToEntityMapper.domainToEntity(tache));

        return this.tacheDomainToEntityMapper.entityToDomain(savedEntity);
    }

    @Override
    public void deleteTache(Long id) {
        final Optional<TacheEntity> tache = this.tacheRepository.findById(id);

        if (tache.isEmpty()) {
            throw new NoSuchElementException("Tache not found with ID: " + id);
        }
        this.tacheRepository.deleteById(id);
    }

}
