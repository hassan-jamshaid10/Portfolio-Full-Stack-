package com.portfoliobackend.PortfolioBackend.Services;
import com.portfoliobackend.PortfolioBackend.Entites.ProgrammingLanguage;
import com.portfoliobackend.PortfolioBackend.Repository.ProgrammingLanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammingLanguageService {

    @Autowired
    private ProgrammingLanguagesRepository programmingLanguageRepository;

    public List<ProgrammingLanguage> getAllProgrammingLanguages() {
        return programmingLanguageRepository.findAll();
    }

    public Optional<ProgrammingLanguage> getProgrammingLanguageById(Integer id) {
        return programmingLanguageRepository.findById(id);
    }

    public ProgrammingLanguage createProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        return programmingLanguageRepository.save(programmingLanguage);
    }

    public ProgrammingLanguage updateProgrammingLanguage(Integer id, ProgrammingLanguage programmingLanguageDetails) {
        if (!programmingLanguageRepository.existsById(id)) {
            return null;
        }
        programmingLanguageDetails.setId(id);
        return programmingLanguageRepository.save(programmingLanguageDetails);
    }

    public boolean deleteProgrammingLanguage(Integer id) {
        if (!programmingLanguageRepository.existsById(id)) {
            return false;
        }
        programmingLanguageRepository.deleteById(id);
        return true;
    }
}
