package com.example.assalam.Bootstrap;

import com.example.assalam.Domain.Author;
import com.example.assalam.Domain.Book;
import com.example.assalam.Domain.Publisher;
import com.example.assalam.Repositories.AuthorRepository;
import com.example.assalam.Repositories.BookRepository;
import com.example.assalam.Repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

   private final AuthorRepository authorRepository;
   private final BookRepository bookRepository;
   private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Publisher publisher=new Publisher();
        publisher.setName("SFG publishers");
        publisher.setCity("afghan");
        publisher.setState("Arkansas");
        publisherRepository.save(publisher);

        Author eric =new Author("Eric","Evans");
        Book ddd= new Book("ejb","10");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);
        Author mohamed=new Author("hassan","ali");
        Book devOPS=new Book("Se","11");
        devOPS.setPublisher(publisher);
        publisher.getBooks().add(devOPS);

        mohamed.getBooks().add(devOPS);
        devOPS.getAuthors().add(mohamed);
        authorRepository.save(mohamed);
        bookRepository.save(devOPS);
        publisherRepository.save(publisher);


        System.out.println("started in bootstrap");
        System.out.println("number of books"+bookRepository.count());
        System.out.println("publisher no of books"+publisher.getBooks().size());


    }
}
