package com.mycompany.gestiondeeventos;

import Modelos.Estado;
import Modelos.Eventos;
import Modelos.Usuario;
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
    private int idEventoSeleccionado = -1;
    
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
        
        modeloTabla = Eventos.consultar(this);
        tbEventos.setModel(modeloTabla);
        tbEventos.setDefaultEditor(Object.class, null);
        
        pack();
        setLocationRelativeTo(null);
    }

    public void volverDashboard() {
        if(dashboard != null){
            dashboard.setVisible(true);
        }else {
            new Menu_Principal().setVisible(true);
        }
        dispose();
    }

    private void limpiarCampos() {
        txtTitulo.setText("");
        txtFecha.setText("DD-MM-AAAA");
        txtLugar.setText("");
        txtPrecio.setText("");
        txtCupo.setText("");
        txtOrganizador.setText("");
        txtDireccion.setText("");
        tbEventos.clearSelection();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        cboxEstado = new javax.swing.JComboBox<>();
        txtOrganizador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtLugar = new javax.swing.JTextField();
        txtCupo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();

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
        tbEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEventosMouseClicked(evt);
            }
        });
        spTabla.setViewportView(tbEventos);

        javax.swing.GroupLayout pnlListaLayout = new javax.swing.GroupLayout(pnlLista);
        pnlLista.setLayout(pnlListaLayout);
        pnlListaLayout.setHorizontalGroup(
            pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlListaLayout.setVerticalGroup(
            pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
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
                .addGap(34, 34, 34)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlAccionesLayout.setVerticalGroup(
            pnlAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 0), 2, true), "Datos del Evento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 18), new java.awt.Color(0, 102, 51))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 102, 51));
        jPanel1.setToolTipText("");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("Cupo Disponible:");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText("Fecha:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 51));
        jLabel3.setText("Lugar:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 51));
        jLabel4.setText("Precio:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 51));
        jLabel5.setText("Estado:");

        txtTitulo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        txtFecha.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtFecha.setText("DD-MM-AAAA");
        txtFecha.addActionListener(this::txtFechaActionPerformed);

        txtPrecio.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        cboxEstado.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cboxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Programado", "Agotado", "Cancelado", "Finalizado" }));

        txtOrganizador.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtOrganizador.addActionListener(this::txtOrganizadorActionPerformed);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 51));
        jLabel6.setText("Titulo:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 51));
        jLabel7.setText("Organizador:");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 51));
        jLabel8.setText("Direccion:");

        txtLugar.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtLugar.addActionListener(this::txtLugarActionPerformed);

        txtCupo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtCupo.addActionListener(this::txtCupoActionPerformed);

        txtDireccion.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtDireccion.addActionListener(this::txtDireccionActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecio)
                            .addComponent(txtTitulo)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                            .addComponent(txtLugar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cboxEstado, 0, 279, Short.MAX_VALUE)))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCupo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtOrganizador))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtDireccion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtOrganizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtDireccion))
                .addGap(21, 21, 21))
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(lblSesion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(pnlLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String titulo = txtTitulo.getText().trim();
        String fecha = txtFecha.getText().trim();
        String lugar = txtLugar.getText().trim();
        String direccion = txtDireccion.getText().trim();
        double precio = Double.parseDouble(txtPrecio.getText().trim());
        int cupoDisponible = Integer.parseInt(txtCupo.getText().trim());
        Estado estado = Estado.valueOf(cboxEstado.getSelectedItem().toString());
        String organizador = txtOrganizador.getText().trim();
        
        if(titulo.length() < 1){
            JOptionPane.showMessageDialog(this, "Debe ingresar un titulo");
            return;
        }
        
        if(lugar.length() < 1){
            JOptionPane.showMessageDialog(this, "Debe ingresar un lugar");
            return;
        }
        
        if(direccion.length() < 1){
            JOptionPane.showMessageDialog(this, "Debe ingresar un direccion");
            return;
        }
        
        if(precio < 0){
            JOptionPane.showMessageDialog(this, "El precio no puede ser negativo");
            return;
        }
        
        if(cupoDisponible < 0){
            JOptionPane.showMessageDialog(this, "El cupo disponible no puede ser negativo");
            return;
        }
        
        if(organizador.length() < 1){
            JOptionPane.showMessageDialog(this, "Debe ingresar un organizador.");
            return;
        }
        
        Eventos nuevo = new Eventos(
                titulo,
                fecha,
                lugar,
                direccion,
                precio,
                cupoDisponible,
                estado,
                organizador
              
        );
        
        String resultado = nuevo.agregar();
        JOptionPane.showMessageDialog(this, resultado);
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            if (idEventoSeleccionado == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un evento");
                return;
            }

        String titulo = txtTitulo.getText().trim();
        String fecha = txtFecha.getText().trim();
        String lugar = txtLugar.getText().trim();
        String direccion = txtDireccion.getText().trim();
        double precio = Double.parseDouble(txtPrecio.getText().trim());
        int cupoDisponible = Integer.parseInt(txtCupo.getText().trim());
        Estado estado = Estado.valueOf(cboxEstado.getSelectedItem().toString());
        String organizador = txtOrganizador.getText().trim();
        
        if(titulo.length() < 1){
            JOptionPane.showMessageDialog(this, "Debe ingresar un titulo");
            return;
        }
        
        if(lugar.length() < 1){
            JOptionPane.showMessageDialog(this, "Debe ingresar un lugar");
            return;
        }
        
        if(direccion.length() < 1){
            JOptionPane.showMessageDialog(this, "Debe ingresar un direccion");
            return;
        }
        
        if(precio < 0){
            JOptionPane.showMessageDialog(this, "El precio no puede ser negativo");
            return;
        }
        
        if(cupoDisponible < 0){
            JOptionPane.showMessageDialog(this, "El cupo disponible no puede ser negativo");
            return;
        }
        
        if(organizador.length() < 1){
            JOptionPane.showMessageDialog(this, "Debe ingresar un organizador.");
            return;
        }
        
        Eventos eventoModificado = new Eventos(
                titulo,
                fecha,
                lugar,
                direccion,
                precio,
                cupoDisponible,
                estado,
                organizador
              
        );
        
        String resultado = eventoModificado.editar();
        JOptionPane.showMessageDialog(this, resultado);
        limpiarCampos();
        
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El monto debe ser un número "
                    + "válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        
        try {
            if (idEventoSeleccionado == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un evento de la tabla para eliminar");
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de eliminar este gasto?", "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                Eventos eventosEliminar = new Eventos(idEventoSeleccionado);

                String resultado = eventosEliminar.eliminar();
                JOptionPane.showMessageDialog(null, resultado);
                limpiarCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        modeloTabla = Eventos.consultar(this);
        tbEventos.setModel(modeloTabla);
        tbEventos.setDefaultEditor(Object.class, null);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if(dashboard != null){
            dashboard.setVisible(true);
        }else{
            new Menu_Principal().setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtOrganizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrganizadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrganizadorActionPerformed

    private void txtLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLugarActionPerformed

    private void txtCupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCupoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void tbEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEventosMouseClicked
        int fila = tbEventos.getSelectedRow();
        if(fila >= 0){
            idEventoSeleccionado = Integer.parseInt(modeloTabla.getValueAt(fila, 0).toString());
            txtTitulo.setText(modeloTabla.getValueAt(fila, 1).toString());
            txtFecha.setText(modeloTabla.getValueAt(fila, 2).toString());
            txtLugar.setText(modeloTabla.getValueAt(fila, 3).toString());
            
            if(modeloTabla.getColumnCount() >= 9){
                txtDireccion.setText(modeloTabla.getValueAt(fila, 4).toString());
                txtPrecio.setText(modeloTabla.getValueAt(fila, 5).toString());
                txtCupo.setText(modeloTabla.getValueAt(fila, 6).toString());
                cboxEstado.setSelectedItem(Estado.valueOf(modeloTabla.getValueAt(fila, 7).toString()));
                txtOrganizador.setText(modeloTabla.getValueAt(fila, 8).toString());
            }else {
                txtPrecio.setText(modeloTabla.getValueAt(fila, 5).toString());
                txtCupo.setText(modeloTabla.getValueAt(fila, 6).toString());
                cboxEstado.setSelectedItem(Estado.valueOf(modeloTabla.getValueAt(fila, 7).toString()));
            }
        }
    }//GEN-LAST:event_tbEventosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cboxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSesion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlLista;
    private javax.swing.JScrollPane spTabla;
    private javax.swing.JTable tbEventos;
    private javax.swing.JTextField txtCupo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtOrganizador;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
