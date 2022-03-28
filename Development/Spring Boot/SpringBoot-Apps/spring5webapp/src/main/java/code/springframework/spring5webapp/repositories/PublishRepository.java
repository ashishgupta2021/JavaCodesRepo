package code.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import code.springframework.spring5webapp.model.Publisher;

public interface PublishRepository extends CrudRepository<Publisher, Long> {

}
