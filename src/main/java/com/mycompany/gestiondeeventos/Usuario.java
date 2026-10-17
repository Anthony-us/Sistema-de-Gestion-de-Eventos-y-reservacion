package com.mycompany.gestiondeeventos;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String contraseña;
    private Tipo rol;
    private boolean registrado;

    public Usuario(int id, String nombre, String correo, String contraseña, Tipo rol, boolean registrado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.registrado = registrado;
    }

    public boolean validadDatos(String correo, String contraseña){
        return this.correo.equals(correo) && this.contraseña.equals(contraseña);
    }

    @Override
    public String toString() {
        return nombre + "(" + rol + ")";
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Tipo getRol() {
        return rol;
    }

    public void setRol(Tipo rol) {
        this.rol = rol;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }
    
    
    
}
