package com.babalola.springframework6.bootstrap;


import com.babalola.springframework6.domain.Author;
import com.babalola.springframework6.domain.Book;
import com.babalola.springframework6.domain.Publisher;
import com.babalola.springframework6.repositories.AuthorRepository;
import com.babalola.springframework6.repositories.BookRepository;
import com.babalola.springframework6.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("Babalola");
        author.setLastName("Opeyemi");

        Book book = new Book();
        book.setTitle("Spring Framework 6");
        book.setIsbn("987654");

        Author author2= new Author();
        author2.setFirstName("Ajoke");
        author2.setLastName("Ibrahim");

        Book book2 = new Book();
        book2.setTitle("Learning Java");
        book2.setIsbn("987654");

        Author authorSaved  = authorRepository.save(author);
        Author author2Saved = authorRepository.save(author2);


        Book bookSaved = bookRepository.save(book);
        Book book2Saved  = bookRepository.save(book2);

        authorSaved.getBooks().add(bookSaved);
        author2Saved.getBooks().add(book2Saved);
        bookSaved.getAuthors().add(author);
        book2Saved.getAuthors().add(author2);

        authorRepository.save(authorSaved);
        authorRepository.save(authorSaved);

        Publisher publisher = new Publisher();
        publisher.setAddress("Lagos");
        publisher.setCity("Lekki");
        publisher.setState("Lagos State, Nigeria");
        publisher.setPublisherName("Macmillan");
        publisher.setZip("12345");

        Publisher savedPublisher  = publisherRepository.save(publisher);

        bookSaved.setPublisher(savedPublisher);
        book2Saved.setPublisher(savedPublisher);

        bookRepository.save(bookSaved);
        bookRepository.save(book2Saved);


        System.out.println("Publisher Count" +  publisherRepository.count());
        System.out.println("Author Count " + authorRepository.count());
        System.out.println( "Book Count" +  bookRepository.count());


    }
}
