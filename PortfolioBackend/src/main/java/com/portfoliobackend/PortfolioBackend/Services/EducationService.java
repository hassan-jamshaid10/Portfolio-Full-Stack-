package com.portfoliobackend.PortfolioBackend.Services;
import com.portfoliobackend.PortfolioBackend.Entites.Education;
import com.portfoliobackend.PortfolioBackend.Repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    public Optional<Education> getEducationById(Integer id) {
        return educationRepository.findById(id);
    }

    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    public Education updateEducation(Integer id, Education educationDetails) {
        if (!educationRepository.existsById(id)) {
            return null;
        }
        educationDetails.setId(id);
        return educationRepository.save(educationDetails);
    }

    public boolean deleteEducation(Integer id) {
        if (!educationRepository.existsById(id)) {
            return false;
        }
        educationRepository.deleteById(id);
        return true;
    }
}
