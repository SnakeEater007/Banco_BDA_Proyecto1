/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClienteDAO;
import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Armando Peña García ID: 229185
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public class ClienteDAO implements IClienteDAO {

    private static final Logger LOG
            = Logger.getLogger(ClienteDAO.class.getName());

    private final IConexionBD generadorConexiones;

    public ClienteDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente)
            throws PersistenciaException {
        String insert = "INSERT INTO CLIENTES(nombre, apellidoP, apellidoM, "
                + "fechaNacimiento, celular, contraseña)"
                + "VALUES(?,?,?,?,?,?);";

        Cliente regresaCliente = null;
        try (
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando
                = conexion.prepareStatement(insert,
                        Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApellidoMaterno());
            comando.setString(4, cliente.getFechaNacimiento());
            comando.setString(5, cliente.getCelular());
            comando.setString(6, cliente.getContrasena());
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                Integer id = resultado.getInt(
                        Statement.RETURN_GENERATED_KEYS);
                regresaCliente = new Cliente(id, cliente.getNombre(),
                        cliente.getApellidoPaterno(),
                        cliente.getApellidoMaterno(),
                        cliente.getFechaNacimiento(), cliente.getCelular(),
                        cliente.getContrasena());
                return regresaCliente;
            }
            LOG.log(Level.WARNING, "Se insertó el cliente pero no se generó id");
            throw new PersistenciaException("Se insertó el cliente pero no se generó id");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No se pudo insertar al cliente: " + e.getMessage());
        }
    }

    @Override
    public Cliente iniciaCliente(String telefono, String contrasena) throws PersistenciaException {
        String consulta = "SELECT *"
                + " FROM clientes "
                + "WHERE celular = ?";
        try (
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(consulta);) {
            comando.setString(1, telefono);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String apellidoP = resultado.getString("apellidoP");
                String apellidoM = resultado.getString("apellidoM");
                String fechaNacimiento = resultado.getString("fechaNacimiento");
                Cliente cliente = new Cliente(id, nombre, apellidoP, apellidoM, fechaNacimiento, telefono, contrasena);
                return cliente;
            }
            LOG.log(Level.WARNING, "Alguno de los datos está incorrecto");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    @Override
    public int actualizarNombreCliente(Integer id, String nombre, String apellidoP, String apellidoM) throws PersistenciaException {
        String update = "UPDATE CLIENTES "
                + "SET NOMBRE = ?, ApellidoP = ?, ApellidoM = ? "
                + "WHERE id = ?";
        try (
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(update);) {
            comando.setString(1, nombre);
            comando.setString(2, apellidoP);
            comando.setString(3, apellidoP);
            comando.setInt(4, id);
            int afectados = comando.executeUpdate();
            return afectados;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return 0;
    }

    @Override
    public int actualizarFechaNacimiento(Integer id, String fechaNacimiento) throws PersistenciaException {
        String update = "UPDATE CLIENTES "
                + "SET fechaNacimiento = ?"
                + "WHERE id = ?";
        try (
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(update);) {
            comando.setString(1, fechaNacimiento);
            comando.setInt(2, id);
            int afectados = comando.executeUpdate();
            return afectados;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return 0;
    }

    @Override
    public int actualizarCelular(Integer id, String celular) throws PersistenciaException {
        String update = "UPDATE CLIENTES "
                + "SET celular = ?"
                + "WHERE id = ?";
        try (
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(update);) {
            comando.setString(1, celular);
            comando.setInt(2, id);
            int afectados = comando.executeUpdate();
            return afectados;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return 0;
    }

    @Override
    public int actualizarContrasena(Integer id, String contrasena) throws PersistenciaException {
        String update = "UPDATE CLIENTES "
                + "SET contraseña = ?"
                + "WHERE id = ?";
        try (
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(update);) {
            comando.setString(1, contrasena);
            comando.setInt(2, id);
            int afectados = comando.executeUpdate();
            return afectados;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return 0;
    }

}
