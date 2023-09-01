package vista;

import conexion.Conexion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class InterGraficaVentas extends javax.swing.JInternalFrame {

    ArrayList<Integer> listaCantidad = new ArrayList<>();
    ArrayList<String> listaFechas = new ArrayList<>();
    int cantidadResultados = 0;
    String[] vectorFechaVenta;
    int[] vectorStatusCantidad;

    //Constructor
    public InterGraficaVentas() {
        initComponents();
        this.setSize(new Dimension(550, 650)); // para dar el tamaño al formulario
        this.setTitle("Historial de Ventas"); // para poner el título del formulario
        this.metodoContador(); //para llamar al método
        vectorFechaVenta = new String[cantidadResultados];
        vectorStatusCantidad = new int[cantidadResultados];
        this.metodoAlmacenaDatos(); //para llamar al método

    }

    //Método para determinar la cantidad de resultados a graficar
    private int metodoContador() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select fechaVenta, count(fechaVenta) as Ventas "
                    + "from tb_cabecera_venta where fechaVenta between '" + InterGraficas.fechaInicio + "'and'"
                    + InterGraficas.fechaFin + "'group by fechaVenta;");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cantidadResultados++;
            }
            cn.close(); //para cerrar la conexión
        } catch (SQLException e) {
            System.out.println("Error en: " + e);
        }
        return cantidadResultados;
    }

    //Método para almacenar en las listas los datos a graficar
    private void metodoAlmacenaDatos() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(""
                    + "select fechaVenta, count(fechaVenta) as Ventas from tb_cabecera_venta where "
                    + "fechaVenta between '" + InterGraficas.fechaInicio + "'and'" + InterGraficas.fechaFin + "'group by fechaVenta;");
            ResultSet rs = pst.executeQuery();
            int contador = 0;

            while (rs.next()) {
                vectorFechaVenta[contador] = rs.getString("fechaVenta");
                listaFechas.add(vectorFechaVenta[contador]);
                vectorStatusCantidad[contador] = rs.getInt("Ventas");
                listaCantidad.add(vectorStatusCantidad[contador]);
                contador++; //aumenta el valor de uno en uno 
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error en: " + e);
        }
    }

    //Método para determinar es el día con mayor cantidad de ventas
    public int metodoMayorVenta(ArrayList<Integer> listaCantidad) {  //retorna un valor entero
        int mayor = 0;
        for (int i = 0; i < listaCantidad.size(); i++) {
            if (listaCantidad.get(i) > mayor) {
                mayor = listaCantidad.get(i);
            }
        }
        return mayor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione fechas para graficar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 310, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    //Método para graficar las ventas
    public void paint(Graphics g) {
        super.paint(g);
        int mayorVenta = metodoMayorVenta(listaCantidad);
        int largoNuevoIngreso = 0;
        int parametro1 = 133;
        int parametroFecha = 118;
        int parametro3 = 100;

        for (int i = 0; i < listaCantidad.size(); i++) {
            largoNuevoIngreso = listaCantidad.get(i) * 400 / mayorVenta;
            if (i == 0) {
                g.setColor(new Color(140, 0, 75));  //color morado
            } else if (i == 1) {
                g.setColor(new Color(255, 0, 0));  //color rojo
            } else if (i == 2) {
                g.setColor(new Color(0, 0, 0));  //color negro
            } else if (i == 3) {
                g.setColor(new Color(255, 255, 255));  //color blanco
            } else if (i == 4) {
                g.setColor(new Color(0, 85, 0));  //color verde
            } else if (i == 5) {
                g.setColor(new Color(0, 0, 255));  //color azul
            } else if (i == 6) {
                g.setColor(new Color(255, 127, 0));  //color naranja
            } else {
                g.setColor(new Color(17, 251, 216));  //color celeste
            }
            g.fillRect(100, parametro3, largoNuevoIngreso, 40);
            g.drawString(listaFechas.get(i), 10, parametroFecha);
            g.drawString("Cantidad: " + listaCantidad.get(i), 10, parametro1);
            parametro1 += 50;
            parametroFecha += 50;
            parametro3 += 50;
        }

    }
}
