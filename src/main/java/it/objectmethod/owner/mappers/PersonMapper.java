package it.objectmethod.owner.mappers;

import it.objectmethod.owner.dtos.PersonDto;
import it.objectmethod.owner.entities.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto toDto(Person person);
    Person toEntity(PersonDto personDto);
    List<PersonDto> toDtoList(List<Person> persons);
    List<Person> toEntityList(List<PersonDto> personDtos);

}
