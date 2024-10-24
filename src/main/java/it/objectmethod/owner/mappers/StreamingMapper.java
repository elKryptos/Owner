package it.objectmethod.owner.mappers;

import it.objectmethod.owner.dtos.StreamingDto;
import it.objectmethod.owner.entities.Streaming;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StreamingMapper {
    StreamingDto toDto (Streaming streaming);
    Streaming toEntity (StreamingDto streamingDto);
    List<StreamingDto> toDtoList (List<Streaming> streamings);
    List<Streaming> toEntityList (List<StreamingDto> streamingDtos);
}
