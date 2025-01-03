package com.angelodev.musicland.repository;

import com.angelodev.musicland.modelo.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface repositorioArtista extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNombreContainingIgnoreCase(String nombre);
}
