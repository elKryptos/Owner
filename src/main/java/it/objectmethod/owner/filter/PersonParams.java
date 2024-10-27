package it.objectmethod.owner.filter;

import it.objectmethod.owner.entities.Person;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonParams {
    private List<Integer> ids;
    @Nullable
    private String name;
    @Nullable
    private  String surname;

//  Versione old più comune di trovare
    public Specification<Person> getSpecification() {
        return Specification.<Person>where(null)
                .and(equalsNomeSpecification(name))
                .and(equalsSurnameSpecification(surname))
                .and(equalsIdSpecification(ids));
    }

    private Specification<Person> equalsIdSpecification(List<Integer> ids) {
        if (ids == null) return null;
        //return (root, query, criteriaBuilder) -> root.get("id").in(ids);
        return (root, query, criteriaBuilder) -> criteriaBuilder.in(root.get("id")).value(ids);
    }

//    Versione moderna
//    public Specification<Person> getSpecification() {
//        return Specification.allOf(
//                equalsNomeSpecification(name),
//                equalsSurnameSpecification(surname));
//    }

    private Specification<Person> equalsSurnameSpecification(String surname) {
        if (surname == null) return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("surname"), surname);
    }

    private Specification<Person> equalsNomeSpecification(String nome) {
        if (nome == null) return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), nome);
    }

}
