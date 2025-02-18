package org.example.controller;

import org.example.service.ICatService;
import org.generator.api.CatsApi;
import org.generator.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatController implements CatsApi {


    private final ICatService catService;

    public CatController(ICatService catService) {
        this.catService = catService;
    }

    @Override
    public ResponseEntity<CatDTO> addChipToCat(Integer id, ChipDTO chipDTO) {
        return CatsApi.super.addChipToCat(id, chipDTO);
    }

    @Override
    public ResponseEntity<CatDTO> createCat(CreateCatDTO createCatDTO) {
        return CatsApi.super.createCat(createCatDTO);
    }

    @Override
    public ResponseEntity<List<CatDTO>> getAllCats() {
        return ResponseEntity.status(HttpStatus.OK).body(catService.getAll());
    }

    @Override
    public ResponseEntity<ChipDTO> updateChipContactDetails(Integer id, UpdateChipContactDetails updateChipContactDetails) {
        return CatsApi.super.updateChipContactDetails(id, updateChipContactDetails);
    }
}
