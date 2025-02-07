package org.example.controller;

;
import org.generator.api.CatsApi;
import org.generator.model.Cat;
import org.generator.model.Chip;
import org.generator.model.CreateCatDTO;
import org.generator.model.UpdateChipContactDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;


@Controller
public class CatController implements CatsApi{


    @Override
    public ResponseEntity<Cat> addChipToCat(Integer id, Chip chip) {
        return CatsApi.super.addChipToCat(id, chip);
    }

    @Override
    public ResponseEntity<Cat> createCat(CreateCatDTO createCatDTO) {
        return CatsApi.super.createCat(createCatDTO);
    }

    @Override
    public ResponseEntity<List<Cat>> getAllCats() {
        return CatsApi.super.getAllCats();
    }

    @Override
    public ResponseEntity<Chip> updateChipContactDetails(Integer id, UpdateChipContactDetails updateChipContactDetails) {
        return CatsApi.super.updateChipContactDetails(id, updateChipContactDetails);
    }
}
