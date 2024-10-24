package it.objectmethod.owner.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Streaming {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer streamingId;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "personId")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "fonte_id", referencedColumnName = "fonteId")
    private Fonte fonte;

}
