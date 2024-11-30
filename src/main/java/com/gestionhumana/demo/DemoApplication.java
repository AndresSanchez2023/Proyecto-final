package com.gestionhumana.demo;

import com.gestionhumana.demo.modelo.Usuario;
import com.gestionhumana.demo.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
