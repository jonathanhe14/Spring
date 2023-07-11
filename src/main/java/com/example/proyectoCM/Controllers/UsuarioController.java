package com.example.proyectoCM.Controllers;

import com.example.proyectoCM.Usuario;
import com.example.proyectoCM.dao.UsuarioDao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

 /*   @PostMapping("/Registro")
    public String registroUsuario(@ModelAttribute("correo") String correo, @ModelAttribute("contrasenna") String contrasenna,
                                  @ModelAttribute("usuario") String usuario, @ModelAttribute("nombre") String nombre,
                                  @ModelAttribute("apellido") String apellido, @ModelAttribute("edad") int edad){

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

    }/*

  */

    @RequestMapping(value="usuarios")
    public List<Usuario> getUsuarios(){
    return usuarioDao.getUsuarios();
    };


    @RequestMapping(value="/usuario/{nombreUsuario}")
    public List<Usuario> getUsuario(@PathVariable String nombreUsuario) {
        return usuarioDao.getUsuario(nombreUsuario);
    }






    @RequestMapping(value="/usuarios{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable int id){
        eliminarUsuario(id);
    };

    @RequestMapping(value="/registroUsuario", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        usuarioDao.registrar(usuario);
    };

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        if(usuarioDao.verificarUsuario(usuario)){
            return "OK";
        }else{
           return "FAIL";
        }
    };



}
