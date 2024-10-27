package it.objectmethod.owner.controllers;

import it.objectmethod.owner.dtos.FonteDto;
import it.objectmethod.owner.dtos.ResponseWrapper;
import it.objectmethod.owner.services.FonteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<FonteDto>> getById(@PathVariable int id) {
        ResponseWrapper<FonteDto> response = fonteService.getById(id);
        if(response == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/create")
    public ResponseEntity<ResponseWrapper<FonteDto>> create(@RequestBody FonteDto fonteDto) {
        ResponseWrapper<FonteDto> response = fonteService.create(fonteDto);
        if(response == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
