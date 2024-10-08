package com.portfoliobackend.PortfolioBackend.Repository;

import com.portfoliobackend.PortfolioBackend.Entites.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
