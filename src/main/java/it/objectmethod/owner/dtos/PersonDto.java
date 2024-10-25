package it.objectmethod.owner.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PersonDto {
    private String name;
    private String surname;
    private Integer age;
    private List<StreamingDto> streamingDtos;
}
