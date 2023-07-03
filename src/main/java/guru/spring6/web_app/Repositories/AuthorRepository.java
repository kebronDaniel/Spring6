package guru.spring6.web_app.Repositories;

import guru.spring6.web_app.Domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
