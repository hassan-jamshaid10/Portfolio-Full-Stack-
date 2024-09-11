package com.portfoliobackend.PortfolioBackend.Services;
import com.portfoliobackend.PortfolioBackend.Entites.Experience;
import com.portfoliobackend.PortfolioBackend.Repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    public List<Experience> getAllExperience() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> getExperienceById(Integer id) {
        return experienceRepository.findById(id);
    }

    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Experience updateExperience(Integer id, Experience experienceDetails) {
        if (!experienceRepository.existsById(id)) {
            return null;
        }
        experienceDetails.setId(id);
        return experienceRepository.save(experienceDetails);
    }

    public boolean deleteExperience(Integer id) {
        if (!experienceRepository.existsById(id)) {
            return false;
        }
        experienceRepository.deleteById(id);
        return true;
    }
}
