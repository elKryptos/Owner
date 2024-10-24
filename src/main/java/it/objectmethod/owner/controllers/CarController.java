package it.objectmethod.owner.controllers;

import it.objectmethod.owner.dtos.CarDto;
import it.objectmethod.owner.dtos.ResponseWrapper;
import it.objectmethod.owner.services.CarService;
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
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @GetMapping("/all")
    public ResponseEntity<ResponseWrapper<List<CarDto>>> findAll() {
        ResponseWrapper<List<CarDto>> response = carService.findAll();
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
