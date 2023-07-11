package com.example.proyectoCM;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@Controller
public class ProyectoCmApplication {

	@Autowired
	UsuarioRepositorio repository;


	//@PostMapping("/usuariosPost")
	//public ResponseEntity<Usuario> createUser
	//		(@RequestBody Usuario user) {

		//Usuario newuser = new Usuario(user.getId(), user.getUsuario(),user.getApellido(),user.getEdad(), user.getNombre(),user.getCorreo(), user.getContrasenna());
		//repository.save(newuser);
		//return new ResponseEntity<>(newuser, HttpStatus.CREATED);

	//}
	@GetMapping("/Registro")
	public String registro(){
		return "registro2";
	};
	@GetMapping("/IniciarSesion")
	public String iniciarSesion(){
		return "index";
	};
	@GetMapping("/usuariosLista")
	public String lista(){
		return "listaUsuarios";
	};
	@GetMapping("/home")
	public String home(){
		return "Perfil";
	};


	public static void main(String[] args) {
		SpringApplication.run(ProyectoCmApplication.class, args);
	}

}
