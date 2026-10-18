package com.mycompany.gestiondeeventos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Prototipo del Módulo 2: Gestión de Eventos (CRUD).
 * Solo es el diseño con una tabla y botones de prueba; la lógica real
 * (BaseDatos / SQL) se agrega después.
 */
public class ModuloEventos extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ModuloEventos.class.getName());

    private Dashboard dashboard;
    private Usuario usuario;
    private DefaultTableModel modeloTabla;
    private int contadorPrueba = 5;

    public ModuloEventos(Dashboard dashboard, Usuario usuario) {
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

        modeloTabla = (DefaultTableModel) tbEventos.getModel();
        tbEventos.setDefaultEditor(Object.class, null); // celdas no editables
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
        modeloTabla.addRow(new Object[]{1, "Concierto de Rock", "2026-11-20", "Estadio Nacional", 15000.0, 500, Estado.Programado});
        modeloTabla.addRow(new Object[]{2, "Feria Gastronómica", "2026-12-05", "Parque Central, Cartago", 5000.0, 0, Estado.Agotado});
        modeloTabla.addRow(new Object[]{3, "Festival de Jazz", "2026-10-01", "Teatro Melico Salazar", 12000.0, 120, Estado.Finalizado});
        modeloTabla.addRow(new Object[]{4, "Obra de Teatro", "2026-09-15", "Teatro Popular", 8000.0, 80, Estado.Cancelado});
        contadorPrueba = 5;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblSesion = new javax.swing.JLabel();
        pnlLista = new javax.swing.JPanel();
        spTabla = new javax.swing.JScrollPane();
        tbEventos = new javax.swing.JTable();
        pnlAcciones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestión de Eventos");

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 102, 51));
        lblTitulo.setText("Módulo 2: Gestión de Eventos");
        lblSesion.setFont(new java.awt.Font("Verdana", 2, 10)); // NOI18N
        lblSesion.setForeground(new java.awt.Color(102, 102, 102));
        lblSesion.setText("Sesión");

        pnlLista.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0)), "Lista de Eventos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 102, 51))); // NOI18N

        tbEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Fecha", "Lugar", "Precio", "Cupo Disponible", "Estado"
            }
        ));
        spTabla.setViewportView(tbEventos);


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
        btnAgregar.setBackground(new java.awt.Color(51, 204, 0));
        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);
        btnEditar.setBackground(new java.awt.Color(51, 204, 0));
        btnEditar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(this::btnEditarActionPerformed);
        btnEliminar.setBackground(new java.awt.Color(51, 204, 0));
        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);
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
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlAccionesLayout.setVerticalGroup(
            pnlAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        modeloTabla.addRow(new Object[]{contadorPrueba, "Evento de prueba " + contadorPrueba,
            "2026-12-31", "Por definir", 0.0, 100, Estado.Programado});
        contadorPrueba++;

        JOptionPane.showMessageDialog(this,
                "Prototipo: aquí se abrirá el formulario para agregar un evento.\n"
                + "Por ahora se agregó una fila de prueba.",
                "Agregar evento", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tbEventos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un evento de la tabla.",
                    "Editar evento", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String titulo = modeloTabla.getValueAt(fila, 1).toString();
        JOptionPane.showMessageDialog(this,
                "Prototipo: aquí se abrirá el formulario para editar el evento:\n" + titulo,
                "Editar evento", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tbEventos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un evento de la tabla.",
                    "Eliminar evento", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String titulo = modeloTabla.getValueAt(fila, 1).toString();
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea eliminar el evento \"" + titulo + "\"?",
                "Eliminar evento", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            modeloTabla.removeRow(fila);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // Más adelante aquí se vuelve a consultar la base de datos
        cargarDatosPrueba();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        volverDashboard();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblSesion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlLista;
    private javax.swing.JScrollPane spTabla;
    private javax.swing.JTable tbEventos;
    // End of variables declaration//GEN-END:variables
}
