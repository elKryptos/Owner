package it.objectmethod.owner.services;

import it.objectmethod.owner.dtos.FonteDto;
import it.objectmethod.owner.dtos.ResponseWrapper;
import it.objectmethod.owner.entities.Fonte;
import it.objectmethod.owner.mappers.FonteMapper;
import it.objectmethod.owner.repositories.FonteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FonteService {

    private final FonteRepository fonteRepository;
    private final FonteMapper fonteMapper;

    public ResponseWrapper<List<FonteDto>> getAll(){
        List<Fonte> fontes = fonteRepository.findAll();
        List<FonteDto> fonteDtos = fonteMapper.toFonteDtoList(fontes);
        if (fonteDtos.isEmpty()) {
            return new ResponseWrapper<>("Lista vuota");
        }
        return new ResponseWrapper<>("Lista trovata", fonteDtos);
    }

    public ResponseWrapper<FonteDto> getById(Integer id){
        Optional<Fonte> fonte = fonteRepository.findById(id);
        if (fonte.isPresent()) {
            FonteDto fonteDto = fonteMapper.toFonteDto(fonte.get());
            return new ResponseWrapper<>("Lista tovata", fonteDto);
        }
        return new ResponseWrapper<>("Lista vuota");
    }

    public ResponseWrapper<FonteDto> create(FonteDto fonteDto){
        if (fonteDto.getNome() == null || fonteDto.getNome().isEmpty()) {
            return new ResponseWrapper<>("Inserire un nome");
        }
        Fonte fonte = fonteMapper.toEntity(fonteDto);
        fonteRepository.save(fonte);
        FonteDto fonteDtoDto = fonteMapper.toFonteDto(fonte);
        return new ResponseWrapper<>("Fonte Inserita", fonteDtoDto);
    }
}
