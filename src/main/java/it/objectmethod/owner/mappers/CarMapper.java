package it.objectmethod.owner.mappers;

import it.objectmethod.owner.dtos.CarDto;
import it.objectmethod.owner.entities.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto ToDto(Car car);
    Car toEntity(CarDto carDto);
    List<CarDto> toDtoList(List<Car> carList);
    List<Car> toEntityList(List<CarDto> carDtoList);
}
