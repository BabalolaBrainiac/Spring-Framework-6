package com.babalola.springframework6.repositories;

import com.babalola.springframework6.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
