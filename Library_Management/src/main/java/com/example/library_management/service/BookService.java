package com.example.library_management.service;


import com.example.library_management.dao.Book;
import com.example.library_management.dao.Publisher;
import com.example.library_management.dto.Bookdto;
import com.example.library_management.repo.BookRepository;
import com.example.library_management.repo.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    public Book create(Bookdto bookdto) {
        Book book = new Book();
//        String publish= "" ;

        book.setBookName(bookdto.getBook_Name());
        book.setAuthor_Name(bookdto.getAuthor_Name());

        Optional<Publisher> publisher = publisherRepository.findById(bookdto.getPublishers());
       if(publisher.isPresent())
           book.setPublish(publisher.get());
        return bookRepository.save(book);
    }

    public Optional<Book> findBook(Integer id){return bookRepository.findById(id);}

    public List<Book> getAllBooks(){return bookRepository.findAll();}

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

}