package com.mycompany.gestiondeeventos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Prototipo del Módulo 3: Reservaciones y Pagos.
 * Solo es el diseño con una tabla y botones de prueba; la lógica real
 * (BaseDatos / SQL) se agrega después.
 */
public class ModuloReservaciones extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ModuloReservaciones.class.getName());

    // Posición de las columnas de la tabla
    private static final int COL_ESTADO = 6;
    private static final int COL_PAGO = 7;

    private Dashboard dashboard;
    private Usuario usuario;
    private DefaultTableModel modeloTabla;
    private int contadorPrueba = 4;

    public ModuloReservaciones(Dashboard dashboard, Usuario usuario) {
        initComponents();
        this.dashboard = dashboard;
        this.usuario = usuario;

        // Al cerrar la ventana se regresa al Dashboard (igual que Secundario en App06)
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                volverDashboard();
            }
        });

        lblSesion.setText("Sesión: " + usuario.getNombre() + " (" + usuario.getRol() + ")");

        modeloTabla = (DefaultTableModel) tbReservaciones.getModel();
        tbReservaciones.setDefaultEditor(Object.class, null); // celdas no editables
        cargarDatosPrueba();

        pack();
        setLocationRelativeTo(null);
    }

    public void volverDashboard() {
        dashboard.setVisible(true);
        dispose();
    }

    private void cargarDatosPrueba() {
        modeloTabla.setRowCount(0);
        modeloTabla.addRow(new Object[]{1, "Concierto de Rock", "Ana Rojas", 2, "2026-10-10", 30000.0, EstadoReservacion.Confirmada, EstadoPago.Pagado});
        modeloTabla.addRow(new Object[]{2, "Festival de Jazz", "Luis Mora", 4, "2026-09-20", 48000.0, EstadoReservacion.Confirmada, EstadoPago.Pendiente});
        modeloTabla.addRow(new Object[]{3, "Feria Gastronómica", "María Solís", 3, "2026-10-02", 15000.0, EstadoReservacion.Cancelada, EstadoPago.Reembolsado});
        contadorPrueba = 4;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblSesion = new javax.swing.JLabel();
        pnlLista = new javax.swing.JPanel();
        spTabla = new javax.swing.JScrollPane();
        tbReservaciones = new javax.swing.JTable();
        pnlAcciones = new javax.swing.JPanel();
        btnNueva = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Reservaciones y Pagos");

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 102, 51));
        lblTitulo.setText("Módulo 3: Reservaciones y Pagos");
        lblSesion.setFont(new java.awt.Font("Verdana", 2, 10)); // NOI18N
        lblSesion.setForeground(new java.awt.Color(102, 102, 102));
        lblSesion.setText("Sesión");

        pnlLista.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0)), "Lista de Reservaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 102, 51))); // NOI18N

        tbReservaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Evento", "Cliente", "Entradas", "Fecha Reserva", "Total", "Estado", "Pago"
            }
        ));
        spTabla.setViewportView(tbReservaciones);


        javax.swing.GroupLayout pnlListaLayout = new javax.swing.GroupLayout(pnlLista);
        pnlLista.setLayout(pnlListaLayout);
        pnlListaLayout.setHorizontalGroup(
            pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlListaLayout.setVerticalGroup(
            pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );


        pnlAcciones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0)), "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 102, 51))); // NOI18N
        btnNueva.setBackground(new java.awt.Color(51, 204, 0));
        btnNueva.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnNueva.setText("Nueva Reservación");
        btnNueva.addActionListener(this::btnNuevaActionPerformed);
        btnCancelar.setBackground(new java.awt.Color(51, 204, 0));
        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar Reservación");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        btnPagar.setBackground(new java.awt.Color(51, 204, 0));
        btnPagar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPagar.setText("Registrar Pago");
        btnPagar.addActionListener(this::btnPagarActionPerformed);
        btnActualizar.setBackground(new java.awt.Color(51, 204, 0));
        btnActualizar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);
        btnVolver.setBackground(new java.awt.Color(204, 51, 51));
        btnVolver.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout pnlAccionesLayout = new javax.swing.GroupLayout(pnlAcciones);
        pnlAcciones.setLayout(pnlAccionesLayout);
        pnlAccionesLayout.setHorizontalGroup(
            pnlAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlAccionesLayout.setVerticalGroup(
            pnlAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLista, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaActionPerformed
        modeloTabla.addRow(new Object[]{contadorPrueba, "Evento de prueba", usuario.getNombre(), 1,
            "2026-10-17", 10000.0, EstadoReservacion.Confirmada, EstadoPago.Pendiente});
        contadorPrueba++;

        JOptionPane.showMessageDialog(this,
                "Prototipo: aquí se abrirá el formulario para crear una reservación.\n"
                + "Por ahora se agregó una fila de prueba.",
                "Nueva reservación", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnNuevaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int fila = tbReservaciones.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reservación de la tabla.",
                    "Cancelar reservación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (modeloTabla.getValueAt(fila, COL_ESTADO) == EstadoReservacion.Cancelada) {
            JOptionPane.showMessageDialog(this, "Esta reservación ya está cancelada.",
                    "Cancelar reservación", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea cancelar la reservación seleccionada?",
                "Cancelar reservación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            modeloTabla.setValueAt(EstadoReservacion.Cancelada, fila, COL_ESTADO);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int fila = tbReservaciones.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reservación de la tabla.",
                    "Registrar pago", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (modeloTabla.getValueAt(fila, COL_ESTADO) == EstadoReservacion.Cancelada) {
            JOptionPane.showMessageDialog(this, "No se puede registrar un pago en una reservación cancelada.",
                    "Registrar pago", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (modeloTabla.getValueAt(fila, COL_PAGO) == EstadoPago.Pagado) {
            JOptionPane.showMessageDialog(this, "Esta reservación ya está pagada.",
                    "Registrar pago", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        modeloTabla.setValueAt(EstadoPago.Pagado, fila, COL_PAGO);
        JOptionPane.showMessageDialog(this, "Prototipo: pago registrado.",
                "Registrar pago", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // Más adelante aquí se vuelve a consultar la base de datos
        cargarDatosPrueba();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        volverDashboard();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNueva;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblSesion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlLista;
    private javax.swing.JScrollPane spTabla;
    private javax.swing.JTable tbReservaciones;
    // End of variables declaration//GEN-END:variables
}
