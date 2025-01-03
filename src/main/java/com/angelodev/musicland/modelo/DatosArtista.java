package com.angelodev.musicland.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosArtista(

        @JsonAlias ("strArtist") String nombre,

        @JsonAlias("strStyle") String estilo,

        @JsonAlias("strGenre") String genero,

        @JsonAlias("strCountry") String paisOrigen,

        @JsonAlias("strBiographyES") String biografia
) {
}
