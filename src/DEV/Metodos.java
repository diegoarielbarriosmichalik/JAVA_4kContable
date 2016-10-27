package DEV;

import FORM.Cuentas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos {

    public static Connection conexion = null;

    public static void Iniciar_Conexion() {
        try {
            String db = null;
            String host = null;
            String user = null;
            String pass = null;

            db = "contable";
            host = "localhost"; // Host 4k
            user = "postgres";
            pass = "postgres";

            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://" + host + ":5432/" + db, user, pass);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexion con la base de datos." + ex);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }

    public static void Cerrar_Conexion() {
        try {
            if (conexion != null) {
                conexion.close();
                System.err.println("Conexion finalizada");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Verificar_conexion() {
        try {
            if (conexion.isClosed() == false) {
                System.err.println("conexion OK");
            } else {
                System.err.println("conexion FAIL");
                Iniciar_Conexion();
                if (conexion.isClosed() == false) {
                    System.err.println("conexion reiniciada; Conexion OK");
                } else {
                    JOptionPane.showMessageDialog(null, "Error de conexion con la base de datos.");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Cuentas_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Cuentas.jTable1.getModel();
            for (int j = 0; j < Cuentas.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_cuenta,  (nv1 || '.' || nv2|| '.' || nv3|| '.' || nv4|| '.' || nv5|| ' ' || cuenta) AS cuenta  "
                    + "from cuenta "
                    + "where cuenta ilike '%" + Cuentas.jTextField_buscar.getText() + "%'");
            ResultSet rs2 = ps2.executeQuery();
            ResultSetMetaData rsm = rs2.getMetaData();
            ArrayList<Object[]> data2 = new ArrayList<>();
            while (rs2.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = rs2.getObject(i + 1).toString().trim();
                }
                data2.add(rows);
            }
            dtm = (DefaultTableModel) Cuentas.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

}
