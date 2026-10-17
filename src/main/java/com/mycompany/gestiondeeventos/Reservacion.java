package com.mycompany.gestiondeeventos;

public class Reservacion {
    private static int contador = 1;
    
    private int id;
    private Eventos evento;
    private Usuario cliente;
    private int cantidadEntradas;
    private String fechaReserva;
    private EstadoReservacion estado;
    private double total;

    public Reservacion(int id, Eventos evento, Usuario cliente, int cantidadEntradas, String fechaReserva, EstadoReservacion estado, double total) {
        this.id = id;
        setEvento(evento);
        setCliente(cliente);
        setCantidadEntradas(cantidadEntradas);
        this.fechaReserva = fechaReserva;
        this.estado = estado;
        this.total = total;
    }

    public double calcularTotal(){
        return evento.getPrecio() * cantidadEntradas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        if (evento == null){
            throw new IllegalArgumentException("La reservación debe expecificar "
                    + "el evento al que quiere reservar");
        }
        this.evento = evento;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        if (cliente == null || cliente.getRol() != Tipo.Cliente){
            throw new IllegalArgumentException("Solo usuario con rol cliente puede realizar una reservacion");
        }
        this.cliente = cliente;
    }

    public int getCantidadEntradas() {
        return cantidadEntradas;
    }

    public void setCantidadEntradas(int cantidadEntradas) {
        if (cantidadEntradas <= 0){
            throw new IllegalArgumentException("La cartidad de entradas debe ser mayor a 0");
        }
        this.cantidadEntradas = cantidadEntradas;
        if (evento != null){
            this.total = calcularTotal();
        }
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public EstadoReservacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoReservacion estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Reservacion #" + id + " - " + evento.getTitulo() + " x" + cantidadEntradas;
    }
    
    
    
}
