package DEV;

import FORM.Clientes;
import FORM.Clientes_ABM;
import FORM.Compras;
import FORM.Compras_buscar_cuentas;
import FORM.Cuentas;
import FORM.Cuentas_ABM;
import FORM.Empresas_ABM;
import FORM.Empresas_buscar_clientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos {

    public static Connection conexion = null;
    public static int id_cuenta = 0;
    public static int id_cliente = 0;
    public static int empresa = 0;

    public static void Iniciar_Conexion() {
        try {
            String db = null;
            String host = null;
            String user = null;
            String pass = null;

            db = "contable";
            host = "190.104.167.162"; // Host 4k
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

    public synchronized static void Cliente_Guardar() {
        try {
            if (id_cliente == 0) {
                if ((Clientes_ABM.jTextField_nombre.getText().length() < 1)
                        || (Clientes_ABM.jTextField_ci.getText().length() < 1)
                        || (Clientes_ABM.jTextField_direccion.getText().length() < 1)
                        || (Clientes_ABM.jTextField_telefono.getText().length() < 1)
                        || (Clientes_ABM.jTextField_email.getText().length() < 1)) {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {

                    Statement st1 = conexion.createStatement();

                    ResultSet result = st1.executeQuery("SELECT MAX(id_propietario) FROM propietario");
                    if (result.next()) {
                        id_cliente = result.getInt(1) + 1;
                    }

                    PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO propietario VALUES(?,?,?,?,?,?,?)");
                    stUpdateProducto.setInt(1, id_cliente);
                    stUpdateProducto.setString(2, Clientes_ABM.jTextField_nombre.getText());
                    stUpdateProducto.setInt(3, Integer.parseInt(Clientes_ABM.jTextField_ci.getText()));
                    stUpdateProducto.setString(4, Clientes_ABM.jTextField_direccion.getText());
                    stUpdateProducto.setString(5, Clientes_ABM.jTextField_telefono.getText());
                    stUpdateProducto.setString(6, Clientes_ABM.jTextField_email.getText());
                    stUpdateProducto.setInt(7, 0);
                    stUpdateProducto.executeUpdate();

                }
//            } else if (Clientes.jDateChooser_cumpleanos.getDate() != null) {
//                java.util.Date utilDate = Clientes.jDateChooser_cumpleanos.getDate();
//                java.sql.Date cumple = new java.sql.Date(utilDate.getTime());
//                PreparedStatement st = conexion.prepareStatement(""
//                        + "UPDATE cliente "
//                        + "SET nombre ='" + jt_nombre.getText() + "', "
//                        + "direccion ='" + jt_direccion.getText() + "', "
//                        + "telefono ='" + jt_telefono.getText() + "', "
//                        + "ruc ='" + jt_ruc.getText() + "', "
//                        + "email = '" + jt_email.getText() + "', "
//                        + "cumpleanos = '" + cumple + "', "
//                        + "ci = '" + Integer.parseInt(Clientes.jTextField_ci.getText()) + "' "
//                        + "WHERE id_cliente = '" + id_cliente + "'");
//                st.executeUpdate();
////                    Clientes.jt_nombre.setEditable(false);
////                    JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
//                Clientes.jLabel_mensaje.setText("Actualizado correctamente");
//                Clientes.jLabel_mensaje.setVisible(true);
////                    Clientes.jt_nombre.requestFocus();
//
//            } else {
//                int ci = 0;
//                if (Clientes.jTextField_ci.getText().length() > 1) {
//                    ci = Integer.parseInt(Clientes.jTextField_ci.getText());
//                }
//
//                PreparedStatement st = conexion.prepareStatement(""
//                        + "UPDATE cliente "
//                        + "SET nombre ='" + jt_nombre.getText() + "', "
//                        + "direccion ='" + jt_direccion.getText() + "', "
//                        + "telefono ='" + jt_telefono.getText() + "', "
//                        + "ruc ='" + jt_ruc.getText() + "', "
//                        + "email = '" + jt_email.getText() + "', "
//                        + "ci = '" + ci + "' "
//                        + "WHERE id_cliente = '" + id_cliente + "'");
//                st.executeUpdate();
//                Clientes.jLabel_mensaje.setText("Actualizado correctamente");
//                Clientes.jLabel_mensaje.setVisible(true);
////                    Clientes.jt_nombre.requestFocus();
            }

            JOptionPane.showMessageDialog(null, "Guardado correctamente");

        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void Clientes_ABM_clear() {
        id_cliente = 0;
        Clientes_ABM.jTextField_nombre.setText("");
        Clientes_ABM.jTextField_ci.setText("");
        Clientes_ABM.jTextField_direccion.setText("");
        Clientes_ABM.jTextField_email.setText("");
        Clientes_ABM.jTextField_telefono.setText("");
        Clientes_ABM.jTextField_nombre.requestFocus();

    }

    public static void Cuentas_clear() {
        id_cuenta = 0;
        Cuentas_ABM.jTextField_nv1.setText("");
        Cuentas_ABM.jTextField_nv2.setText("");
        Cuentas_ABM.jTextField_nv3.setText("");
        Cuentas_ABM.jTextField_nv4.setText("");
        Cuentas_ABM.jTextField_nv5.setText("");
        Cuentas_ABM.jTextField_cuenta.setText("");
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

    public synchronized static void Clientes_buscar_cliente_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Clientes.jTable1.getModel();
            for (int j = 0; j < Clientes.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_propietario, nombre, ci, telefono  "
                    + "from propietario "
                    + "where nombre ilike '%" + Clientes.jTextField_buscar.getText() + "%'");
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
            dtm = (DefaultTableModel) Clientes.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Empresas_clientes_buscar_cliente_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Empresas_buscar_clientes.jTable1.getModel();
            for (int j = 0; j < Empresas_buscar_clientes.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_propietario, nombre, ci, telefono  "
                    + "from propietario "
                    + "where nombre ilike '%" + Empresas_buscar_clientes.jTextField_buscar.getText() + "%'");
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
            dtm = (DefaultTableModel) Empresas_buscar_clientes.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Compras_cuentas_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Compras_buscar_cuentas.jTable1.getModel();
            for (int j = 0; j < Compras_buscar_cuentas.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_cuenta,  (nv1 || '.' || nv2|| '.' || nv3|| '.' || nv4|| '.' || nv5|| ' ' || cuenta) AS cuenta  "
                    + "from cuenta "
                    + "where cuenta ilike '%" + Compras_buscar_cuentas.jTextField_buscar.getText() + "%'");
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
            dtm = (DefaultTableModel) Compras_buscar_cuentas.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Compras_buscar_cuentas_seleccionar_cuenta() {

        DefaultTableModel tm = (DefaultTableModel) Compras_buscar_cuentas.jTable1.getModel();
        id_cuenta = Integer.parseInt(String.valueOf(tm.getValueAt(Compras_buscar_cuentas.jTable1.getSelectedRow(), 0)));

        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM cuenta where id_cuenta = '" + id_cuenta + "'");
            if (RS.next()) {
                Compras.jTextField_cuenta.setText(RS.getString("cuenta").trim());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public synchronized static void Empresas_cliente_seleccionar() {
        DefaultTableModel tm = (DefaultTableModel) Empresas_buscar_clientes.jTable1.getModel();
        id_cliente = Integer.parseInt(String.valueOf(tm.getValueAt(Empresas_buscar_clientes.jTable1.getSelectedRow(), 0)));
        Empresas_ABM.jTextField_cliente.setText(String.valueOf(tm.getValueAt(Empresas_buscar_clientes.jTable1.getSelectedRow(), 1)));
    }

    public synchronized static void Cuentas_seleccionar() {
        DefaultTableModel tm = (DefaultTableModel) Cuentas.jTable1.getModel();
        id_cuenta = Integer.parseInt(String.valueOf(tm.getValueAt(Cuentas.jTable1.getSelectedRow(), 0)));

        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM cuenta where id_cuenta = '" + id_cuenta + "'");
            if (RS.next()) {
                Cuentas_ABM.jTextField_nv1.setText(RS.getString("nv1"));
                Cuentas_ABM.jTextField_nv2.setText(RS.getString("nv2"));
                Cuentas_ABM.jTextField_nv3.setText(RS.getString("nv3"));
                Cuentas_ABM.jTextField_nv4.setText(RS.getString("nv4"));
                Cuentas_ABM.jTextField_nv5.setText(RS.getString("nv5"));
                Cuentas_ABM.jTextField_cuenta.setText(RS.getString("cuenta").trim());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

}
