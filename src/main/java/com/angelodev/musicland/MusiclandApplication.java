package com.angelodev.musicland;

import com.angelodev.musicland.principal.Principal;
import com.angelodev.musicland.repository.repositorioArtista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusiclandApplication implements CommandLineRunner {

	@Autowired
	private repositorioArtista repositorio;

	public static void main(String[] args) {
		SpringApplication.run(MusiclandApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal iniciarPrograma = new Principal(repositorio);
		iniciarPrograma.muestraMenu();
	}
}
