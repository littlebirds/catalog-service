package com.polarbookshop.catalog_service.domain;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;;

public interface BookRepository 
    extends CrudRepository<Book, Long> {
        
    Optional<Book> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    
    @Modifying
    @Query("delete from Book where isbn = :isbn")
    void deleteByIsbn(String isbn);
}
