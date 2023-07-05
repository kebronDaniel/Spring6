package guru.spring6.web_app.Bootstrap;

import guru.spring6.web_app.Domain.Author;
import guru.spring6.web_app.Domain.Book;
import guru.spring6.web_app.Domain.Publisher;
import guru.spring6.web_app.Repositories.AuthorRepository;
import guru.spring6.web_app.Repositories.BookRepository;
import guru.spring6.web_app.Repositories.PublisherRepository;
import guru.spring6.web_app.Servces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {


        Book book = new Book();
        book.setIsbn("isbn1234");
        book.setTitle("SummerSet");

        Book book1 = new Book();
        book1.setTitle("The red and the Black");
        book1.setIsbn("isbn0987");

        Book savedBook = bookRepository.save(book);
        Book savedBook1 = bookRepository.save(book1);


        Author author = new Author();
        author.setFirstName("Leo");
        author.setLastName("Tolstoy");
        Author savedAuthor = authorRepository.save(author);

        Author author1 = new Author();
        author.setFirstName("Haruki");
        author.setLastName("Murakami");
        Author savedAuthor1 = authorRepository.save(author1);


        Set<Book> books = new HashSet<>();
        books.add(book);
        books.add(book1);

        savedAuthor.setBooks(books);


        Publisher publisher = new Publisher();
        publisher.setAddress("New york");
        publisher.setPublisherName("Winston");
        publisher.setBooks(books);
        Publisher savedPublisher = publisherRepository.save(publisher);

        savedAuthor.setBooks(books);
        savedAuthor1.setBooks(books);
        authorRepository.save(savedAuthor);
        authorRepository.save(savedAuthor1);

        Set<Author> authors = new HashSet<>();
        authors.add(author);
        authors.add(author1);

        savedBook.setAuthors(authors);
        savedBook.setPublisher(publisher);
        savedBook1.setAuthors(authors);
        savedBook1.setPublisher(publisher);
        bookRepository.save(savedBook);
        bookRepository.save(savedBook1);


        System.out.println("Publishers count " + publisherRepository.count());
        System.out.println("Authors count " + authorRepository.count());
        System.out.println("Books count " + bookRepository.count());

    }
}
