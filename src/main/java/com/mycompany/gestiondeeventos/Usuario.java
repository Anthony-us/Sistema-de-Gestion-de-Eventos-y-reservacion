package com.mycompany.gestiondeeventos;

public abstract class Usuario {
    protected String idUsuario;
    protected String nombre;
    protected String correo;
    protected String contraseña; 

    public Usuario(String idUsuario, String nombre, String correo, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public abstract void registrar();
    public abstract boolean iniciarSesion(String correo, String contraseña);
    
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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
    
    
    
}
