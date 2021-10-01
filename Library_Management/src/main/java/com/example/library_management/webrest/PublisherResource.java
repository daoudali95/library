package com.example.library_management.webrest;

import com.example.library_management.dao.Member;
import com.example.library_management.dao.Publisher;
import com.example.library_management.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class PublisherResource {
    private final PublisherService publisherService;

    public PublisherResource(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("publisher")
    public ResponseEntity<Publisher> creatPublisher(@RequestBody Publisher publisher){
        Publisher publisherRes = publisherService.create(publisher);
        return ResponseEntity.ok().body(publisherRes);
    }

    @GetMapping("Allpublishers")
    public ResponseEntity<List<Publisher>>AllPublishers(){
        List<Publisher> publishers = publisherService.getAllPublishers();
        return ResponseEntity.ok().body(publishers);
    }

    @GetMapping("/publisher/{id}")
    public Optional<Publisher> retrievePublisher(@PathVariable int id){
        return publisherService.findPublisher(id);
    }

    @DeleteMapping("/delPublisher/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable int id){
        publisherService.deletePublisher(id);
        return ResponseEntity.ok().body("Record deleted id : "+ id);
    }

}