/**
* sesiónIniciada.java
* 13 feb. 2023 22:30:13
* 
*/ 

package presentacion;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import interfaces.IClienteDAO;
import interfaces.ICuentaDAO;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class OperacionesCliente extends javax.swing.JFrame {
    
    Frame menu;
    Cliente cliente = null;
    IClienteDAO clienteDAO;
    ICuentaDAO cuentaDAO;
    DefaultComboBoxModel listaCuentas;

    /**
     * 
     * @param menu
     * @param cliente
     * @param clienteDAO
     * @param cuentaDAO 
     */
    public OperacionesCliente(Frame menu, Cliente cliente, IClienteDAO clienteDAO, ICuentaDAO cuentaDAO) {
        this.menu = menu;
        this.cliente = cliente;
        this.clienteDAO = clienteDAO;
        this.cuentaDAO = cuentaDAO;
        initComponents();
        this.setVisible(true);
        try {
            listaCuentas = cuentaDAO.listaCuentas(cliente);
        } catch (PersistenciaException ex) {
            Logger.getLogger(OperacionesCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelNombreCuenta = new javax.swing.JLabel();
        labelBienvenido = new javax.swing.JLabel();
        boxNumeroCuenta = new javax.swing.JComboBox<>();
        labelSeleccionaTuCuenta = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        labelMontoEnLaCuenta = new javax.swing.JLabel();
        labelMonto = new javax.swing.JLabel();
        btnTransferencia = new javax.swing.JButton();
        btnGenerarRetiro = new javax.swing.JButton();
        btnHistorialMovimientos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnModificarDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        labelNombreCuenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNombreCuenta.setText(cliente.getNombre() + " " + cliente.getApellidoPaterno());

        labelBienvenido.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelBienvenido.setText("Bienvenido: ");

        boxNumeroCuenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boxNumeroCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNumeroCuentaActionPerformed(evt);
            }
        });

        labelSeleccionaTuCuenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelSeleccionaTuCuenta.setText("Selecciona tu Cuenta");

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        labelMontoEnLaCuenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelMontoEnLaCuenta.setText("Monto en la Cuenta");

        labelMonto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelMonto.setText("$0.00");

        btnTransferencia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTransferencia.setText("Transferencia");
        btnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciaActionPerformed(evt);
            }
        });

        btnGenerarRetiro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGenerarRetiro.setText("Generar Retiro");
        btnGenerarRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarRetiroActionPerformed(evt);
            }
        });

        btnHistorialMovimientos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHistorialMovimientos.setText("Historial de Movimientos");
        btnHistorialMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialMovimientosActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnModificarDatos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificarDatos.setText("Modificar Datos Personales");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBienvenido)
                            .addComponent(labelSeleccionaTuCuenta))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNombreCuenta)
                            .addComponent(boxNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCerrarSesion)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir))
                    .addComponent(btnModificarDatos))
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerarRetiro)
                    .addComponent(btnTransferencia)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelMontoEnLaCuenta)
                        .addGap(18, 18, 18)
                        .addComponent(labelMonto))
                    .addComponent(btnHistorialMovimientos))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBienvenido)
                    .addComponent(labelNombreCuenta)
                    .addComponent(labelMontoEnLaCuenta)
                    .addComponent(labelMonto))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSeleccionaTuCuenta)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnTransferencia)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerarRetiro)
                    .addComponent(btnModificarDatos))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnHistorialMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCerrarSesion)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        this.setEnabled(false);
        Transferencia transferencia = new Transferencia(this);
    }//GEN-LAST:event_btnTransferenciaActionPerformed

    private void btnGenerarRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarRetiroActionPerformed
        this.setEnabled(false);
        GenerarRetiroSinCuenta generarRetiroSinCuenta = new GenerarRetiroSinCuenta(this);
    }//GEN-LAST:event_btnGenerarRetiroActionPerformed

    private void btnHistorialMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialMovimientosActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        HistorialMovimientosCuenta historialMovimientosCuenta = new HistorialMovimientosCuenta(this);
    }//GEN-LAST:event_btnHistorialMovimientosActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        menu.setEnabled(true);
        dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void boxNumeroCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxNumeroCuentaActionPerformed

    }//GEN-LAST:event_boxNumeroCuentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxNumeroCuenta;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnGenerarRetiro;
    private javax.swing.JButton btnHistorialMovimientos;
    private javax.swing.JButton btnModificarDatos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelBienvenido;
    private javax.swing.JLabel labelMonto;
    private javax.swing.JLabel labelMontoEnLaCuenta;
    private javax.swing.JLabel labelNombreCuenta;
    private javax.swing.JLabel labelSeleccionaTuCuenta;
    // End of variables declaration//GEN-END:variables

}
