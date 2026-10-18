package com.mycompany.gestiondeeventos;

import javax.swing.JOptionPane;

/**
 * Menú Principal (Dashboard) que se abre después de un inicio de sesión exitoso.
 * Muestra u oculta los botones de los módulos según el rol del usuario autenticado.
 */
public class Dashboard extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard.class.getName());

    // Usuario que inició sesión (llega desde el Login: Menu_Principal)
    private Usuario usuario;

    public Dashboard(Usuario usuario) {
        initComponents();
        this.usuario = usuario;

        lblBienvenida.setText("Bienvenido(a), " + usuario.getNombre() + " " + usuario.getApellidos());
        lblRol.setText("Rol: " + usuario.getRol());

        configurarPorRol();

        // Se vuelve a ajustar el tamaño porque los textos cambiaron
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Lógica visual por rol: primero se ocultan todos los botones de módulos
     * y luego se muestran solamente los que el rol puede usar.
     *
     * Administrador -> Módulo 2 (Eventos) y Módulo 3 (Reservaciones)
     * Organizador   -> Módulo 2 (Eventos)
     * Cliente       -> Módulo 3 (Reservaciones)
     */
    private void configurarPorRol() {
        btnEventos.setVisible(false);
        btnReservaciones.setVisible(false);

        switch (usuario.getRol()) {
            case Administrador:
                btnEventos.setVisible(true);
                btnReservaciones.setVisible(true);
                lblPermisos.setText("Acceso total: puede gestionar eventos y reservaciones.");
                break;
            case Organizador:
                btnEventos.setVisible(true);
                lblPermisos.setText("Puede crear y administrar sus eventos.");
                break;
            case Cliente:
                btnReservaciones.setVisible(true);
                lblPermisos.setText("Puede hacer reservaciones y registrar sus pagos.");
                break;
        }
    }

    public static void main(String[] args) {
        // Solo para probar el Dashboard sin pasar por el Login.
        // Cambie Tipo.Administrador por Tipo.Organizador o Tipo.Cliente para ver cada rol.
        Usuario prueba = new Usuario(1, "Josue", "Castro", "88888888", "josue",
                "josue@correo.com", "1234", Tipo.Administrador, true);

        java.awt.EventQueue.invokeLater(() -> new Dashboard(prueba).setVisible(true));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEncabezado = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        pnlModulos = new javax.swing.JPanel();
        btnEventos = new javax.swing.JButton();
        btnReservaciones = new javax.swing.JButton();
        lblPermisos = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard - Sistema de Gestión de Eventos");


        pnlEncabezado.setBackground(new java.awt.Color(0, 102, 51));
        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Sistema de Gestión de Eventos y Reservación");
        lblBienvenida.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenida.setText("Bienvenido(a)");
        lblRol.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setText("Rol:");

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );


        pnlModulos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0)), "Módulos disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 102, 51))); // NOI18N
        btnEventos.setBackground(new java.awt.Color(51, 204, 0));
        btnEventos.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        btnEventos.setText("Módulo 2: Gestión de Eventos");
        btnEventos.addActionListener(this::btnEventosActionPerformed);
        btnReservaciones.setBackground(new java.awt.Color(51, 204, 0));
        btnReservaciones.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        btnReservaciones.setText("Módulo 3: Reservaciones y Pagos");
        btnReservaciones.addActionListener(this::btnReservacionesActionPerformed);
        lblPermisos.setFont(new java.awt.Font("Verdana", 2, 10)); // NOI18N
        lblPermisos.setForeground(new java.awt.Color(102, 102, 102));
        lblPermisos.setText("Permisos");

        javax.swing.GroupLayout pnlModulosLayout = new javax.swing.GroupLayout(pnlModulos);
        pnlModulos.setLayout(pnlModulosLayout);
        pnlModulosLayout.setHorizontalGroup(
            pnlModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModulosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEventos, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(btnReservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(lblPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        pnlModulosLayout.setVerticalGroup(
            pnlModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModulosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        btnCerrarSesion.setBackground(new java.awt.Color(204, 51, 51));
        btnCerrarSesion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(this::btnCerrarSesionActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlModulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlModulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventosActionPerformed
        ModuloEventos eventos = new ModuloEventos(this, usuario);
        eventos.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnEventosActionPerformed

    private void btnReservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservacionesActionPerformed
        ModuloReservaciones reservaciones = new ModuloReservaciones(this, usuario);
        reservaciones.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnReservacionesActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea cerrar la sesión de " + usuario.getUsuario() + "?",
                "Cerrar Sesión", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // Regresa a la pantalla de Login
            Menu_Principal login = new Menu_Principal();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEventos;
    private javax.swing.JButton btnReservaciones;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblPermisos;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlModulos;
    // End of variables declaration//GEN-END:variables
}
