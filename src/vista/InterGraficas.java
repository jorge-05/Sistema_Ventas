package vista;

import java.awt.Dimension;
import javax.swing.JTextField;
import static vista.FrmMenu.jDesktopPane_menu;

public class InterGraficas extends javax.swing.JInternalFrame {
    
    public static String fechaInicio = "", fechaFin = "";
    
    public InterGraficas() {
        initComponents();
        this.setSize(new Dimension(450, 300));
        this.setTitle("Historial de Ventas");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGraficarVentas = new javax.swing.JButton();
        dchFechaInicio = new com.toedter.calendar.JDateChooser();
        dchFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleccione fechas para graficas las ventas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Fecha inicio:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Fecha fin:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 100, -1));

        btnGraficarVentas.setBackground(new java.awt.Color(0, 204, 204));
        btnGraficarVentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGraficarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/historial1.png"))); // NOI18N
        btnGraficarVentas.setText("Graficar Ventas");
        btnGraficarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarVentasActionPerformed(evt);
            }
        });
        getContentPane().add(btnGraficarVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 230, 50));

        dchFechaInicio.setDateFormatString("yyyy-MM-dd");
        dchFechaInicio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(dchFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 140, -1));

        dchFechaFin.setDateFormatString("yyyy-MM-dd");
        dchFechaFin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(dchFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 140, -1));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGraficarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarVentasActionPerformed
        fechaInicio = ((JTextField) dchFechaInicio.getDateEditor().getUiComponent()).getText();
        fechaFin = ((JTextField) dchFechaFin.getDateEditor().getUiComponent()).getText();
        
        InterGraficaVentas interGraficaVentas = new InterGraficaVentas();
        jDesktopPane_menu.add(interGraficaVentas);
        interGraficaVentas.setVisible(true);
    }//GEN-LAST:event_btnGraficarVentasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficarVentas;
    private com.toedter.calendar.JDateChooser dchFechaFin;
    private com.toedter.calendar.JDateChooser dchFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_wallpaper;
    // End of variables declaration//GEN-END:variables

}
