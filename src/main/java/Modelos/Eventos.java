package Modelos;

import com.mycompany.gestiondeeventos.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Eventos {
    private int idEvento;
    private String Titulo;
    private String fecha;
    private String lugar;
    private String direccion;
    private double precio;
    private int cupoDisponible;
    private Estado estado;
    private String organizador;
    
    public Eventos(){
    }
    
    //Registrar Evento
    public Eventos(String Titulo, String fecha, String lugar, String direccion, double precio, int cupoDisponible, Estado estado, String organizador){
        this.Titulo = Titulo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.direccion = direccion;
        setPrecio(precio);
        setCupoDisponible(cupoDisponible);
        this.estado = estado;
        this.organizador = organizador;
    }
    
    //Constructor para editar y cargar los datos desde la base de datos a la tabla

    public Eventos(int idEvento, String Titulo, String fecha, String lugar, String direccion, double precio, int cupoDisponible, Estado estado, String organizador) {
        this.idEvento = idEvento;
        this.Titulo = Titulo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.direccion = direccion;
        setPrecio(precio);
        setCupoDisponible(cupoDisponible);
        this.estado = estado;
        this.organizador = organizador;
    }
    
    //Constructor para eliminar 

    public Eventos(int idEvento) {
        this.idEvento = idEvento;
    }

    public boolean hayCupo(int cantidad) {
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
    
    
    //Consultar
    public static DefaultTableModel consultar(JFrame frame){
        ConexionSQL conexionSQL = new ConexionSQL();

        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("TITULO");
        modelo.addColumn("FECHA");
        modelo.addColumn("LUGAR");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CUPO DISPONIBLE");
        modelo.addColumn("ESTADO");
        modelo.addColumn("ORGANIZADOR");
        String fila[] = new String[9];

        try {
            PreparedStatement ps = conexionSQL.conectarSQL().prepareStatement(
                    "SELECT * FROM eventos;");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                fila[0] = rs.getString("id_evento");
                fila[1] = rs.getString("titulo");
                fila[2] = rs.getString("fecha");
                fila[3] = rs.getString("lugar");
                fila[4] = rs.getString("direccion");
                fila[5] = rs.getString("precio");
                fila[6] = rs.getString("cupo_disponible");
                fila[7] = rs.getString("estado");
                fila[8] = rs.getString("organizador");
                modelo.addRow(fila);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "No se pudo cargar los eventos.");
            System.out.println("Exception Consultar: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame,
                    "No se pudo establacer conexion con la base de datos.");
        } finally {
            conexionSQL.desconectarSQL();
        }

        return modelo;
    }
    
    //Agregar evento a la base de datos
    public String agregar() {
        ConexionSQL conexionSQL = new ConexionSQL();

        String sql = "INSERT INTO eventos(titulo, fecha,lugar, direccion, precio, cupo_disponible, estado, organizador)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = conexionSQL.conectarSQL()
                    .prepareStatement(sql);

            ps.setString(1, this.Titulo);
            ps.setString(2, this.fecha);
            ps.setString(3, this.lugar);
            ps.setString(4, this.direccion);
            ps.setDouble(5, this.precio);
            ps.setInt(6, this.cupoDisponible);
            ps.setString(7, this.estado.toString());
            ps.setString(8, this.organizador);

            ps.executeUpdate();
            return "Evento agregado con exito.";
        } catch (SQLException ex) {
            System.out.println("Exception Agregar: " + ex.getMessage());
            return "No se pudo agregar el evento.";
        } catch (Exception ex) {
            return "No se pudo establacer conexion con la base de datos.";
        } finally {
            conexionSQL.desconectarSQL();
        }
    }
    
    
    // Modificar:
    public String editar() {
        ConexionSQL conexionSQL = new ConexionSQL();

        String sql = """
                     UPDATE eventos SET
                     titulo = ?,
                     fecha = ?,
                     lugar = ?,
                     direccion = ?,
                     precio = ?,
                     cupo_disponible = ?,
                     estado = ?,
                     organizador = ?
                     WHERE id_evento = ?;""";

        try {
            PreparedStatement ps = conexionSQL.conectarSQL()
                    .prepareStatement(sql);

            ps.setString(1, this.Titulo);
            ps.setString(2, this.fecha);
            ps.setString(3, this.lugar);
            ps.setString(4, this.direccion);
            ps.setDouble(5, this.precio);
            ps.setInt(6, this.cupoDisponible);
            ps.setString(7, this.estado.toString());
            ps.setString(8, this.organizador);
            ps.setInt(9, this.idEvento);
            ps.executeUpdate();
            return "Evento modificado con exito.";
        } catch (SQLException ex) {
            System.out.println("Exception Editar: " + ex.getMessage());
            return "No se pudo modificar el evento.";
        } catch (Exception ex) {
            return "No se pudo establacer conexion con la base de datos.";
        } finally {
            conexionSQL.desconectarSQL();
        }
    }

    // Eliminar:
    public String eliminar() {
        ConexionSQL conexionSQL = new ConexionSQL();

        String sql = "DELETE FROM eventos WHERE id_evento = ?;";

        try {
            PreparedStatement ps = conexionSQL.conectarSQL()
                    .prepareStatement(sql);

            ps.setInt(1, this.idEvento);

            ps.executeUpdate();
            return "Evento eliminado con exito.";
        } catch (SQLException ex) {
            System.out.println("Exception Eliminar: " + ex.getMessage());
            return "No se pudo eliminar el evento.";
        } catch (Exception ex) {
            return "No se pudo establacer conexion con la base de datos.";
        } finally {
            conexionSQL.desconectarSQL();
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

    public int getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(int cupoDisponible) {
        if (cupoDisponible < 0){
            throw new IllegalArgumentException("El cupo disponible no puede ser negativo");
        }
        this.cupoDisponible = cupoDisponible;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    
}  

