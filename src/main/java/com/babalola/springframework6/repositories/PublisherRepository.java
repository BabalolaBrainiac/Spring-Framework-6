package com.babalola.springframework6.repositories;

import com.babalola.springframework6.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
