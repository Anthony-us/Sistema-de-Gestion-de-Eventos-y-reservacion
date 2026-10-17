package com.mycompany.gestiondeeventos;

public class Eventos {
    private int idEvento;
    private String Titulo;
    private String descripcion;
    private String fecha;
    private String lugar;
    private String direccion;
    private double precio;
    private int cupoTotal;
    private int cupoDisponible;
    private Estado estado;
    private Usuario organizador;

    public Eventos(int idEvento, String Titulo, String descripcion, String fecha, String lugar, String direccion, double precio, int cupoTotal, int cupoDisponible, Estado estado, Usuario organizador) {
        this.idEvento = idEvento;
        this.Titulo = Titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.lugar = lugar;
        this.direccion = direccion;
        setPrecio(precio);
        setCupoTotal(cupoTotal);
        this.cupoDisponible = cupoDisponible;
        this.estado = estado;
        setOrganizador(organizador);
    }
    
    
    public boolean hayCupo(int cantidad){
         return estado == Estado.Programado && cantidad > 0 && cupoDisponible >= cantidad;
    }
    
    public void reservarCupo(int cantidad){
        if (!hayCupo(cantidad)){
            throw new IllegalStateException("No hay cupo suficiente para el evento "+ Titulo);
        }
        
        cupoDisponible -= cantidad;
        if (cupoDisponible == 0){
            estado = Estado.Agotado;
        }
    }
    
    

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        
        this.precio = precio;
    }

    public int getCupoTotal() {
        return cupoTotal;
    }

    public void setCupoTotal(int cupoTotal) {
        if(cupoTotal <= 0){
            throw new IllegalArgumentException("El cupo debe ser mayor que cero");
        }
        
        this.cupoTotal = cupoTotal;
    }

    public int getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(int cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Usuario getOrganizador() {
        if (organizador == null || organizador.getRol() != Tipo.Organizador){
            throw new IllegalArgumentException("Solo un usuario con rol de "
                    + "Organizador puede crear un evento");
        }
        
        return organizador;
    }

    public void setOrganizador(Usuario organizador) {
        this.organizador = organizador;
    }
    
    
    
    
}
