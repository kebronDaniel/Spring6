package guru.spring6.web_app.Repositories;

import guru.spring6.web_app.Domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
