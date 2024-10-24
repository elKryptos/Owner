package it.objectmethod.owner.controllers;

import it.objectmethod.owner.dtos.FonteDto;
import it.objectmethod.owner.dtos.ResponseWrapper;
import it.objectmethod.owner.repositories.FonteRepository;
import it.objectmethod.owner.services.FonteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/fonte")
@RequiredArgsConstructor
public class FonteController {

    private final FonteService fonteService;

    @GetMapping("/all")
    public ResponseEntity<ResponseWrapper<List<FonteDto>>> getAll() {
        ResponseWrapper<List<FonteDto>> response = fonteService.getAll();
        if(response == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
