package com.portfoliobackend.PortfolioBackend.Repository;

import com.portfoliobackend.PortfolioBackend.Entites.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

}
