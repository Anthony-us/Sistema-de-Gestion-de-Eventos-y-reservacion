package Modelos;

import com.mycompany.gestiondeeventos.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Reservacion {  
    private int id;
    private Eventos evento;
    private Usuario cliente;
    private int cantidadEntradas;
    private String fechaReserva;
    private EstadoReservacion estado;
    private double total;

    // Crea una nueva reservacion
    public Reservacion(Eventos evento, Usuario cliente, int cantidadEntradas, String fechaReserva, EstadoReservacion estado, double total) {
        setEvento(evento);
        setCliente(cliente);
        setCantidadEntradas(cantidadEntradas);
        this.fechaReserva = fechaReserva;
        this.estado = estado;
        this.total = calcularTotal();
    }   
    
    // 
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
        if(evento == null){
            return 0.0;
        }
        return evento.getPrecio() * cantidadEntradas;
    }
    
    //Se usa para agregar una reservacion
    public String agregar(){
        ConexionSQL conexionSQL = new ConexionSQL();

        String sql = "INSERT INTO reservaciones(id_evento, id_usuario, cantidad_entradas, fecha_reserva, total, estado)"
                + "VALUES (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = conexionSQL.conectarSQL()
                    .prepareStatement(sql);

            ps.setInt(1, this.evento.getIdEvento());
            ps.setInt(2, this.cliente.getId());
            ps.setInt(3, this.cantidadEntradas);
            ps.setString(4, this.fechaReserva);
            ps.setDouble(5, this.total);
            ps.setString(6, this.estado.toString());
            
                

            ps.executeUpdate();
            return "Reservacion agregada con exito.";
        } catch (SQLException ex) {
            System.out.println("Exception Agregar Reservacion: " + ex.getMessage());
            return "No se pudo agregar la reservacion.";
        } catch (Exception ex) {
            return "No se pudo establacer conexion con la base de datos.";
        } finally {
            conexionSQL.desconectarSQL();
        }
    
    }
    
    //Se usa para mostrar los datos en las tablas y cada uno solo consulta sus reservaciones
    public static DefaultTableModel consultar(JFrame frame, int idUsuario){
        ConexionSQL conexionSQL = new ConexionSQL();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Evento");
        modelo.addColumn("Cliente");
        modelo.addColumn("Entradas");
        modelo.addColumn("Fecha Reservada");
        modelo.addColumn("Total");
        modelo.addColumn("Estado");
        String fila[] = new String[7];
        
        String sql = """
                    SELECT r.id_reservacion,
                           e.titulo AS evento_titulo,
                           u.usuario AS cliente,
                           r.cantidad_entradas,
                           r.fecha_reserva,
                           r.total,
                           r.estado
                    FROM reservaciones r
                    INNER JOIN eventos e ON r.id_evento = e.id_evento
                    INNER JOIN usuarios u ON r.id_usuario = u.id
                    WHERE r.id_usuario = ?
                    ORDER BY r.id_reservacion DESC;
                    """;

        try {
            PreparedStatement ps = conexionSQL.conectarSQL().prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                fila[0] = rs.getString("id_reservacion");
                fila[1] = rs.getString("evento_titulo");
                fila[2] = rs.getString("cliente");
                fila[3] = rs.getString("cantidad_entradas");
                fila[4] = rs.getString("fecha_reserva");
                fila[5] = rs.getString("total");
                fila[6] = rs.getString("estado");
                modelo.addRow(fila);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "No se pudo cargar las reservaciones.");
            System.out.println("Exception Consultar: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame,
                    "No se pudo establacer conexion con la base de datos.");
        } finally {
            conexionSQL.desconectarSQL();
        }

        return modelo;
    }
    
    //Cancelar
    
    public String cancelar(){
        ConexionSQL conexionSQL = new ConexionSQL();
        
        String sql = "UPDATE reservaciones set estado = ? WHERE id_reservacion = ?;";
        try {
            PreparedStatement ps = conexionSQL.conectarSQL()
                    .prepareStatement(sql);

            ps.setString(1, this.estado.Cancelada.toString());
            ps.setInt(2, id);
           
            ps.executeUpdate();
            return "Reservacion cancelada con exito.";
        } catch (SQLException ex) {
            System.out.println("Exception Cancelar: " + ex.getMessage());
            return "No se pudo cancelar el evento.";
        } catch (Exception ex) {
            return "No se pudo establacer conexion con la base de datos.";
        } finally {
            conexionSQL.desconectarSQL();
        }
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
