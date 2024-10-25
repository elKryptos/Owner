package it.objectmethod.owner.services;

import it.objectmethod.owner.dtos.ResponseWrapper;
import it.objectmethod.owner.dtos.StreamingDto;
import it.objectmethod.owner.entities.Streaming;
import it.objectmethod.owner.mappers.StreamingMapper;
import it.objectmethod.owner.repositories.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository streamingRepository;
    private final StreamingMapper streamingMapper;

    public ResponseWrapper<List<StreamingDto>> getAll() {
        List<Streaming> list = streamingRepository.findAll();
        List<StreamingDto> listDto = streamingMapper.toDtoList(list);
        if (listDto.isEmpty()) {
            return new ResponseWrapper<>("Empty list");
        }
        return new ResponseWrapper<>("List found", listDto);
    }
}
