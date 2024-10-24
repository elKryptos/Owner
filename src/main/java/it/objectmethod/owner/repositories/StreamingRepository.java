package it.objectmethod.owner.repositories;

import it.objectmethod.owner.entities.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Integer> {
}
