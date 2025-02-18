package org.example.service;

import org.example.entity.Cat;
import org.generator.model.CatDTO;

import java.util.List;

public interface ICatService {
    List<CatDTO> getAll();
}
