package com.mycompany.gestiondeeventos;

import Modelos.EstadoReservacion;
import Modelos.Eventos;
import Modelos.Reservacion;
import Modelos.Usuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ModuloReservaciones extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ModuloReservaciones.class.getName());

    // Posición de las columnas de la tabla
    private static final int COL_ESTADO = 6;

    private Dashboard dashboard;
    private Usuario usuario;
    private DefaultTableModel modeloTabla;
    private DefaultTableModel modeloEventos;

    public ModuloReservaciones(Dashboard dashboard, Usuario usuario) {
        initComponents();
        this.dashboard = dashboard;
        this.usuario = usuario;

        // Al cerrar la ventana se regresa al Dashboard
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                volverDashboard();
            }
        });

        lblSesion.setText("Sesión: " + usuario.getNombre() + " (" + usuario.getRol() + ")");

        modeloTabla = (DefaultTableModel) tbReservaciones.getModel();
        tbReservaciones.setDefaultEditor(Object.class, null); // celdas no editables
        cargarEventos();
        cargarReservaciones();
        pack();
        setLocationRelativeTo(null);
    }

    public void volverDashboard() {
        if(dashboard != null){
            dashboard.setVisible(true);
        }else{
            new Menu_Principal().setVisible(true);
        }
        dispose();
    }
    // Carga los evento
    private void cargarEventos(){
        modeloEventos = Eventos.consultar(this);
        tbEventos5.setModel(modeloEventos);
        tbEventos5.setDefaultEditor(Object.class, null);
    }
    // Carga las Reservaciones
    private void cargarReservaciones(){
        modeloTabla = Reservacion.consultar(this, usuario.getId());
        tbReservaciones.setModel(modeloTabla);
        tbReservaciones.setDefaultEditor(Object.class, null);
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
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        pnlLista6 = new javax.swing.JPanel();
        spTabla6 = new javax.swing.JScrollPane();
        tbEventos5 = new javax.swing.JTable();

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
            .addComponent(spTabla)
        );
        pnlListaLayout.setVerticalGroup(
            pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaLayout.createSequentialGroup()
                .addComponent(spTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
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
                .addGap(40, 40, 40)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
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
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlLista6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0)), "Lista de Eventos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 102, 51))); // NOI18N

        tbEventos5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Fecha", "Lugar", "Precio", "Cupo Disponible", "Estado"
            }
        ));
        tbEventos5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEventos5MouseClicked(evt);
            }
        });
        spTabla6.setViewportView(tbEventos5);

        javax.swing.GroupLayout pnlLista6Layout = new javax.swing.GroupLayout(pnlLista6);
        pnlLista6.setLayout(pnlLista6Layout);
        pnlLista6Layout.setHorizontalGroup(
            pnlLista6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLista6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTabla6)
                .addContainerGap())
        );
        pnlLista6Layout.setVerticalGroup(
            pnlLista6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLista6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTabla6, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
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
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSesion))
                    .addComponent(pnlLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlLista6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(lblSesion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlLista6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaActionPerformed
        int fila = tbEventos5.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Seleccione un evento de la lista de eventos.",
                    "Nueva reservacion", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel modeloEventosActual = (DefaultTableModel) tbEventos5.getModel();
        
        try{
            int idEvento = Integer.parseInt(modeloEventosActual.getValueAt(fila, 0).toString());
            String titulo = modeloEventosActual.getValueAt(fila, 1).toString();
            String fechaEvento = modeloEventosActual.getValueAt(fila, 2).toString();
            double precio = Double.parseDouble(modeloEventosActual.getValueAt(fila, 5).toString());
            int cupoDisponible = Integer.parseInt(modeloEventosActual.getValueAt(fila, 6).toString());
            String estadoEvento = modeloEventosActual.getValueAt(fila, 7).toString();
            
            if("Cancelado".equalsIgnoreCase(estadoEvento) || "Agotado".equalsIgnoreCase(estadoEvento) || "Finalizado".equalsIgnoreCase(estadoEvento)){
                JOptionPane.showMessageDialog(this, "No se puede reservar un evento que esta agotado, cancelado o finalizado",
                        "Nueva reservacion", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if(cupoDisponible <= 0){
                JOptionPane.showMessageDialog(this, "No hay cupo disponible para este evento",
                    "Nueva reservacion", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String input = JOptionPane.showInputDialog(this,
                "Evento: " + titulo
                + "\nFecha: " + fechaEvento
                + "\nPrecio unitario: " + precio
                + "\nCupo disponible: " + cupoDisponible
                + "\n\n¿Cuántas entradas desea reservar?",
                "Nueva reservación", JOptionPane.QUESTION_MESSAGE);
            
            //Validar que no sea null
            if (input == null) {
                return;
            }
            
            
            //Validar que no sea 0 o menor
            int cantidad = Integer.parseInt(input.trim());
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad mayor a cero.",
                        "Nueva reservación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            //Validar que sea menor al cupo disponible
            if (cantidad > cupoDisponible) {
                JOptionPane.showMessageDialog(this, "La cantidad supera el cupo disponible (" + cupoDisponible + ").",
                        "Nueva reservación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Eventos eventoSeleccionado = new Eventos();
            eventoSeleccionado.setIdEvento(idEvento);
            
            double total = cantidad * precio;
            
            Reservacion nuevaReservacion = new Reservacion(
                    eventoSeleccionado,
                    usuario,
                    cantidad,
                    fechaEvento,
                    EstadoReservacion.Confirmada,
                    total      
            );
            
            String resultado = nuevaReservacion.agregar();
            JOptionPane.showMessageDialog(this, resultado);
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "INngrese numero validos de entras",
                    "Nueva reservacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNuevaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int fila = tbReservaciones.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reservación de la tabla.",
                    "Cancelar reservación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel modeloActual = (DefaultTableModel) tbReservaciones.getModel();
        String estadoActual = String.valueOf(modeloActual.getValueAt(fila, COL_ESTADO));
        
        if("Cancelada".equalsIgnoreCase(estadoActual)){
            JOptionPane.showMessageDialog(this, "Esta renovacion ya esta cancelada.",
                    "Cacnelar reservacion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea cancelar la reservación seleccionada?",
                "Cancelar reservación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            try{
                int idReservacion = Integer.parseInt(modeloActual.getValueAt(fila, 0).toString());
                
                Reservacion reservacionCancelar = new Reservacion(
                        idReservacion,
                        new Eventos(),
                        usuario,
                        1,
                        "",
                        EstadoReservacion.Cancelada,
                        0.0      
                );
                String resultado = reservacionCancelar.cancelar();
                
                JOptionPane.showMessageDialog(this, resultado,
                        "Cancelar reservacion", JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Error al cancelar la reservacion",
                        "Cancelar reservacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarEventos();
        cargarReservaciones();
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if(dashboard != null){
            dashboard.setVisible(true);
        }else{
            new Menu_Principal().setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void tbEventos5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEventos5MouseClicked

    }//GEN-LAST:event_tbEventos5MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNueva;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblSesion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlLista;
    private javax.swing.JPanel pnlLista1;
    private javax.swing.JPanel pnlLista2;
    private javax.swing.JPanel pnlLista3;
    private javax.swing.JPanel pnlLista4;
    private javax.swing.JPanel pnlLista5;
    private javax.swing.JPanel pnlLista6;
    private javax.swing.JScrollPane spTabla;
    private javax.swing.JScrollPane spTabla1;
    private javax.swing.JScrollPane spTabla2;
    private javax.swing.JScrollPane spTabla3;
    private javax.swing.JScrollPane spTabla4;
    private javax.swing.JScrollPane spTabla5;
    private javax.swing.JScrollPane spTabla6;
    private javax.swing.JTable tbEventos;
    private javax.swing.JTable tbEventos1;
    private javax.swing.JTable tbEventos2;
    private javax.swing.JTable tbEventos3;
    private javax.swing.JTable tbEventos4;
    private javax.swing.JTable tbEventos5;
    private javax.swing.JTable tbReservaciones;
    // End of variables declaration//GEN-END:variables
}
