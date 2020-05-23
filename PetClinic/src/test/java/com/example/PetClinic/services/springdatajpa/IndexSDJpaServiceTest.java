package com.example.PetClinic.services.springdatajpa;

import com.example.PetClinic.model.Index;
import com.example.PetClinic.repositories.IndexRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
class IndexSDJpaServiceTest {

    @Mock
    IndexRepository indexRepository;

    @InjectMocks
    IndexSDJpaService indexSDJpaService;

    Index returnIndex;

    @BeforeEach
    void setUp(){
        returnIndex = Index.indexBuilder().id(1L).description("Some description").message("Some message").build();
    }

    @Test
    void findAll() {

        Set<Index> indices = new HashSet<>();

        indices.add(Index.indexBuilder().id(1L).build());
        indices.add(Index.indexBuilder().id(2L).build());

        lenient().when(indexRepository.findAll()).thenReturn(indices);

        Set<Index> indexSet = (Set<Index>) indexRepository.findAll();

        assertNotNull(indexSet);
        assertEquals(2, indexSet.size());
    }

    @Test
    void findById() {

        when(indexRepository.findById(anyLong())).thenReturn(Optional.of(returnIndex));

        Index index = indexSDJpaService.findById(1L);

        assertNotNull(index);
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}