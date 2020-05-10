package com.example.PetClinic.services.springdatajpa;

import com.example.PetClinic.model.Index;
import com.example.PetClinic.repositories.IndexRepository;
import com.example.PetClinic.services.IndexService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class IndexSDJpaService implements IndexService {

    private final IndexRepository indexRepository;

    public IndexSDJpaService(IndexRepository indexRepository) {
        this.indexRepository = indexRepository;
    }

    @Override
    public Set<Index> findAll() {

        Set<Index> indices = new HashSet<>();
        this.indexRepository.findAll().forEach(indices::add);
        return indices;
    }

    @Override
    public Index findById(Long aLong) {
        return this.indexRepository.findById(aLong).orElse(null);
    }

    @Override
    public Index save(Index object) {
        return this.indexRepository.save(object);
    }

    @Override
    public void delete(Index object) {
        this.indexRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.indexRepository.deleteById(aLong);
    }
}
