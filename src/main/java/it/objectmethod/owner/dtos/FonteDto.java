package it.objectmethod.owner.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FonteDto {
    @NotBlank(message = "")
    private String nome;
    private List<PersonDto> persons;
}