package com.portfoliobackend.PortfolioBackend.Repository;

import com.portfoliobackend.PortfolioBackend.Entites.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammingLanguagesRepository extends JpaRepository<ProgrammingLanguage, Integer> {

}
