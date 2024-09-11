package com.portfoliobackend.PortfolioBackend.Services;
import com.portfoliobackend.PortfolioBackend.Entites.Contact;
import com.portfoliobackend.PortfolioBackend.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Integer id) {
        return contactRepository.findById(id);
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Integer id, Contact contactDetails) {
        if (!contactRepository.existsById(id)) {
            return null;
        }
        contactDetails.setId(id);
        return contactRepository.save(contactDetails);
    }

    public boolean deleteContact(Integer id) {
        if (!contactRepository.existsById(id)) {
            return false;
        }
        contactRepository.deleteById(id);
        return true;
    }
}
