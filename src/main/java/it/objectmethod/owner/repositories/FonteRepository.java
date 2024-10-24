package it.objectmethod.owner.repositories;

import it.objectmethod.owner.entities.Fonte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonteRepository extends JpaRepository<Fonte, Integer> {

}
