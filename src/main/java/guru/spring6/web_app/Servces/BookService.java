package guru.spring6.web_app.Servces;

import guru.spring6.web_app.Domain.Book;
import guru.spring6.web_app.Repositories.BookRepository;
import org.springframework.stereotype.Service;

public interface BookService {

    Book findOneById(Long id);
}
