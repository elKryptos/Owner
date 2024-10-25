package it.objectmethod.owner.services;

import it.objectmethod.owner.dtos.PersonDto;
import it.objectmethod.owner.dtos.ResponseWrapper;
import it.objectmethod.owner.entities.Person;
import it.objectmethod.owner.filter.PersonParams;
import it.objectmethod.owner.mappers.PersonMapper;
import it.objectmethod.owner.repositories.PersonRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public ResponseWrapper<List<PersonDto>> findAll() {
        List<Person> persons = personRepository.findAll();
        List<PersonDto> personDtos = personMapper.toDtoList(persons);
        if (personDtos.isEmpty()) {
            return new ResponseWrapper<>("Lista vuota");
        }
        return new ResponseWrapper<>("Lista trovata", personDtos);
    }

    public ResponseWrapper<PersonDto> findById(int id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            PersonDto personDto = personMapper.toDto(person);
            return new ResponseWrapper<>("Persona trovata", personDto);
        }
        return new ResponseWrapper<>("Persona non trovata");
    }

    public ResponseWrapper<List<PersonDto>> findAll(PersonParams personParams) {
        List<PersonDto> personDto = personMapper.toDtoList(personRepository.findAll(personParams.getSpecification()));
        if (personDto.isEmpty()) {
            return new ResponseWrapper<>("Valore non trovato");
        }
        return new ResponseWrapper<>("Valore trovato", personDto);
    }

}
