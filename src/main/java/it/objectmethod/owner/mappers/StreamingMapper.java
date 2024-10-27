package it.objectmethod.owner.mappers;

import it.objectmethod.owner.dtos.StreamingDto;
import it.objectmethod.owner.entities.Streaming;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PersonMapper.class, FonteMapper.class})
public interface StreamingMapper {
    @Mapping(target = "personDto", source = "person")
    @Mapping(target = "fonteDto", source = "fonte")
    StreamingDto toDto (Streaming streaming);
    Streaming toEntity (StreamingDto streamingDto);
    @Mapping(target = "personDto", source = "person.streamings")
    @Mapping(target = "fonteDto", source = "fonte.streamings")
    List<StreamingDto> toDtoList (List<Streaming> streamings);
    List<Streaming> toEntityList (List<StreamingDto> streamingDtos);
}
