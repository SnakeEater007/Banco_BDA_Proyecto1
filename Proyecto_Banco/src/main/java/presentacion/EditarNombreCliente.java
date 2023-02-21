/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClienteDAO;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public class EditarNombreCliente extends javax.swing.JFrame {

    Frame editarDatosCliente;
    IClienteDAO clienteDAO;
    Cliente cliente;

    /**
     * Creates new form EditarNombreCliente
     */
    public EditarNombreCliente(Frame editarDatosCliente, IClienteDAO clienteDAO, Cliente cliente) {
        this.editarDatosCliente = editarDatosCliente;
        this.clienteDAO = clienteDAO;
        this.cliente = cliente;
        initComponents();
        editarDatosCliente.setEnabled(false);
        this.setVisible(true);
    }

    private Cliente recojerDatos() {
        String nombre = this.fieldNombre.getText();
        String apelldiP = this.fieldAP.getText();
        String apelldiM = this.fieldAM.getText();

        boolean validaNombre = nombre.matches("[a-z A-Z \\s]+");
        boolean validaAP = apelldiP.matches("[a-z A-Z \\s]+");
        boolean validaAM = apelldiM.matches("[a-z A-Z \\s]+");
        System.out.println(validaNombre);
        System.out.println(validaAP);
        System.out.println(validaAM);
        if (validaNombre && validaAP && validaAM) {
            Cliente cliente = new Cliente();
            cliente.setId(this.cliente.getId());
            cliente.setNombre(nombre);
            cliente.setApellidoPaterno(apelldiP);
            cliente.setApellidoMaterno(apelldiM);
            return cliente;
        }else{
        JOptionPane.showMessageDialog(this, "Asegurate de no ingresar ningun caracter especial", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
        }

    }

    private void cambiarNombre() {
        Cliente cliente = recojerDatos();
        try {
            clienteDAO.actualizarNombreCliente(cliente.getId(), cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno());
            JOptionPane.showMessageDialog(this, "Se actualizo con exito", "Actualizado", JOptionPane.INFORMATION_MESSAGE);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        fieldAP = new javax.swing.JTextField();
        fieldAM = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Apellido Paterno");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Apellido Materno");

        fieldAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAPActionPerformed(evt);
            }
        });

        fieldAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAMActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnAtras.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldAP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldAM, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnActualizar)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar)
                            .addComponent(btnAtras))
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAPActionPerformed

    private void fieldAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAMActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        cambiarNombre();
        editarDatosCliente.setEnabled(true);
        dispose();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        editarDatosCliente.setEnabled(true);
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JTextField fieldAM;
    private javax.swing.JTextField fieldAP;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
