package com.portfoliobackend.PortfolioBackend.Controllers;

import com.portfoliobackend.PortfolioBackend.Entites.Education;
import com.portfoliobackend.PortfolioBackend.Repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private EducationRepository educationRepository;

    @GetMapping
    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable("id") Integer id) {
        Optional<Education> education = educationRepository.findById(id);
        return education.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Education createEducation(@RequestBody Education education) {
        return educationRepository.save(education);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable("id") Integer id, @RequestBody Education education) {
        if (!educationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        education.setId(id);
        Education updatedEducation = educationRepository.save(education);
        return ResponseEntity.ok(updatedEducation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable("id") Integer id) {
        if (!educationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        educationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}