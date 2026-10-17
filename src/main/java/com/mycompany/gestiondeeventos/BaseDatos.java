package com.mycompany.gestiondeeventos;

import java.util.ArrayList;

/**
 *Esta clase solo estará disponible durante el primer avance, durante el segundo
 * se reemplazará cuando se implemente sql para la base de datos. 
 */
public class BaseDatos {
    private static final ArrayList<Usuario> usuarios = new ArrayList<>();
    private static int contadorUsuarios = 1;
    
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }
    
    public static int siguienteIdUsuario(){
        return contadorUsuarios++;
    }
    
    public static void agregarUsuario(Usuario u){
        usuarios.add(u);
    }
    
    public static boolean existeCorreo(String correo){
        for (Usuario u : usuarios){
            if (u.getCorreo().equals(correo)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean existeUsuario(String usuario){
        for (Usuario u : usuarios){
            if (u.getUsuario().equals(usuario)){
                return true;
            }
        }
        return false;
    }
    
    public static Usuario validarLogin(String usuario, String contraseña){
        for(Usuario u : usuarios){
            if(u.validadDatos(usuario, contraseña)){
                return u;
            }
        }
        return null;
    }
    
    
}
