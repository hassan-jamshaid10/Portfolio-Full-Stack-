package com.portfoliobackend.PortfolioBackend.Controllers;
import com.portfoliobackend.PortfolioBackend.Entites.Experience;
import com.portfoliobackend.PortfolioBackend.Repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

    @Autowired
    private ExperienceRepository experienceRepository;

    @GetMapping
    public List<Experience> getAllExperience() {
        return experienceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable Integer id) {
        Optional<Experience> experience = experienceRepository.findById(id);
        return experience.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceRepository.save(experience);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Integer id, @RequestBody Experience experienceDetails) {
        if (!experienceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        experienceDetails.setId(id);
        Experience updatedExperience = experienceRepository.save(experienceDetails);
        return ResponseEntity.ok(updatedExperience);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Integer id) {
        if (!experienceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        experienceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
