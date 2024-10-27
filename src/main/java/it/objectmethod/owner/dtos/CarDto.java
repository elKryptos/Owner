package it.objectmethod.owner.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CarDto {
    private String targa;
    private String color;
    private String model;
}
