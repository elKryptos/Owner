package it.objectmethod.owner.services;

import it.objectmethod.owner.dtos.CarDto;
import it.objectmethod.owner.dtos.ResponseWrapper;
import it.objectmethod.owner.entities.Car;
import it.objectmethod.owner.mappers.CarMapper;
import it.objectmethod.owner.repositories.CarRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public ResponseWrapper<List<CarDto>> findAll() {
       List<Car> cars = carRepository.findAll();
       List<CarDto> carDtos = carMapper.toDtoList(cars);
       if (carDtos.isEmpty()) return new ResponseWrapper<>("Lista non trovata");
       return new ResponseWrapper<>("Lista trovata", carDtos);
    }

}
