package com.mycompany.gestiondeeventos;

public class Pago {
    private static int contador = 1;
    
    private int id;
    private Reservacion reservacion;
    private double monto;
    private MetodoPago metodo;
    private String fechaPago;
    private EstadoPago estado;

    public Pago(int id, Reservacion reservacion, double monto, MetodoPago metodo, String fechaPago, EstadoPago estado) {
        this.id = contador++;
        setReservacion(reservacion);
        this.monto = reservacion.getTotal();
        setMetodo(metodo);
        this.fechaPago = fechaPago;
        this.estado = EstadoPago.Pendiente;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        if (reservacion == null){
            throw new IllegalArgumentException("El pago debe pertenecer a una reserva");
        }
        if (reservacion.getEstado() == EstadoReservacion.Cancelada){
            throw new IllegalArgumentException("No se puede pagar una reserva cancelada");
        }
        this.reservacion = reservacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        if (monto <= 0){
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }
        this.monto = monto;
    }

    public MetodoPago getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPago metodo) {
        if (metodo == null) {
            throw new IllegalArgumentException("Debe seleccionar un metodo de pago.");
        }
        this.metodo = metodo;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pago #" + id + " - " + monto + " (" + estado + ")";
    }
    
    
    
    
}
