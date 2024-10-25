package it.objectmethod.owner.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FonteDto {
    private String nome;
    private List<PersonDto> personDtos = new ArrayList<>();
}