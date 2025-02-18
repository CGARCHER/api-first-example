package org.example.service;

import org.example.mapper.CatMapper;
import org.example.repository.CatRepository;
import org.generator.model.CatDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements ICatService {

    private final CatMapper catMapper;
    private final CatRepository catRepository;

    public CatServiceImpl(CatMapper catMapper, CatRepository catRepository) {
        this.catMapper = catMapper;
        this.catRepository = catRepository;
    }

    @Override
    public List<CatDTO> getAll() {
        return catMapper.catToCatDTO(catRepository.findAll());
    }
}