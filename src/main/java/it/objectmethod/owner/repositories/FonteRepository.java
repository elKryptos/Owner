package it.objectmethod.owner.repositories;

import it.objectmethod.owner.entities.Fonte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FonteRepository extends JpaRepository<Fonte, Integer> {

//@Query(value = "select p.name, p.surname, p.age, f.nome\n" +
//        "from person as p\n" +
//        "inner join fonte as f\n" +
//        "on person_id = :id", nativeQuery = true)
//    List<Fonte> findFonteByFonteId(int id);

}
