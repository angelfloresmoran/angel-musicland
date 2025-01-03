package com.angelodev.musicland.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "canciones")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tituloCancion;

    private String genero;

    @ManyToOne
    private Artista autor;

    public Cancion (){}

    public String getTituloCancion() {
        return tituloCancion;
    }

    public void setTituloCancion(String tituloCancion) {
        this.tituloCancion = tituloCancion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Artista getAutor() {
        return autor;
    }

    public void setAutor(Artista autor) {
        this.autor = autor;
    }
}
