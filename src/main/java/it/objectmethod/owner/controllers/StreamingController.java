package it.objectmethod.owner.controllers;

import it.objectmethod.owner.dtos.ResponseWrapper;
import it.objectmethod.owner.dtos.StreamingDto;
import it.objectmethod.owner.services.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingService;

    @GetMapping("/all")
    public ResponseEntity<ResponseWrapper<List<StreamingDto>>> getAll() {
        ResponseWrapper<List<StreamingDto>> response = streamingService.getAll();
        if (response == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
