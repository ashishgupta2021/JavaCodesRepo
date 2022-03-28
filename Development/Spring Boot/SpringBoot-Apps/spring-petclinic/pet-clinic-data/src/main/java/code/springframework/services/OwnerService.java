package code.springframework.services;

import java.util.Set;

import code.springframework.model.Owner;



public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
}
