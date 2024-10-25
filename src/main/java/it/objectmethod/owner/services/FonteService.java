package it.objectmethod.owner.services;

import it.objectmethod.owner.dtos.FonteDto;
import it.objectmethod.owner.dtos.ResponseWrapper;
import it.objectmethod.owner.entities.Fonte;
import it.objectmethod.owner.mappers.FonteMapper;
import it.objectmethod.owner.repositories.FonteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
