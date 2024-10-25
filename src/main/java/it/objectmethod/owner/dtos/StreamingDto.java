package it.objectmethod.owner.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StreamingDto {
    private String streamingId;
    private PersonDto personDto;
    private FonteDto fonteDto;
}
