package it.objectmethod.owner.mappers;

import it.objectmethod.owner.dtos.FonteDto;
import it.objectmethod.owner.entities.Fonte;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FonteMapper {
    FonteDto toFonteDto(Fonte fonte);
    Fonte toEntity(FonteDto fonteDto);
    List<FonteDto> toFonteDtoList(List<Fonte> fonteList);
    List<Fonte> toFonteList(List<FonteDto> fonteDtoList);
}
