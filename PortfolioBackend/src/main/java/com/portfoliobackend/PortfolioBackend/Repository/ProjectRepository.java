package com.portfoliobackend.PortfolioBackend.Repository;

import com.portfoliobackend.PortfolioBackend.Entites.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Integer> {
}
