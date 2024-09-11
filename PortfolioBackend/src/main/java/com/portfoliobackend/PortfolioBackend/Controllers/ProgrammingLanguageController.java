package com.portfoliobackend.PortfolioBackend.Controllers;

import com.portfoliobackend.PortfolioBackend.Entites.ProgrammingLanguage;
import com.portfoliobackend.PortfolioBackend.Repository.ProgrammingLanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/programming-languages")
public class ProgrammingLanguageController {

    @Autowired
    private ProgrammingLanguagesRepository programmingLanguageRepository;

    @GetMapping
    public List<ProgrammingLanguage> getAllProgrammingLanguages() {
        return programmingLanguageRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> getProgrammingLanguageById(@PathVariable("id") Integer id) {
        Optional<ProgrammingLanguage> programmingLanguage = programmingLanguageRepository.findById(id);
        return programmingLanguage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProgrammingLanguage createProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage) {
        return programmingLanguageRepository.save(programmingLanguage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> updateProgrammingLanguage(@PathVariable("id") Integer id, @RequestBody ProgrammingLanguage programmingLanguage) {
        if (!programmingLanguageRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        programmingLanguage.setId(id);
        ProgrammingLanguage updatedProgrammingLanguage = programmingLanguageRepository.save(programmingLanguage);
        return ResponseEntity.ok(updatedProgrammingLanguage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgrammingLanguage(@PathVariable("id") Integer id) {
        if (!programmingLanguageRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        programmingLanguageRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}