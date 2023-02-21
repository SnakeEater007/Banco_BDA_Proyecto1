/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dominio.Cliente;
import encriptador.Encriptador;
import excepciones.PersistenciaException;
import interfaces.IClienteDAO;
import interfaces.ICuentaDAO;
import interfaces.IDepositoDAO;
import interfaces.IDireccionesDAO;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * IFormulario que contiene el menu inicio del sistema
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 * @author Daniel Armando Peña García 000000229185
 */
public class MenuDlg extends javax.swing.JFrame {

    private final IClienteDAO clienteDAO;
    private final ICuentaDAO cuentaDAO;
    private final IDireccionesDAO direccionesDAO;
    private final IDepositoDAO depositoDAO;

    /**
     * Contructor
     *
     * @param clienteDAO control clienteDAO
     * @param cuentaDAO control cuentaDAO
     * @param direccionesDAO control direccionesDAO
     * @param depositoDAO control depostioDAO
     */
    public MenuDlg(IClienteDAO clienteDAO, ICuentaDAO cuentaDAO, IDireccionesDAO direccionesDAO, IDepositoDAO depositoDAO) {
        this.cuentaDAO = cuentaDAO;
        this.clienteDAO = clienteDAO;
        this.direccionesDAO = direccionesDAO;
        this.depositoDAO = depositoDAO;
        initComponents();
    }

    private void iniciarSesior() {
        String celular = txtTelefono.getText();
        char[] contrasena = passContrasena.getPassword();
        String contrasenaOptenida = new String(contrasena);
        Cliente cliente = null;
        try {
            cliente = clienteDAO.iniciaCliente(celular);
        } catch (PersistenciaException ex) {
            Logger.getLogger("Error: " + ex.getMessage());
        }

        Encriptador encriptador = new Encriptador();

        String contrasenaDesencriptada = encriptador.desencriptar(cliente.getContrasena());

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "No hay ningún usuario\n"
                    + "Con ese número", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (contrasenaDesencriptada.equals(contrasenaOptenida)) {
            this.setVisible(false);
            OperacionesClienteDlg operacionesCliente = new OperacionesClienteDlg(this, cliente, clienteDAO, cuentaDAO, depositoDAO);
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void retirar() {
        String texto = this.txtFolio.getText();

        if (texto.matches("[0-9]*")) {
            Integer folio = Integer.parseInt(texto);
            String contrasena = this.txtConstrasenaRetiro.getText();
            try {
                boolean r = cuentaDAO.procederRetiro(folio, contrasena);
                if (r) {
                    JOptionPane.showMessageDialog(this, "Retiro con exito", "", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo hacer el retiro, " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Folio invalido, revisa que nomas contenga numeros", "Error", JOptionPane.WARNING_MESSAGE);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelIniciarSesion = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        labelRetiroSinCuenta = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        txtConstrasenaRetiro = new javax.swing.JTextField();
        btnRetirar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Bancario");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        labelIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelIniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        labelIniciarSesion.setText("Iniciar Sesión");

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrarme");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        labelRetiroSinCuenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelRetiroSinCuenta.setForeground(new java.awt.Color(0, 0, 0));
        labelRetiroSinCuenta.setText("Retiro Sin Cuenta");

        txtFolio.setBackground(new java.awt.Color(255, 255, 255));

        txtConstrasenaRetiro.setBackground(new java.awt.Color(255, 255, 255));

        btnRetirar.setText("Retirar");
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Folio:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña: ");

        passContrasena.setBackground(new java.awt.Color(255, 255, 255));
        passContrasena.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIniciarSesion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegistrar))
                    .addComponent(passContrasena))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConstrasenaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(72, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRetirar)
                        .addGap(125, 125, 125))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(labelIniciarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelRetiroSinCuenta)
                .addGap(97, 97, 97))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIniciarSesion)
                    .addComponent(labelRetiroSinCuenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConstrasenaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(passContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarSesion)
                    .addComponent(btnRegistrar)
                    .addComponent(btnRetirar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton que inicia sesion
     *
     * @param evt
     */
    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        iniciarSesior();
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    /**
     * Boton que abre el fomulario de registrarse
     *
     * @param evt ...
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        this.setVisible(false);
        RegistrarClienteDlg registrarCliente = new RegistrarClienteDlg(this, direccionesDAO, clienteDAO);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    /**
     * Boton que ejecuta el retirar dinero
     * @param evt 
     */
    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        // TODO add your handling code here:
        retirar();
    }//GEN-LAST:event_btnRetirarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelIniciarSesion;
    private javax.swing.JLabel labelRetiroSinCuenta;
    private javax.swing.JPasswordField passContrasena;
    private javax.swing.JTextField txtConstrasenaRetiro;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
