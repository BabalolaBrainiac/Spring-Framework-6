package com.babalola.springframework6.repositories;

import com.babalola.springframework6.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
