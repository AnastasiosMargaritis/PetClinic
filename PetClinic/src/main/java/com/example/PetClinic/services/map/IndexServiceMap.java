package com.example.PetClinic.services.map;

import com.example.PetClinic.model.Index;
import com.example.PetClinic.services.CrudService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class IndexServiceMap extends AbstractMapService<Index, Long> implements CrudService<Index, Long> {

    @Override
    public Set<Index> findAll() {
        return super.findAll();
    }

    @Override
    public Index findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Index save(Index object) {
        return super.save(object);
    }

    @Override
    public void delete(Index object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
