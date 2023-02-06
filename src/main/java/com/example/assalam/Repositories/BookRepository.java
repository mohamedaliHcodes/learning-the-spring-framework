package com.example.assalam.Repositories;

import com.example.assalam.Domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
