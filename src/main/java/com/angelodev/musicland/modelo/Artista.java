package com.angelodev.musicland.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "nombre_artista")
    private String nombre;

    private String genero;

    private String paisDeOrigen;

    private String biografia;

    @OneToMany(mappedBy = "autor", cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cancion> listaCanciones = new ArrayList<>();

    public Artista(){}

    public void asignacionDeValores(String nombre, String genero, String paisDeOrigen, String biografia){
        this.nombre=nombre;
        this.genero=genero;
        this.paisDeOrigen=paisDeOrigen;
        this.biografia=biografia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPaisDeOrigen() {
        return paisDeOrigen;
    }

    public void setPaisDeOrigen(String paisDeOrigen) {
        this.paisDeOrigen = paisDeOrigen;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public List<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }
}
