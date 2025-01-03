package com.angelodev.musicland.principal;

import com.angelodev.musicland.modelo.Artista;
import com.angelodev.musicland.modelo.Cancion;
import com.angelodev.musicland.repository.repositorioArtista;
import com.angelodev.musicland.service.ConsumoAPI;

import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private repositorioArtista repositorio;

    private ConsumoAPI consumoAPI = new ConsumoAPI();

    private Scanner teclado = new Scanner(System.in);

    public Principal(repositorioArtista repositorio) {
        this.repositorio = repositorio;
    }

    public void muestraMenu(){
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                                    Selecciona una opción del menú:
                    ***** REGISTROS *****
                    1 - Registrar Artista
                    2 - Registrar Cancion
                    
                    ***** CONSULTAS *****
                    3 - Buscar Artista
                    4 - Buscar canción
                    
                    ***** Opciones del sistema *****             
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    registrarArtistaEnDB();
                    break;
                case 2:
                    registrarCancion();
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private void getDatosArtista() {
        System.out.println("Ingrese autor");


    }

    private void registrarArtistaEnDB(){
        System.out.println("Ingresa el nombre del artista buscado");
        var nombreArtista = teclado.nextLine();
        System.out.println("Ingresa el género");
        var genero = teclado.nextLine();
        System.out.println("Ingresa el país origan");
        var paisOrigen = teclado.nextLine();
        System.out.println("Ingrese la biografía");
        var biografia = teclado.nextLine();
        Artista nuevoArtista = new Artista();
        nuevoArtista.asignacionDeValores(nombreArtista, genero, paisOrigen, biografia);
        repositorio.save(nuevoArtista);
        System.out.println("Artista : " + nombreArtista + " ha sido guardado Correctamente!");

    }

    private void registrarCancion(){
        System.out.println("Ingrese el autor:");
        var nombreAutor = teclado.nextLine();
        Optional<Artista> autor = repositorio.findByNombreContainingIgnoreCase(nombreAutor);
        if (autor.isPresent()) {
            System.out.println("Ingresa el título de la canción: ");
            var nombreCancion = teclado.nextLine();
            System.out.println("Ingresa el genero");
            var genero = teclado.nextLine();
            Cancion cancion = new Cancion();

            cancion.setTituloCancion(nombreCancion);
            cancion.setGenero(genero);
            cancion.setAutor(autor.get());

            autor.get().getListaCanciones().add(cancion);
            repositorio.save(autor.get());
        } else {
            System.out.println("Artista no encontrado");
        }
    }

}
