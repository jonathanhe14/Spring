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
		return "Registro";
	};

	@GetMapping("/")
	public String inicio(){
		return "index";
	};

	@GetMapping("/index")
	public String index(){
		return "index";
	};


	@PostMapping("/Registro")
	public String registroUsuario(@ModelAttribute("correo") String correo,@ModelAttribute("contrasenna") String contrasenna,
								  @ModelAttribute("usuario") String usuario,@ModelAttribute("nombre") String nombre,
								  @ModelAttribute("apellido") String apellido,@ModelAttribute("edad") int edad){

		Usuario usuario1 = new Usuario(correo,contrasenna,usuario,nombre,apellido,edad);
		System.out.println(usuario1.toString());
		repository.save(usuario1);
		return "Bienvenida";
	}

	@GetMapping("/usuariosGet")
	public ResponseEntity<List<Usuario>> getAllUsers() {

		List<Usuario> users = new ArrayList<Usuario>();
		repository.findAll().forEach(users::add);
		return new ResponseEntity<>(users, HttpStatus.OK);

	}


	@RequestMapping("/lista")
	@ResponseBody
	public String abrirLista(){
		return "listaUsuarios";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCmApplication.class, args);
	}

}
