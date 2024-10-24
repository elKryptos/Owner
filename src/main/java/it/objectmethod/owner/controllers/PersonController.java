package it.objectmethod.owner.controllers;

import it.objectmethod.owner.dtos.PersonDto;
import it.objectmethod.owner.dtos.ResponseWrapper;
import it.objectmethod.owner.entities.Person;
import it.objectmethod.owner.exception.handler.ResponseUtil;
import it.objectmethod.owner.filter.PersonParams;
import it.objectmethod.owner.services.PersonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/person")
@CrossOrigin
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<ResponseWrapper<List<PersonDto>>> getAll() {
        ResponseWrapper<List<PersonDto>> response = personService.findAll();
        if (response != null) return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/test")
    public ResponseEntity<ResponseWrapper<List<PersonDto>>> getByVariable(@Valid PersonParams personParams) {
        ResponseWrapper<List<PersonDto>> response = personService.findAll(personParams);
        if (response != null) return ResponseEntity.status(HttpStatus.OK).body(response);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<PersonDto>> getById(@PathVariable("id") int id, final HttpServletRequest request) {
        //ResponseWrapper<PersonDto> response = personService.findById(id);
        //if (response != null) return ResponseEntity.status(HttpStatus.OK).body(response);
        return ResponseUtil
                .execute(() ->
                new ResponseEntity<>(personService.findById(id), HttpStatus.OK), request);
    }

}
