package guru.spring6.web_app.Servces;

import guru.spring6.web_app.Domain.Book;
import guru.spring6.web_app.Repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book findOneById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.get();
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
