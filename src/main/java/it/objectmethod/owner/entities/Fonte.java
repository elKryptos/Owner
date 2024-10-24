package it.objectmethod.owner.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Fonte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fonteId;
    private String nome;

    @OneToMany(mappedBy = "fonte", fetch = FetchType.LAZY)
    private List<Streaming> streamings = new ArrayList<>();

}
