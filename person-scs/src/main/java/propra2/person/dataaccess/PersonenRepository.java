package propra2.person.dataaccess;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import propra2.person.model.Person;

import java.util.List;

public interface PersonenRepository extends CrudRepository<Person, Long> {

    List<Person> findAll();


}
