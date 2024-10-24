package it.objectmethod.owner.filter;

import it.objectmethod.owner.entities.Person;
import it.objectmethod.owner.entities.Person_;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

@Data
@AllArgsConstructor
public class PersonParams {
    @Nullable
    private String name;
    @Nullable
    private  String surname;

//  Versione old più comune di trovare
    public Specification<Person> getSpecification() {
        return Specification.<Person>where(null)
                .and(equalsNomeSpecification(name))
                .and(equalsSurnameSpecification(surname));
    }

//    Versione moderna
//    public Specification<Person> getSpecification() {
//        return Specification.allOf(
//                equalsNomeSpecification(name),
//                equalsSurnameSpecification(surname));
//    }

    private Specification<Person> equalsSurnameSpecification(String surname) {
        if (surname == null) return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Person_.SURNAME), surname);
    }

    private Specification<Person> equalsNomeSpecification(String nome) {
        if (nome == null) return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), nome);
    }
}
