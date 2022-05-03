package com.georghiton.bootstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.georghiton.bootstore.domain.Categoria;
import com.georghiton.bootstore.domain.Livro;
import com.georghiton.bootstore.repositories.CategoriaRepository;
import com.georghiton.bootstore.repositories.LivroRepository;

@SpringBootApplication
public class BootstoreApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BootstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
	
		Livro liv1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(liv1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(liv1));
	}

}
