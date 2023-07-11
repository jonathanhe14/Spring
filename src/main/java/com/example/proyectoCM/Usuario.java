package com.example.proyectoCM;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Usuario")
public class Usuario {



    @Id
    @Column(name ="usuario",nullable = false,unique = true)
    private String usuario;
    @Column(name ="nombre")
    private String nombre;
    @Column(name ="apellido")
    private String apellido;
    @Column(name ="correo",nullable = false,unique = true)
    private String correo;
    @Column(name ="contrasenna")
    private String contrasenna;
    @Column(name ="edad")
    private int edad;

    @OneToMany(mappedBy = "usuario")
    private List<Tarea> tareas;

    public Usuario(String correo, String contrasenna, String usuario, String nombre,String apellido,int edad) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo=correo;
        this.contrasenna=contrasenna;

    }

    public Usuario() {

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                ", usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenna='" + contrasenna + '\'' +
                ", edad=" + edad +
                '}';
    }
}
