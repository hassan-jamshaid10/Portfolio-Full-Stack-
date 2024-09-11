package com.portfoliobackend.PortfolioBackend.Services;
import com.portfoliobackend.PortfolioBackend.Entites.Projects;
import com.portfoliobackend.PortfolioBackend.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Projects> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Projects> getProjectById(Integer id) {
        return projectRepository.findById(id);
    }

    public Projects createProject(Projects project) {
        return projectRepository.save(project);
    }

    public Projects updateProject(Integer id, Projects projectDetails) {
        if (!projectRepository.existsById(id)) {
            return null;
        }
        projectDetails.setId(id);
        return projectRepository.save(projectDetails);
    }

    public boolean deleteProject(Integer id) {
        if (!projectRepository.existsById(id)) {
            return false;
        }
        projectRepository.deleteById(id);
        return true;
    }
}
