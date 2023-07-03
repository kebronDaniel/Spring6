package guru.spring6.web_app.Repositories;

import guru.spring6.web_app.Domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
