package it.objectmethod.owner.dtos;

import it.objectmethod.owner.entities.Streaming;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FonteDto {
    private String nome;
    private List<Streaming> streamings = new ArrayList<>();

}
