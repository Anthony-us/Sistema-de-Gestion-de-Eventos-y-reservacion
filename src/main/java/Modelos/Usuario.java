package Modelos;

import com.mycompany.gestiondeeventos.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuario {

    private int id;
    private String nombre;
    private String apellidos;
    private int telefono;
    private String correo;
    private String usuario;
    private String contrasena;
    private Tipo rol;

    //Registrar Usuario
    public Usuario(String nombre, String apellidos, int telefono, String correo, String usuario, String contrasena, Tipo rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    //Constructor para editar
    public Usuario(int id, String nombre, String apellidos, int telefono, String correo, String usuario, String contrasena, Tipo rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    //Constructor para eliminar y Consultar
    public Usuario(int id) {
        this.id = id;
    }

    public static Usuario iniciarSesion(String usuario, String contrasena) {
        ConexionSQL conexionSQL = new ConexionSQL();
        String sql = "SELECT id, nombre, apellidos, telefono, correo, usuario,contrasena, rol FROM usuarios WHERE usuario = ?";

        try {
            PreparedStatement ps = conexionSQL.conectarSQL().prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //Agarra la contrasena guardada en la base de datos y lo iguala con el ingresado
                String contrasenaBD = rs.getString("contrasena");

                if (contrasenaBD.equals(contrasena)) {
                    Usuario u = new Usuario(rs.getInt("id"), 
                                rs.getString("nombre"), 
                                rs.getString("apellidos"), 
                                rs.getInt("telefono"),
                                rs.getString("correo"), 
                                rs.getString("usuario"),
                                rs.getString("contrasena"), 
                                Tipo.valueOf(rs.getString("rol")));
                    return u;
                }
            }
            return null;

        } catch (SQLException ex) {
            System.out.println("Exception Iniciar Sesion: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Error general: " + ex.getMessage());
            return null;
        } finally {
            conexionSQL.desconectarSQL();
        }
    }
    
    public static boolean existeCorreo(String correo){
        ConexionSQL conexionSQL = new ConexionSQL();
        String sql = "SELECT 1 FROM usuarios WHERE correo = ? LIMIT 1";
        
        try{
            PreparedStatement ps = conexionSQL.conectarSQL().prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(Exception ex){
            System.out.println("Exception existeCorreo: " + ex.getMessage());
            return false;
        }finally {
            conexionSQL.desconectarSQL();
        }
    }

    public static boolean existeUsuario(String usuario){
        ConexionSQL conexionSQL = new ConexionSQL();
        String sql = "SELECT 1 FROM usuarios WHERE usuario = ? LIMIT 1";
        
        try{
            PreparedStatement ps = conexionSQL.conectarSQL().prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(Exception ex){
            System.out.println("Exception existeUsuario: " + ex.getMessage());
            return false;
        }finally {
            conexionSQL.desconectarSQL();
        }
    }
    
    // Consultar:
    public static DefaultTableModel consultar(JFrame frame) {
        ConexionSQL conexionSQL = new ConexionSQL();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("CORREO");
        modelo.addColumn("USUARIO");
        modelo.addColumn("CONTRASENA");
        modelo.addColumn("ROL");
        String fila[] = new String[8];

        try {
            PreparedStatement ps = conexionSQL.conectarSQL().prepareStatement(
                    "SELECT * FROM usuarios;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                fila[0] = rs.getString("id");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellidos");
                fila[3] = rs.getString("telefono");
                fila[4] = rs.getString("correo");
                fila[5] = rs.getString("usuario");
                fila[6] = rs.getString("contrasena");
                fila[7] = rs.getString("rol");
                modelo.addRow(fila);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "No se pudo cargar los usuarios.");
            System.out.println("Exception Consultar: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame,
                    "No se pudo establacer conexion con la base de datos.");
        } finally {
            conexionSQL.desconectarSQL();
        }

        return modelo;
    }

    // Registro de Usuario y agregarlo a la base de datos:
    public String agregar() {
        ConexionSQL conexionSQL = new ConexionSQL();

        String sql = "INSERT INTO usuarios(nombre, apellidos, telefono, correo, usuario, contrasena, rol)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = conexionSQL.conectarSQL()
                    .prepareStatement(sql);

            ps.setString(1, this.nombre);
            ps.setString(2, this.apellidos);
            ps.setInt(3, this.telefono);
            ps.setString(4, this.correo);
            ps.setString(5, this.usuario);
            ps.setString(6, this.contrasena);
            ps.setString(7, this.rol.toString());

            ps.executeUpdate();
            return "Registro de usuario agregado con exito.";
        } catch (SQLException ex) {
            System.out.println("Exception Agregar: " + ex.getMessage());
            return "No se pudo agregar el registro.";
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
                     UPDATE usuarios SET
                     nombre = ?,
                     apellidos = ?,
                     telefono = ?,
                     correo = ?,
                     usuario = ?,
                     contrasena = ?,
                     rol = ?
                     WHERE id = ?;""";

        try {
            PreparedStatement ps = conexionSQL.conectarSQL()
                    .prepareStatement(sql);

            ps.setString(1, this.nombre);
            ps.setString(2, this.apellidos);
            ps.setInt(3, this.telefono);
            ps.setString(4, this.correo);
            ps.setString(5, this.usuario);
            ps.setString(6, this.contrasena);
            ps.setString(7, this.rol.toString());
            ps.setInt(8, this.id);
            ps.executeUpdate();
            return "Usuario modificado con exito.";
        } catch (SQLException ex) {
            System.out.println("Exception Editar: " + ex.getMessage());
            return "No se pudo modificar el usuario.";
        } catch (Exception ex) {
            return "No se pudo establacer conexion con la base de datos.";
        } finally {
            conexionSQL.desconectarSQL();
        }
    }

    // Eliminar:
    public String eliminar() {
        ConexionSQL conexionSQL = new ConexionSQL();

        String sql = "DELETE FROM usuarios WHERE id = ?;";

        try {
            PreparedStatement ps = conexionSQL.conectarSQL()
                    .prepareStatement(sql);

            ps.setInt(1, this.id);

            ps.executeUpdate();
            return "Usuario eliminado con exito.";
        } catch (SQLException ex) {
            System.out.println("Exception Eliminar: " + ex.getMessage());
            return "No se pudo eliminar el usuario.";
        } catch (Exception ex) {
            return "No se pudo establacer conexion con la base de datos.";
        } finally {
            conexionSQL.desconectarSQL();
        }
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Tipo getRol() {
        return rol;
    }

    public void setRol(Tipo rol) {
        this.rol = rol;
    }
}
