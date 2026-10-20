package com.mycompany.gestiondeeventos;



import javax.swing.JOptionPane;
public class Menu_Principal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.
            logging.Logger.getLogger(Menu_Principal.class.getName());
    public Menu_Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Menu_Principal().setVisible(true);
        });
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PInicioSesion = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        lblNombreU = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        btInicioSesión = new javax.swing.JButton();
        cbRecordarmeU = new javax.swing.JCheckBox();
        lblOlvidoContraseña = new javax.swing.JLabel();
        lblNotieneC = new javax.swing.JLabel();
        lblRegistrarse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PInicioSesion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0)), "Inicio de Sesión", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 102, 51))); // NOI18N
        PInicioSesion.setForeground(new java.awt.Color(0, 51, 0));

        lblNombreU.setBackground(new java.awt.Color(255, 255, 255));
        lblNombreU.setFont(new java.awt.Font("Verdana", 2, 10)); // NOI18N
        lblNombreU.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreU.setText("Nombre de Ususario:");
        lblNombreU.setToolTipText("");

        lblContraseña.setBackground(new java.awt.Color(255, 255, 255));
        lblContraseña.setFont(new java.awt.Font("Verdana", 2, 10)); // NOI18N
        lblContraseña.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblContraseña.setText("Contraseña:");
        lblContraseña.setToolTipText("");

        btInicioSesión.setBackground(new java.awt.Color(51, 204, 0));
        btInicioSesión.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btInicioSesión.setText("Iniciar Sesión");
        btInicioSesión.addActionListener(this::btInicioSesiónActionPerformed);

        cbRecordarmeU.setFont(new java.awt.Font("Verdana", 2, 10)); // NOI18N
        cbRecordarmeU.setText("Recordarme");
        cbRecordarmeU.addActionListener(this::cbRecordarmeUActionPerformed);

        lblOlvidoContraseña.setFont(new java.awt.Font("Verdana", 2, 10)); // NOI18N
        lblOlvidoContraseña.setForeground(new java.awt.Color(102, 102, 102));
        lblOlvidoContraseña.setText("¿Olvidaste tu contraseña?");
        lblOlvidoContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOlvidoContraseñaMouseClicked(evt);
            }
        });

        lblNotieneC.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        lblNotieneC.setText("¿No tienes una cuenta?");

        lblRegistrarse.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        lblRegistrarse.setForeground(new java.awt.Color(0, 204, 51));
        lblRegistrarse.setText("Registrarse");
        lblRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistrarseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PInicioSesionLayout = new javax.swing.GroupLayout(PInicioSesion);
        PInicioSesion.setLayout(PInicioSesionLayout);
        PInicioSesionLayout.setHorizontalGroup(
            PInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInicioSesionLayout.createSequentialGroup()
                .addGroup(PInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PInicioSesionLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(btInicioSesión, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PInicioSesionLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(PInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PInicioSesionLayout.createSequentialGroup()
                                .addComponent(cbRecordarmeU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblOlvidoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PInicioSesionLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(lblNotieneC, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRegistrarse))
                            .addComponent(lblContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsuario)
                            .addComponent(txtContraseña)
                            .addComponent(lblNombreU, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        PInicioSesionLayout.setVerticalGroup(
            PInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInicioSesionLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblNombreU)
                .addGap(18, 18, 18)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContraseña)
                .addGap(18, 18, 18)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRecordarmeU)
                    .addComponent(lblOlvidoContraseña))
                .addGap(18, 18, 18)
                .addComponent(btInicioSesión)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNotieneC)
                    .addComponent(lblRegistrarse))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbRecordarmeUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRecordarmeUActionPerformed
        // Se configuro en el otro avance
    }//GEN-LAST:event_cbRecordarmeUActionPerformed

    private void btInicioSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInicioSesiónActionPerformed
        //Obtener la informacion de usuario y contraseña
        String usuario = txtUsuario.getText().trim();
        String contraseña = new String(txtContraseña.getPassword());
        
        //Validar si los campos estan vacios
        if (usuario.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos "
                    + "los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  
        }
        
        //Espacio para la conexion con base de datos
        
        Usuario u = BaseDatos.validarLogin(usuario, contraseña);
        
        if(u != null){
            new Dashboard(u).setVisible(true);
            this.dispose();
            // Se abre la interfaz principal segun el rol del usuario
        }
        else{
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
   
        
    }//GEN-LAST:event_btInicioSesiónActionPerformed

    private void lblRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarseMouseClicked
        Menu_Registro registro = new Menu_Registro();
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblRegistrarseMouseClicked

    private void lblOlvidoContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOlvidoContraseñaMouseClicked
        // Se modifica cuando este la base de datos
    }//GEN-LAST:event_lblOlvidoContraseñaMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PInicioSesion;
    private javax.swing.JButton btInicioSesión;
    private javax.swing.JCheckBox cbRecordarmeU;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblNombreU;
    private javax.swing.JLabel lblNotieneC;
    private javax.swing.JLabel lblOlvidoContraseña;
    private javax.swing.JLabel lblRegistrarse;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
