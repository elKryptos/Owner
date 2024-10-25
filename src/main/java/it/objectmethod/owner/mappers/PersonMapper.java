package it.objectmethod.owner.mappers;

import it.objectmethod.owner.dtos.PersonDto;
import it.objectmethod.owner.dtos.StreamingDto;
import it.objectmethod.owner.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(target = "streamingDtos", source = "streamings")
    PersonDto toDto(Person person);
    Person toEntity(PersonDto personDto);
    List<PersonDto> toDtoList(List<Person> persons);
    List<Person> toEntityList(List<PersonDto> personDtos);

}
