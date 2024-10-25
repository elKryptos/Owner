package it.objectmethod.owner.mappers;

import it.objectmethod.owner.dtos.FonteDto;
import it.objectmethod.owner.dtos.PersonDto;
import it.objectmethod.owner.entities.Fonte;
import it.objectmethod.owner.entities.Streaming;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {PersonMapper.class})
public interface FonteMapper {
    @Mapping(target = "personDtos", source = "streamings")
    FonteDto toFonteDto(Fonte fonte);
    Fonte toEntity(FonteDto fonteDto);
    List<FonteDto> toFonteDtoList(List<Fonte> fonteList);
    List<Fonte> toFonteList(List<FonteDto> fonteDtoList);

}
