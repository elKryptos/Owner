package it.objectmethod.owner.mappers;

import it.objectmethod.owner.dtos.FonteDto;
import it.objectmethod.owner.entities.Fonte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PersonMapper.class})
public interface FonteMapper {
    @Mapping(target = "persons", source = "streamings")
    FonteDto toFonteDto(Fonte fonte);
    @Mapping(target = "streamings", source = "persons")
    Fonte toEntity(FonteDto fonteDto);
    List<FonteDto> toFonteDtoList(List<Fonte> fonteList);
    List<Fonte> toFonteList(List<FonteDto> fonteDtoList);

}
