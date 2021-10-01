package com.example.library_management.service;

import com.example.library_management.dao.Member;
import com.example.library_management.dao.Publisher;
import com.example.library_management.repo.PublisherRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    @PersistenceContext
    EntityManager entityManager;

    public PublisherService(PublisherRepository publisherRepository, EntityManager entityManager) {
        this.publisherRepository = publisherRepository;
        this.entityManager = entityManager;
    }

    public Publisher create(Publisher publisher){return publisherRepository.save(publisher);}

    public Optional<Publisher> findPublisher(Integer id){return publisherRepository.findById(id);}

    public List<Publisher> getAllPublishers(){return publisherRepository.findAll();}

    public void deletePublisher(int id){
        publisherRepository.deleteById(id);
    }
}
