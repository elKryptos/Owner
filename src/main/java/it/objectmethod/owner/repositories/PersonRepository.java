package it.objectmethod.owner.repositories;

import it.objectmethod.owner.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>,
        JpaSpecificationExecutor<Person> {
}
