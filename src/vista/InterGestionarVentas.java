package vista;

import conexion.Conexion;
import controlador.Ctrl_RegistrarVenta;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CabeceraVenta;

public class InterGestionarVentas extends javax.swing.JInternalFrame {

    private int idCliente = 0;
    private int idVenta;

    public InterGestionarVentas() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Ventas");

        //Cargar tabla
        this.CargarComboClientes();
        this.CargarTablaVentas();

        //insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        cboCliente = new javax.swing.JComboBox<>();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Ventas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblVentas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizar.setBackground(new java.awt.Color(51, 204, 0));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Total Pagar:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        txtTotalPagar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTotalPagar.setEnabled(false);
        jPanel3.add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cliente:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Estado:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFecha.setEnabled(false);
        jPanel3.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        cboCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        cboEstado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEstadoActionPerformed(evt);
            }
        });
        jPanel3.add(cboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        Ctrl_RegistrarVenta controlRegistrarVenta = new Ctrl_RegistrarVenta();
        String cliente, estado;

        cliente = cboCliente.getSelectedItem().toString().trim();
        estado = cboEstado.getSelectedItem().toString().trim();

        //Método para obtener el id del cliente
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select idCliente, concat(nombre, ' ', apellido) as cliente from tb_cliente where concat(nombre, ' ', apellido)='" + cliente + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar el id del cliente: " + e);
        }

        //Método para actualizar datos
        if (!cliente.equalsIgnoreCase("Seleccione cliente:")) {
            cabeceraVenta.setIdCliente(idCliente);

            if (estado.equalsIgnoreCase("Activo")) {
                cabeceraVenta.setEstado(1);
            } else {
                cabeceraVenta.setEstado(0);
            }

            if (controlRegistrarVenta.actualizar(cabeceraVenta, idVenta)) {
                JOptionPane.showMessageDialog(null, "¡Registro Actualizado!");
                this.CargarTablaVentas();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al actualizar!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para actualizar datos");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox<String> cboCliente;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables

    //metodo para limpiar
    private void Limpiar() {
        this.txtTotalPagar.setText("");
        this.txtFecha.setText("");
        this.cboCliente.setSelectedItem("Seleccione Cliente:");
        this.cboEstado.setSelectedItem("Activo");
        idCliente = 0;
    }

    //metodo para mostrar todos los clientes registrados
    private void CargarTablaVentas() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select cv.idCabeceraVenta as id, concat(c.nombre, ' ',c.apellido) as cliente, "
                + "cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado "
                + "from tb_cabecera_venta as cv, tb_cliente as c where cv.idCliente=c.idCliente";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarVentas.tblVentas = new JTable(model);
            InterGestionarVentas.jScrollPane1.setViewportView(InterGestionarVentas.tblVentas);

            model.addColumn("N°");//ID
            model.addColumn("Cliente");
            model.addColumn("Total Pagar");
            model.addColumn("Fecha Venta");
            model.addColumn("Estado");

            while (rs.next()) {
                Object fila[] = new Object[5];
                for (int i = 0; i < 5; i++) {
                    if (i == 4) {
                        String estado = String.valueOf(rs.getObject(i + 1));
                        if (estado.equalsIgnoreCase("1")) {
                            fila[i] = "Activo";
                        } else {
                            fila[i] = "Inactivo";
                        }
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de ventas: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        tblVentas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tblVentas.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idVenta = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosVentaSeleccionada(idVenta);//metodo
                }
            }
        });
    }

    //Metodo que envia datos seleccionados
    private void EnviarDatosVentaSeleccionada(int idVenta) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select cv.idCabeceraVenta, cv.idCliente, concat(c.nombre, ' ', c.apellido) as cliente, "
                    + "cv.valorPagar, cv.fechaVenta, cv.estado from tb_cabecera_venta as cv, "
                    + "tb_cliente as c where cv.idCabeceraVenta='" + idVenta + "' and cv.idCliente=c.idCliente");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cboCliente.setSelectedItem(rs.getString("cliente"));
                txtTotalPagar.setText(rs.getString("valorPagar"));
                txtFecha.setText(rs.getString("fechaVenta"));
                int estado = rs.getInt("estado");
                if (estado == 1) {
                    cboEstado.setSelectedItem("Activo");
                } else {
                    cboEstado.setSelectedItem("Inactivo");
                }
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al seleccionar venta: " + e);
        }
    }

    //Metodo para cargar los clientes en el jComboBox
    private void CargarComboClientes() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_cliente";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            cboCliente.removeAllItems();
            cboCliente.addItem("Seleccione cliente:");
            while (rs.next()) {
                cboCliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al cargar clientes, !" + e);
        }
    }

}
