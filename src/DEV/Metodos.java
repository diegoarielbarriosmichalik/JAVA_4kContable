package DEV;

import FORM.Clientes;
import FORM.Clientes_ABM;
import FORM.Compras;
import FORM.Compras_agregar_detalle;
import FORM.Compras_buscar_cuentas;
import FORM.Compras_detalle_modificar;
import FORM.Compras_proveedores_buscar;
import FORM.Comprobante;
import FORM.Condicion;
import FORM.Cuentas;
import FORM.Cuentas_ABM;
import FORM.Cuentas_asociadas;
import FORM.Cuentas_asociadas_agregar_detalle;
import FORM.Cuentas_asociadas_agregar_detalle_buscar_cuenta;
import FORM.Empresas;
import FORM.Empresas_ABM;
import FORM.Empresas_buscar_clientes;
import FORM.Factura_compra_detalle_modificar_cuentas_buscar;
import FORM.Factura_venta_detalle_modificar_cuentas_buscar;
import FORM.Moneda;
import FORM.Parametros;
import FORM.Parametros_buscar_cuentas;
import FORM.Proveedores_ABM;
import FORM.Seleccionar_empresa;
import FORM.Sucursal_ABM;
import FORM.Sucursal_empresas_buscar;
import FORM.Ventas;
import FORM.Ventas_agregar_detalle;
import FORM.Ventas_buscar_cuentas;
import FORM.Ventas_detalle_modificar;
import FORM.Ventas_proveedores_buscar;
import FORM.Ventas_sucursal_buscar;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Metodos {

    public static Connection conexion = null;
    public static int id_cuenta = 0;
    public static int id_cuenta_asociada = 0;
    public static int id_cuenta_asociada_max = 0;
    public static int id_factura = 0;
    public static int id_factura_de_venta = 0;
    public static int id_cuenta_iva_10 = 0;
    public static int id_cuenta_iva_5 = 0;
    public static int id_cuenta_exentas = 0;
    public static int id_cuenta_caja = 0;
    public static int id_cliente = 0;
    public static int cuenta_iva_10 = 0;
    public static int form_compra = 0;
    public static int cuenta_caja = 0;
    public static int cuenta_iva_5 = 0;
    public static int cuenta_exentas = 0;
    public static String cuenta_iva_10_str = null;
    public static int id_proveedor = 0;
    public static int id_timbrado = 0;
    public static int id_condicion = 0;
    public static int id_comprobante = 0;
    public static int id_moneda = 0;
    public static int id_empresa = 0;
    public static int id = 0;
    public static int id_factura_detalle = 0;
    public static int empresa = 0;
    public static int form_venta = 0;
    public static int id_sucursal = 0;
    public static String empresa_razon_social = "Selecciona una empresa...";
    public static String cuenta = null;
    public static boolean existe = false;
    public static int cuenta_gravada_10 = 0;
    public static int cuenta_parametros = 0;
    public static int form_libro_compra = 0;
    public static boolean enter_press = false;

    public synchronized static void Iniciar_Conexion() {
        try {
            String db = null;
            String host = null;
            String user = null;
            String pass = null;

            db = "contable";
//            host = "190.104.167.162"; // Host 4k
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

    public synchronized static void Compras_detalle_modificar_borrar() {
        try {
            PreparedStatement stUpdateAuxiliar2 = conexion.prepareStatement(""
                    + "delete from factura_detalle WHERE id_factura_detalle ='" + id_factura_detalle + "'");
            stUpdateAuxiliar2.executeUpdate();
            Facturas_de_compra_buscar();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Ventas_detalle_modificar_borrar() {
        try {
            PreparedStatement stUpdateAuxiliar2 = conexion.prepareStatement(""
                    + "delete from factura_detalle WHERE id_factura_detalle ='" + id_factura_detalle + "'");
            stUpdateAuxiliar2.executeUpdate();
            Facturas_de_venta_buscar();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Libro_de_compras_print() {
        try {

            Statement ST = conexion.createStatement();
            ST.executeUpdate("truncate table reporte_libro_de_compras");

//            Statement st12 = conexion.createStatement();
//            ResultSet result12 = st12.executeQuery("SELECT * FROM cuenta order by nv1, nv2, nv3, nv4,nv5, cuenta");
//            while (result12.next()) {
            Statement st122 = conexion.createStatement();
            ResultSet result122 = st122.executeQuery(""
                    + "SELECT  distinct(factura.id_factura), nombre, ruc, descripcion FROM factura "
                    + "inner join proveedor on proveedor.id_proveedor = factura.id_proveedor "
                    + "where compra = '1' "
                    + "and factura.id_empresa = '" + empresa + "'");
            while (result122.next()) {

                long g_10 = 0;
                long i_10 = 0;
                long g_5 = 0;
                long i_5 = 0;
                long ex = 0;

                Statement st1222 = conexion.createStatement();
                ResultSet result1222 = st1222.executeQuery(""
                        + "SELECT  * FROM factura_detalle "
                        + "where id_factura = '" + result122.getInt("id_factura") + "'");
                while (result1222.next()) {
                    i_10 = result1222.getLong("iva_10") + i_10;
                    i_5 = result1222.getLong("iva_5") + i_5;
                    g_10 = result1222.getLong("gravada_10") + g_10;
                    g_5 = result1222.getLong("gravada_5") + g_5;
                    ex = result1222.getLong("exentas") + ex;
                }
//                    if (g_10 > 0) {

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_reporte_libro_de_compras) FROM reporte_libro_de_compras");
                if (result.next()) {
                    id = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO reporte_libro_de_compras VALUES(?,?,?,?,?, ?,?,?,?,?)");
                stUpdateProducto.setInt(1, id);
                stUpdateProducto.setString(2, result122.getString("nombre"));
                stUpdateProducto.setString(3, result122.getString("ruc"));
                stUpdateProducto.setString(4, result122.getString("descripcion"));
                stUpdateProducto.setLong(5, g_10);
                stUpdateProducto.setLong(6, i_10);
                stUpdateProducto.setLong(7, g_5);
                stUpdateProducto.setLong(8, i_5);
                stUpdateProducto.setLong(9, ex);
                stUpdateProducto.setLong(10, g_10 + g_5 + i_10 + i_5 + ex);
                stUpdateProducto.executeUpdate();
//                    }

            }
//            }

            String ubicacion_proyecto = new File("").getAbsolutePath();
            String path = ubicacion_proyecto + "\\reports\\libro_de_compras.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException | SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
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

                    ResultSet result = st1.executeQuery("SELECT MAX(id_cliente) FROM cliente");
                    if (result.next()) {
                        id_cliente = result.getInt(1) + 1;
                    }

                    PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO cliente VALUES(?,?,?,?,?,?,?)");
                    stUpdateProducto.setInt(1, id_cliente);
                    stUpdateProducto.setString(2, Clientes_ABM.jTextField_nombre.getText());
                    stUpdateProducto.setInt(3, Integer.parseInt(Clientes_ABM.jTextField_ci.getText()));
                    stUpdateProducto.setString(4, Clientes_ABM.jTextField_direccion.getText());
                    stUpdateProducto.setString(5, Clientes_ABM.jTextField_telefono.getText());
                    stUpdateProducto.setString(6, Clientes_ABM.jTextField_email.getText());
                    stUpdateProducto.setInt(7, 0);
                    stUpdateProducto.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Guardado correctamente");

                }
            } else if ((Clientes_ABM.jTextField_nombre.getText().length() < 1)
                    || (Clientes_ABM.jTextField_ci.getText().length() < 1)
                    || (Clientes_ABM.jTextField_direccion.getText().length() < 1)
                    || (Clientes_ABM.jTextField_telefono.getText().length() < 1)
                    || (Clientes_ABM.jTextField_email.getText().length() < 1)) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            } else {

                PreparedStatement st = conexion.prepareStatement(""
                        + "UPDATE cliente "
                        + "SET nombre = '" + Clientes_ABM.jTextField_nombre.getText() + "', "
                        + "ci = '" + Clientes_ABM.jTextField_ci.getText() + "', "
                        + "direccion = '" + Clientes_ABM.jTextField_direccion.getText() + "', "
                        + "email = '" + Clientes_ABM.jTextField_email.getText() + "', "
                        + "telefono = '" + Clientes_ABM.jTextField_telefono.getText() + "' "
                        + "where id_cliente = '" + id_cliente + "'");
                st.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }

        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public synchronized static void Sucursal_guardar() {
        try {
            if ((Sucursal_ABM.jTextField_empresa.getText().length() < 1)
                    || (id_empresa < 1)) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            } else {
                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_sucursal) FROM sucursal");
                if (result.next()) {
                    id = result.getInt(1) + 1;
                }
                PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO sucursal VALUES(?,?,?,?)");
                stUpdateProducto.setInt(1, id);
                stUpdateProducto.setString(2, Sucursal_ABM.jTextField_sucursal.getText().trim());
                stUpdateProducto.setInt(3, id_empresa);
                stUpdateProducto.setInt(4, 0);
                stUpdateProducto.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public synchronized static void Parametros_buscar() {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT * FROM parametro");
            if (result.next()) {
                int id_cuenta_iva_10 = result.getInt("cuenta_iva_10");
                int id_cuenta_iva_5 = result.getInt("cuenta_iva_5");
                int id_cuenta_caja = result.getInt("cuenta_caja");
                int id_cuenta_exentas = result.getInt("cuenta_exentas");
                Statement st2 = conexion.createStatement();
                ResultSet result2 = st2.executeQuery("SELECT * FROM cuenta where id_cuenta = '" + id_cuenta_iva_10 + "'");
                if (result2.next()) {
                    Parametros.jTextField_iva_10.setText(result2.getString("cuenta"));
                }
                ResultSet result3 = st2.executeQuery("SELECT * FROM cuenta where id_cuenta = '" + id_cuenta_caja + "'");
                if (result3.next()) {
                    Parametros.jTextField_caja.setText(result3.getString("cuenta"));
                }
                ResultSet result4 = st2.executeQuery("SELECT * FROM cuenta where id_cuenta = '" + id_cuenta_iva_5 + "'");
                if (result4.next()) {
                    Parametros.jTextField_iva_5.setText(result4.getString("cuenta").trim());
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Compras_detalle_guardar() {
        try {

            long gravada_10 = 0;
            long iva_10 = 0;
            long iva_5 = 0;
            long gravada_5 = 0;
            long exentas = 0;

            if (Compras_agregar_detalle.jTextField_gravadas10.getText().length() > 0) {
                gravada_10 = Long.valueOf(Compras_agregar_detalle.jTextField_gravadas10.getText().replace(".", ""));
            }
            if (Compras_agregar_detalle.jTextField_iva10.getText().length() > 0) {
                iva_10 = Long.valueOf(Compras_agregar_detalle.jTextField_iva10.getText().replace(".", ""));
            }
            if (Compras_agregar_detalle.jTextField_iva5.getText().length() > 0) {
                iva_5 = Long.valueOf(Compras_agregar_detalle.jTextField_iva5.getText().replace(".", ""));
            }
            if (Compras_agregar_detalle.jTextField_gravadas_5.getText().length() > 0) {
                gravada_5 = Long.valueOf(Compras_agregar_detalle.jTextField_gravadas_5.getText().replace(".", ""));
            }
            if (Compras_agregar_detalle.jTextField_exentas.getText().length() > 0) {
                exentas = Long.valueOf(Compras_agregar_detalle.jTextField_exentas.getText().replace(".", ""));
            }

            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_factura_detalle) FROM factura_detalle");
            if (result.next()) {
                id_factura_detalle = result.getInt(1);
            }

            Statement st123 = conexion.createStatement();
            ResultSet result23 = st123.executeQuery("select * from parametro ");
            if (result23.next()) {
                id_cuenta_iva_10 = result23.getInt("cuenta_iva_10");
                id_cuenta_iva_5 = result23.getInt("cuenta_iva_5");
                id_cuenta_exentas = result23.getInt("cuenta_exentas");
                id_cuenta_caja = result23.getInt("cuenta_caja");
            }

            if (gravada_10 > 0) {
                id_factura_detalle++;
                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO factura_detalle VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_factura_detalle);
                stUpdateProducto.setInt(2, id_cuenta);
                stUpdateProducto.setLong(3, gravada_10);
                stUpdateProducto.setLong(4, 0);
                stUpdateProducto.setInt(5, 1);
                stUpdateProducto.setInt(6, 1);
                stUpdateProducto.setInt(7, 1);
                stUpdateProducto.setInt(8, id_factura);
                stUpdateProducto.setLong(9, gravada_10);
                stUpdateProducto.setLong(10, 0);
                stUpdateProducto.setLong(11, 0);
                stUpdateProducto.setLong(12, 0);
                stUpdateProducto.setLong(13, 0);
                stUpdateProducto.executeUpdate();

                id_factura_detalle++;
                PreparedStatement stUpdateProducto2 = conexion.prepareStatement(""
                        + "INSERT INTO factura_detalle VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                stUpdateProducto2.setInt(1, id_factura_detalle);
                stUpdateProducto2.setInt(2, id_cuenta_iva_10);
                stUpdateProducto2.setLong(3, iva_10);
                stUpdateProducto2.setLong(4, 0);
                stUpdateProducto2.setInt(5, 1);
                stUpdateProducto2.setInt(6, 1);
                stUpdateProducto2.setInt(7, 1);
                stUpdateProducto2.setInt(8, id_factura);
                stUpdateProducto2.setLong(9, 0);
                stUpdateProducto2.setLong(10, 0);
                stUpdateProducto2.setLong(11, iva_10);
                stUpdateProducto2.setLong(12, 0);
                stUpdateProducto2.setLong(13, 0);
                stUpdateProducto2.executeUpdate();

            }
            if (gravada_5 > 0) {

                id_factura_detalle++;
                PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO factura_detalle VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_factura_detalle);
                stUpdateProducto.setInt(2, id_cuenta);
                stUpdateProducto.setLong(3, gravada_5);
                stUpdateProducto.setLong(4, 0);
                stUpdateProducto.setInt(5, 1);
                stUpdateProducto.setInt(6, 2);
                stUpdateProducto.setInt(7, 1);
                stUpdateProducto.setInt(8, id_factura);
                stUpdateProducto.setLong(9, 0);
                stUpdateProducto.setLong(10, gravada_5);
                stUpdateProducto.setLong(11, 0);
                stUpdateProducto.setLong(12, 0);
                stUpdateProducto.setLong(13, 0);
                stUpdateProducto.executeUpdate();

                id_factura_detalle++;
                PreparedStatement stUpdateProducto23 = conexion.prepareStatement("INSERT INTO factura_detalle VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                stUpdateProducto23.setInt(1, id_factura_detalle);
                stUpdateProducto23.setInt(2, id_cuenta_iva_5);
                stUpdateProducto23.setLong(3, iva_5);
                stUpdateProducto23.setLong(4, 0);
                stUpdateProducto23.setInt(5, 1);
                stUpdateProducto23.setInt(6, 2);
                stUpdateProducto23.setInt(7, 1);
                stUpdateProducto23.setInt(8, id_factura);
                stUpdateProducto23.setLong(9, 0);
                stUpdateProducto23.setLong(10, 0);
                stUpdateProducto23.setLong(11, 0);
                stUpdateProducto23.setLong(12, iva_5);
                stUpdateProducto23.setLong(13, 0);
                stUpdateProducto23.executeUpdate();

            }
            if (exentas > 0) {

                id_factura_detalle++;
                PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO factura_detalle VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_factura_detalle);
                stUpdateProducto.setInt(2, id_cuenta);
                stUpdateProducto.setLong(3, exentas);
                stUpdateProducto.setLong(4, 0);
                stUpdateProducto.setInt(5, 1);
                stUpdateProducto.setInt(6, 3);
                stUpdateProducto.setInt(7, 1);
                stUpdateProducto.setInt(8, id_factura);
                stUpdateProducto.setLong(9, 0);
                stUpdateProducto.setLong(10, 0);
                stUpdateProducto.setLong(11, 0);
                stUpdateProducto.setLong(12, 0);
                stUpdateProducto.setLong(13, exentas);
                stUpdateProducto.executeUpdate();
            }

            long total = Long.valueOf(Compras_agregar_detalle.jTextField_total.getText().replace(".", ""));
            id_factura_detalle++;
            PreparedStatement stUpdateProducto2 = conexion.prepareStatement("INSERT INTO factura_detalle VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stUpdateProducto2.setInt(1, id_factura_detalle);
            stUpdateProducto2.setInt(2, id_cuenta_caja);
            stUpdateProducto2.setLong(3, 0);
            stUpdateProducto2.setLong(4, total);
            stUpdateProducto2.setInt(5, 0);
            stUpdateProducto2.setInt(6, 0);
            stUpdateProducto2.setInt(7, 0);
            stUpdateProducto2.setInt(8, id_factura);
            stUpdateProducto2.setLong(9, 0);
            stUpdateProducto2.setLong(10, 0);
            stUpdateProducto2.setLong(11, 0);
            stUpdateProducto2.setLong(12, 0);
            stUpdateProducto2.setLong(13, 0);
            stUpdateProducto2.executeUpdate();

            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE factura "
                    + "SET total_debe = '" + total + "', "
                    + "total_haber = '" + total + "' "
                    + "where id_factura = '" + id_factura + "'");
            st.executeUpdate();
            Facturas_de_compra_buscar();
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public synchronized static void Ventas_detalle_guardar() {
        try {

            long gravada_10 = 0;
            long iva_10 = 0;
            long iva_5 = 0;
            long gravada_5 = 0;
            long exentas = 0;

            if (Ventas_agregar_detalle.jTextField_gravadas10.getText().length() > 0) {
                gravada_10 = Long.valueOf(Ventas_agregar_detalle.jTextField_gravadas10.getText().replace(".", ""));
            }
            if (Ventas_agregar_detalle.jTextField_iva10.getText().length() > 0) {
                iva_10 = Long.valueOf(Ventas_agregar_detalle.jTextField_iva10.getText().replace(".", ""));
            }
            if (Ventas_agregar_detalle.jTextField_iva5.getText().length() > 0) {
                iva_5 = Long.valueOf(Ventas_agregar_detalle.jTextField_iva5.getText().replace(".", ""));
            }
            if (Ventas_agregar_detalle.jTextField_gravadas_5.getText().length() > 0) {
                gravada_5 = Long.valueOf(Ventas_agregar_detalle.jTextField_gravadas_5.getText().replace(".", ""));
            }
            if (Ventas_agregar_detalle.jTextField_exentas.getText().length() > 0) {
                exentas = Long.valueOf(Ventas_agregar_detalle.jTextField_exentas.getText().replace(".", ""));
            }

            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_factura_detalle) FROM factura_detalle");
            if (result.next()) {
                id_factura_detalle = result.getInt(1);
            }

            Statement st123 = conexion.createStatement();
            ResultSet result23 = st123.executeQuery("select * from parametro ");
            if (result23.next()) {
                id_cuenta_iva_10 = result23.getInt("cuenta_iva_10");
                id_cuenta_iva_5 = result23.getInt("cuenta_iva_5");
                id_cuenta_exentas = result23.getInt("cuenta_exentas");
                id_cuenta_caja = result23.getInt("cuenta_caja");
            }

            if (gravada_10 > 0) {
                id_factura_detalle++;
                PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO factura_detalle VALUES(?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_factura_detalle);
                stUpdateProducto.setInt(2, id_cuenta);
                stUpdateProducto.setLong(3, gravada_10);
                stUpdateProducto.setLong(4, 0);
                stUpdateProducto.setInt(5, 1);
                stUpdateProducto.setInt(6, 1);
                stUpdateProducto.setInt(7, 1);
                stUpdateProducto.setInt(8, id_factura);
                stUpdateProducto.executeUpdate();

                id_factura_detalle++;
                PreparedStatement stUpdateProducto2 = conexion.prepareStatement("INSERT INTO factura_detalle VALUES(?,?,?,?,?,?,?,?)");
                stUpdateProducto2.setInt(1, id_factura_detalle);
                stUpdateProducto2.setInt(2, id_cuenta_iva_10);
                stUpdateProducto2.setLong(3, iva_10);
                stUpdateProducto2.setLong(4, 0);
                stUpdateProducto2.setInt(5, 1);
                stUpdateProducto2.setInt(6, 1);
                stUpdateProducto2.setInt(7, 1);
                stUpdateProducto2.setInt(8, id_factura);
                stUpdateProducto2.executeUpdate();

            }
            if (gravada_5 > 0) {

                id_factura_detalle++;
                PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO factura_detalle VALUES(?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_factura_detalle);
                stUpdateProducto.setInt(2, id_cuenta);
                stUpdateProducto.setLong(3, gravada_5);
                stUpdateProducto.setLong(4, 0);
                stUpdateProducto.setInt(5, 1);
                stUpdateProducto.setInt(6, 2);
                stUpdateProducto.setInt(7, 1);
                stUpdateProducto.setInt(8, id_factura);
                stUpdateProducto.executeUpdate();

                id_factura_detalle++;
                PreparedStatement stUpdateProducto23 = conexion.prepareStatement("INSERT INTO factura_detalle VALUES(?,?,?,?,?,?,?,?)");
                stUpdateProducto23.setInt(1, id_factura_detalle);
                stUpdateProducto23.setInt(2, id_cuenta_iva_5);
                stUpdateProducto23.setLong(3, iva_5);
                stUpdateProducto23.setLong(4, 0);
                stUpdateProducto23.setInt(5, 1);
                stUpdateProducto23.setInt(6, 2);
                stUpdateProducto23.setInt(7, 1);
                stUpdateProducto23.setInt(8, id_factura);
                stUpdateProducto23.executeUpdate();

            }
            if (exentas > 0) {

                id_factura_detalle++;
                PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO factura_detalle VALUES(?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_factura_detalle);
                stUpdateProducto.setInt(2, id_cuenta);
                stUpdateProducto.setLong(3, exentas);
                stUpdateProducto.setLong(4, 0);
                stUpdateProducto.setInt(5, 1);
                stUpdateProducto.setInt(6, 3);
                stUpdateProducto.setInt(7, 1);
                stUpdateProducto.setInt(8, id_factura);
                stUpdateProducto.executeUpdate();
            }

            long total = Long.valueOf(Ventas_agregar_detalle.jTextField_total.getText().replace(".", ""));
            id_factura_detalle++;
            PreparedStatement stUpdateProducto2 = conexion.prepareStatement("INSERT INTO factura_detalle VALUES(?,?,?,?,?,?,?,?)");
            stUpdateProducto2.setInt(1, id_factura_detalle);
            stUpdateProducto2.setInt(2, id_cuenta_caja);
            stUpdateProducto2.setLong(3, 0);
            stUpdateProducto2.setLong(4, total);
            stUpdateProducto2.setInt(5, 0);
            stUpdateProducto2.setInt(6, 0);
            stUpdateProducto2.setInt(7, 0);
            stUpdateProducto2.setInt(8, id_factura);
            stUpdateProducto2.executeUpdate();

            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE factura "
                    + "SET total_debe = '" + total + "', "
                    + "total_haber = '" + total + "' "
                    + "where id_factura = '" + id_factura + "'");
            st.executeUpdate();
            Facturas_de_venta_buscar();
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public synchronized static void Compras_actualizar_fecha() {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE factura "
                    + "SET fecha ='" + util_Date_to_sql_date(Compras.jDateChooser_fecha.getDate()) + "', "
                    + "descripcion ='" + Compras.jTextField_descripcion.getText() + "' "
                    + "WHERE id_factura = '" + id_factura + "'");
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Ventas_actualizar_fecha_descripcion() {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE factura "
                    + "SET fecha ='" + util_Date_to_sql_date(Ventas.jDateChooser_fecha.getDate()) + "', "
                    + "descripcion ='" + Ventas.jTextField_descripcion.getText() + "' "
                    + "WHERE id_factura = '" + id_factura + "'");
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Ventas_actualizar_sucursal() {
        try {
            if (id_factura > 0) {
                PreparedStatement st = conexion.prepareStatement(""
                        + "UPDATE factura "
                        + "SET id_sucursal ='" + id_sucursal + "' "
                        + "WHERE id_factura = '" + id_factura + "'");
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Parametros_cuenta_iva_10_update() {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE parametro "
                    + "SET cuenta_iva_10 = '" + cuenta_iva_10 + "' ");
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Parametros_caja_update() {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE parametro "
                    + "SET cuenta_caja = '" + cuenta_caja + "' ");
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Parametros_iva_5_update() {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE parametro "
                    + "SET cuenta_iva_5 = '" + cuenta_iva_5 + "' ");
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Parametros_exentas_update() {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE parametro "
                    + "SET cuenta_exentas = '" + cuenta_exentas + "' ");
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static java.sql.Date util_Date_to_sql_date(Date fecha) {
        java.sql.Date fecha_sql_date = null;
        if (fecha != null) {
            java.util.Date utilDate = fecha;
            fecha_sql_date = new java.sql.Date(utilDate.getTime());
        }
        return fecha_sql_date;
    }

    public synchronized static void Factura_de_compra_guardar() {
        try {

            existe = false;
            Statement st4 = conexion.createStatement();
            ResultSet result4 = st4.executeQuery("SELECT * FROM factura "
                    + "where id_proveedor = '" + id_proveedor + "' "
                    + "and factura_sucursal = '" + Compras.jTextField_fac_sucursal.getText() + "' "
                    + "and factura_caja = '" + Compras.jTextField_fac_caja.getText() + "' "
                    + "and factura_numero = '" + Compras.jTextField_fac_numero.getText() + "' "
                    + "and borrado != '1' "
                    + "and id_empresa = '" + empresa + "' "
                    + "and compra != '1' ");
            if (result4.next()) {
                existe = true;
            }

            if (existe == false) {

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_factura) FROM factura");
                if (result.next()) {
                    id_factura = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO factura VALUES(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)");
                stUpdateProducto.setInt(1, id_factura);
                stUpdateProducto.setLong(2, Long.parseLong(Compras.jTextField_fac_sucursal.getText()));
                stUpdateProducto.setLong(3, Long.parseLong(Compras.jTextField_fac_caja.getText()));
                stUpdateProducto.setLong(4, Long.parseLong(Compras.jTextField_fac_numero.getText()));
                stUpdateProducto.setDate(5, null);
                stUpdateProducto.setString(6, Compras.jTextField_descripcion.getText());
                stUpdateProducto.setInt(7, empresa);
                stUpdateProducto.setInt(8, id_proveedor);
                stUpdateProducto.setInt(9, id_condicion);
                stUpdateProducto.setInt(10, id_moneda);
                stUpdateProducto.setInt(11, id_comprobante);
                stUpdateProducto.setInt(12, 0);
                stUpdateProducto.setInt(13, 0);
                stUpdateProducto.setInt(14, 0);
                stUpdateProducto.setInt(15, 0);
                stUpdateProducto.setInt(16, 0);
                stUpdateProducto.setInt(17, 0);
                stUpdateProducto.setInt(18, 0);
                stUpdateProducto.setInt(19, 1);
                stUpdateProducto.setInt(20, 0);
                stUpdateProducto.setInt(21, id_sucursal);
                stUpdateProducto.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "Factura de compra duplicada");
                Compras.jTextField_fac_numero.requestFocus();
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public synchronized static void Factura_de_venta_guardar() {
        try {

            existe = false;
            Statement st4 = conexion.createStatement();
            ResultSet result4 = st4.executeQuery("SELECT * FROM factura "
                    + "where id_proveedor = '" + id_proveedor + "' "
                    + "and factura_sucursal = '" + Ventas.jTextField_fac_sucursal.getText() + "' "
                    + "and factura_caja = '" + Ventas.jTextField_fac_caja.getText() + "' "
                    + "and factura_numero = '" + Ventas.jTextField_fac_numero.getText() + "' "
                    + "and borrado != '1' "
                    + "and id_empresa = '" + empresa + "' "
                    + "and venta != '1'");
            if (result4.next()) {
                existe = true;
            }

            if (existe == false) {

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_factura) FROM factura");
                if (result.next()) {
                    id_factura = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO factura VALUES(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ? )");
                stUpdateProducto.setInt(1, id_factura);
                stUpdateProducto.setLong(2, Long.parseLong(Ventas.jTextField_fac_sucursal.getText()));
                stUpdateProducto.setLong(3, Long.parseLong(Ventas.jTextField_fac_caja.getText()));
                stUpdateProducto.setLong(4, Long.parseLong(Ventas.jTextField_fac_numero.getText()));
                stUpdateProducto.setDate(5, null);
                stUpdateProducto.setString(6, "");
                stUpdateProducto.setInt(7, empresa);
                stUpdateProducto.setInt(8, id_proveedor);
                stUpdateProducto.setInt(9, id_condicion);
                stUpdateProducto.setInt(10, id_moneda);
                stUpdateProducto.setInt(11, id_comprobante);
                stUpdateProducto.setInt(12, 0);
                stUpdateProducto.setInt(13, 0);
                stUpdateProducto.setInt(14, 0);
                stUpdateProducto.setInt(15, 0);
                stUpdateProducto.setInt(16, 0);
                stUpdateProducto.setInt(17, 0);
                stUpdateProducto.setInt(18, 0);
                stUpdateProducto.setInt(19, 0);
                stUpdateProducto.setInt(20, 1);
                stUpdateProducto.setInt(21, id_sucursal);
                stUpdateProducto.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "Factura de venta duplicada");
                Compras.jTextField_fac_numero.requestFocus();
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Timbrado_guardar() {
        try {
            if (id_proveedor != 0 && Compras.jTextField_timbrado.getText().length() > 0) {

                boolean existe = false;
                Statement st21 = conexion.createStatement();
                ResultSet result2 = st21.executeQuery(""
                        + "SELECT * FROM timbrado "
                        + "where timbrado = '" + Compras.jTextField_timbrado.getText() + "' "
                        + "and id_proveedor = '" + id_proveedor + "'");
                if (result2.next()) {
                    existe = true;
                }

                if (existe == false) {
                    Statement st1 = conexion.createStatement();

                    ResultSet result = st1.executeQuery("SELECT MAX(id_timbrado) FROM timbrado");
                    if (result.next()) {
                        id_timbrado = result.getInt(1) + 1;
                    }

                    PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO timbrado VALUES(?,?,?,?)");
                    stUpdateProducto.setInt(1, id_timbrado);
                    stUpdateProducto.setInt(2, Integer.parseInt(Compras.jTextField_timbrado.getText()));
                    stUpdateProducto.setDate(3, null);
                    stUpdateProducto.setInt(4, id_proveedor);
                    stUpdateProducto.executeUpdate();
                }

            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public synchronized static void Ventas_timbrado_guardar() {
        try {
            if (id_proveedor != 0 && Ventas.jTextField_timbrado.getText().length() > 0) {

                boolean existe = false;
                Statement st21 = conexion.createStatement();
                ResultSet result2 = st21.executeQuery(""
                        + "SELECT * FROM timbrado "
                        + "where timbrado = '" + Ventas.jTextField_timbrado.getText() + "' "
                        + "and id_proveedor = '" + id_proveedor + "'");
                if (result2.next()) {
                    existe = true;
                }

                if (existe == false) {
                    Statement st1 = conexion.createStatement();

                    ResultSet result = st1.executeQuery("SELECT MAX(id_timbrado) FROM timbrado");
                    if (result.next()) {
                        id_timbrado = result.getInt(1) + 1;
                    }

                    PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO timbrado VALUES(?,?,?,?)");
                    stUpdateProducto.setInt(1, id_timbrado);
                    stUpdateProducto.setInt(2, Integer.parseInt(Ventas.jTextField_timbrado.getText()));
                    stUpdateProducto.setDate(3, null);
                    stUpdateProducto.setInt(4, id_proveedor);
                    stUpdateProducto.executeUpdate();
                }

            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public synchronized static void Facturas_de_compra_max() {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery(""
                    + "SELECT MAX(id_factura) "
                    + "FROM factura "
                    + "where id_empresa = '" + empresa + "' "
                    + "and compra = '1' ");
            if (result.next()) {
                id_factura = result.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Factura_de_venta_max() {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery(""
                    + "SELECT MAX(id_factura) "
                    + "FROM factura "
                    + "where id_empresa = '" + empresa + "' "
                    + "and venta = '1' ");
            if (result.next()) {
                id_factura = result.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Facturas_de_compra_buscar() {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery(""
                    + "SELECT * FROM factura "
                    + "inner join proveedor on proveedor.id_proveedor = factura.id_proveedor "
                    + "inner join condicion on condicion.id_condicion = factura.id_condicion "
                    + "inner join moneda on moneda.id_moneda = factura.id_moneda "
                    + "inner join comprobante on comprobante.id_comprobante = factura.id_comprobante "
                    + "where id_factura = '" + id_factura + "' "
                    + "and id_empresa = '" + empresa + "' and compra = '1' ");
            while (result.next()) {

                System.err.println("ID factura " + result.getString("id_factura"));

                Statement st13 = conexion.createStatement();
                ResultSet result3 = st13.executeQuery(""
                        + "SELECT * FROM sucursal "
                        + "where id_empresa = '" + empresa + "' order by id_sucursal ASC");
                if (result3.next()) {
                    Compras.jTextField_sucursal.setText(result3.getString("sucursal").trim());
                    System.err.println("sucursal id " + result3.getString("id_sucursal"));
                }

                String factura_sucursal = result.getString("factura_sucursal");
                if (result.getString("factura_sucursal").length() == 1) {
                    factura_sucursal = "00" + result.getString("factura_sucursal");
                }
                if (result.getString("factura_sucursal").length() == 2) {
                    factura_sucursal = "0" + result.getString("factura_sucursal");
                }
                String factura_caja = result.getString("factura_caja");
                if (result.getString("factura_caja").length() == 1) {
                    factura_caja = "00" + result.getString("factura_caja");
                }
                if (result.getString("factura_caja").length() == 2) {
                    factura_caja = "0" + result.getString("factura_caja");
                }
                Compras.jTextField_fac_numero.setText(result.getString("factura_numero"));
                Compras.jTextField_fac_sucursal.setText(factura_sucursal);
                Compras.jTextField_fac_caja.setText(factura_caja);

                id_proveedor = result.getInt("id_proveedor");

                Compras.jTextField_proveedor.setText(result.getString("nombre"));
                Compras.jTextField_ruc.setText(result.getString("ruc"));
                Compras.jTextField_descripcion.setText(result.getString("descripcion"));

                Statement ST2 = conexion.createStatement();
                ResultSet RS2 = ST2.executeQuery(""
                        + "SELECT * FROM timbrado "
                        + "where id_proveedor = '" + id_proveedor + "' order by vencimiento DESC");
                if (RS2.next()) {
                    Compras.jTextField_timbrado.setText(RS2.getString("timbrado"));
                }
                Compras.jDateChooser_fecha.setDate(result.getDate("fecha"));
                id_condicion = result.getInt("id_condicion");
                Compras.jTextField_condicion.setText(result.getString("condicion"));
                id_moneda = result.getInt("id_moneda");
                Compras.jTextField_moneda.setText(result.getString("moneda"));
                id_comprobante = result.getInt("id_comprobante");
                Compras.jTextField_comprobante.setText(result.getString("comprobante"));
                long total = result.getLong("total_debe");
                System.err.println(total);
                String total_str = String.valueOf(total);
                Compras.jTextField_total.setText(getSepararMiles(total_str));
                Compras_detalle_cargar_jtable();
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Sucursal_empresa() {
        try {
            Statement st13 = conexion.createStatement();
            ResultSet result3 = st13.executeQuery(""
                    + "SELECT * FROM sucursal "
                    + "where id_empresa = '" + empresa + "' order by id_sucursal ");
            if (result3.next()) {
                Ventas.jTextField_sucursal.setText(result3.getString("sucursal").trim());
                id_sucursal = result3.getInt("id_sucursal");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Sucursal_empresa_compras() {
        try {
            Statement st13 = conexion.createStatement();
            ResultSet result3 = st13.executeQuery(""
                    + "SELECT * FROM sucursal "
                    + "where id_empresa = '" + empresa + "' order by id_sucursal ");
            if (result3.next()) {
                Compras.jTextField_sucursal.setText(result3.getString("sucursal").trim());
                id_sucursal = result3.getInt("id_sucursal");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Facturas_de_venta_buscar() {
        try {

            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery(""
                    + "SELECT * FROM factura "
                    + "inner join proveedor on proveedor.id_proveedor = factura.id_proveedor "
                    + "inner join condicion on condicion.id_condicion = factura.id_condicion "
                    + "inner join moneda on moneda.id_moneda = factura.id_moneda "
                    + "inner join comprobante on comprobante.id_comprobante = factura.id_comprobante "
                    + "where id_factura = '" + id_factura + "' "
                    + "and id_empresa = '" + empresa + "' "
                    + "and venta = '1' ");
            if (result.next()) {

                Statement st137 = conexion.createStatement();
                ResultSet result37 = st137.executeQuery(""
                        + "SELECT * FROM sucursal "
                        + "where id_sucursal = '" + result.getInt("id_sucursal") + "'");
                if (result37.next()) {
                    Ventas.jTextField_sucursal.setText(result37.getString("sucursal").trim());
                    id_sucursal = result37.getInt("id_sucursal");
                }

                String factura_sucursal = result.getString("factura_sucursal");
                if (result.getString("factura_sucursal").length() == 1) {
                    factura_sucursal = "00" + result.getString("factura_sucursal");
                }
                if (result.getString("factura_sucursal").length() == 2) {
                    factura_sucursal = "0" + result.getString("factura_sucursal");
                }
                String factura_caja = result.getString("factura_caja");
                if (result.getString("factura_caja").length() == 1) {
                    factura_caja = "00" + result.getString("factura_caja");
                }
                if (result.getString("factura_caja").length() == 2) {
                    factura_caja = "0" + result.getString("factura_caja");
                }
                Ventas.jTextField_fac_numero.setText(result.getString("factura_numero"));
                Ventas.jTextField_fac_sucursal.setText(factura_sucursal);
                Ventas.jTextField_fac_caja.setText(factura_caja);
                id_proveedor = result.getInt("id_proveedor");
                Ventas.jTextField_razon_social.setText(result.getString("nombre"));
                Ventas.jTextField_ruc.setText(result.getString("ruc"));
                Ventas.jTextField_descripcion.setText(result.getString("descripcion"));

                Statement ST2 = conexion.createStatement();
                ResultSet RS2 = ST2.executeQuery(""
                        + "SELECT * FROM timbrado "
                        + "where id_proveedor = '" + id_proveedor + "' order by vencimiento DESC");
                if (RS2.next()) {
                    Ventas.jTextField_timbrado.setText(RS2.getString("timbrado"));
                }

                Ventas.jDateChooser_fecha.setDate(result.getDate("fecha"));

                id_condicion = result.getInt("id_condicion");
                Ventas.jTextField_condicion.setText(result.getString("condicion"));

                id_moneda = result.getInt("id_moneda");
                Ventas.jTextField_moneda.setText(result.getString("moneda"));

                id_comprobante = result.getInt("id_comprobante");
                Ventas.jTextField_comprobante.setText(result.getString("comprobante"));

                long total_long = result.getLong("total_debe");
                //  System.err.println(total);
                String total_str = String.valueOf(total_long);

                Ventas.jTextField_total.setText(getSepararMiles(total_str));

                Ventas_detalle_cargar_jtable();
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Compras_detalle_cargar_jtable() {
        try {
            //-------------------------------------------
            DefaultTableModel dtm = (DefaultTableModel) Compras.jTable_compras_detalle.getModel();
            for (int j = 0; j < Compras.jTable_compras_detalle.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_factura_detalle, "
                    + "(nv1 || '.' || nv2|| '.' || nv3|| '.' || nv4|| '.' || nv5|| ' ' || cuenta) AS cuenta, debe, haber, tipo_de_iva, impuesto  "
                    + "from factura_detalle "
                    + "inner join impuesto on impuesto.id_impuesto = factura_detalle.id_impuesto "
                    + "inner join cuenta on cuenta.id_cuenta = factura_detalle.id_cuenta "
                    + "inner join tipo_de_iva on tipo_de_iva.id_tipo_de_iva = factura_detalle.id_tipo_de_iva "
                    + "where id_factura = '" + id_factura + "' "
                    + "order by id_factura_detalle ASC");
            ResultSet rs2 = ps2.executeQuery();
            ResultSetMetaData rsm = rs2.getMetaData();
            ArrayList<Object[]> data2 = new ArrayList<>();
            while (rs2.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {

                    String cadena = rs2.getObject(i + 1).toString().trim().replace("....", "                    ");
                    cadena = cadena.replace(".0.0.0.0", " ");
                    cadena = cadena.replace(".0.0.0", " ");
                    cadena = cadena.replace(".0.0", " ");
                    cadena = cadena.replace(".0", " ");
                    rows[i] = cadena;

//                    rows[i] = rs2.getObject(i + 1).toString().trim();
                }
                data2.add(rows);
            }
            dtm = (DefaultTableModel) Compras.jTable_compras_detalle.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Ventas_detalle_cargar_jtable() {
        try {
            //-------------------------------------------
            DefaultTableModel dtm = (DefaultTableModel) Ventas.jTable_compras_detalle.getModel();
            for (int j = 0; j < Ventas.jTable_compras_detalle.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_factura_detalle, "
                    + "(nv1 || '.' || nv2|| '.' || nv3|| '.' || nv4|| '.' || nv5|| ' ' || cuenta) AS cuenta, debe, haber, tipo_de_iva, impuesto  "
                    + "from factura_detalle "
                    + "inner join impuesto on impuesto.id_impuesto = factura_detalle.id_impuesto "
                    + "inner join cuenta on cuenta.id_cuenta = factura_detalle.id_cuenta "
                    + "inner join tipo_de_iva on tipo_de_iva.id_tipo_de_iva = factura_detalle.id_tipo_de_iva "
                    + "where id_factura = '" + id_factura + "' "
                    + "order by id_factura_detalle ASC");
            ResultSet rs2 = ps2.executeQuery();
            ResultSetMetaData rsm = rs2.getMetaData();
            ArrayList<Object[]> data2 = new ArrayList<>();
            while (rs2.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {

                    String cadena = rs2.getObject(i + 1).toString().trim().replace("....", "                    ");
                    cadena = cadena.replace(".0.0.0.0", " ");
                    cadena = cadena.replace(".0.0.0", " ");
                    cadena = cadena.replace(".0.0", " ");
                    cadena = cadena.replace(".0", " ");
                    rows[i] = cadena;

//                    rows[i] = rs2.getObject(i + 1).toString().trim();
                }
                data2.add(rows);
            }
            dtm = (DefaultTableModel) Ventas.jTable_compras_detalle.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Cuentas_guardar() {
        try {
            if (id_cuenta == 0) {
                if ((Cuentas_ABM.jTextField_nv1.getText().length() < 1)
                        || (Cuentas_ABM.jTextField_cuenta.getText().length() < 1)) {
                    System.err.println("Complete todos los campos");
                } else {

                    Statement st1 = conexion.createStatement();

                    ResultSet result = st1.executeQuery("SELECT MAX(id_cuenta) FROM cuenta");
                    if (result.next()) {
                        id_cuenta = result.getInt(1) + 1;
                    }
                    int nv1 = 0;
                    if (Cuentas_ABM.jTextField_nv1.getText().length() > 0) {
                        nv1 = Integer.parseInt(Cuentas_ABM.jTextField_nv1.getText());
                    }
                    int nv2 = 0;
                    if (Cuentas_ABM.jTextField_nv2.getText().length() > 0) {
                        nv2 = Integer.parseInt(Cuentas_ABM.jTextField_nv2.getText());
                    }
                    int nv3 = 0;
                    if (Cuentas_ABM.jTextField_nv3.getText().length() > 0) {
                        nv3 = Integer.parseInt(Cuentas_ABM.jTextField_nv3.getText());
                    }
                    int nv4 = 0;
                    if (Cuentas_ABM.jTextField_nv4.getText().length() > 0) {
                        nv4 = Integer.parseInt(Cuentas_ABM.jTextField_nv4.getText());
                    }
                    int nv5 = 0;
                    if (Cuentas_ABM.jTextField_nv5.getText().length() > 0) {
                        nv5 = Integer.parseInt(Cuentas_ABM.jTextField_nv5.getText());
                    }
                    PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO cuenta VALUES(?,?,?,?,?,?,?,?)");
                    stUpdateProducto.setInt(1, id_cuenta);
                    stUpdateProducto.setInt(2, nv1);
                    stUpdateProducto.setInt(3, nv2);
                    stUpdateProducto.setInt(4, nv3);
                    stUpdateProducto.setInt(5, nv4);
                    stUpdateProducto.setInt(6, nv5);
                    stUpdateProducto.setString(7, Cuentas_ABM.jTextField_cuenta.getText());
                    stUpdateProducto.setInt(8, 0);
                    stUpdateProducto.executeUpdate();

                }
            } else if (Cuentas_ABM.jTextField_cuenta.getText().length() > 0) {

                int nv1 = 0;
                if (Cuentas_ABM.jTextField_nv1.getText().length() > 0) {
                    nv1 = Integer.parseInt(Cuentas_ABM.jTextField_nv1.getText());
                }
                int nv2 = 0;
                if (Cuentas_ABM.jTextField_nv2.getText().length() > 0) {
                    nv2 = Integer.parseInt(Cuentas_ABM.jTextField_nv2.getText());
                }
                int nv3 = 0;
                if (Cuentas_ABM.jTextField_nv3.getText().length() > 0) {
                    nv3 = Integer.parseInt(Cuentas_ABM.jTextField_nv3.getText());
                }
                int nv4 = 0;
                if (Cuentas_ABM.jTextField_nv4.getText().length() > 0) {
                    nv4 = Integer.parseInt(Cuentas_ABM.jTextField_nv4.getText());
                }
                int nv5 = 0;
                if (Cuentas_ABM.jTextField_nv5.getText().length() > 0) {
                    nv5 = Integer.parseInt(Cuentas_ABM.jTextField_nv5.getText());
                }

                PreparedStatement st = conexion.prepareStatement(""
                        + "UPDATE cuenta "
                        + "SET cuenta ='" + Cuentas_ABM.jTextField_cuenta.getText().trim() + "', "
                        + "nv1 ='" + nv1 + "', "
                        + "nv2 ='" + nv2 + "', "
                        + "nv3 ='" + nv3 + "', "
                        + "nv4 = '" + nv4 + "', "
                        + "nv5 = '" + nv5 + "' "
                        + "WHERE id_cuenta = '" + id_cuenta + "'");
                st.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            }

            JOptionPane.showMessageDialog(null, "Guardado correctamente");

        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public synchronized static void Proveedores_guardar() {
        try {
            if (id_proveedor == 0) {
                if ((Proveedores_ABM.jTextField_razon_social.getText().length() < 1)
                        || (Proveedores_ABM.jTextField_direccion.getText().length() < 1)
                        || (Proveedores_ABM.jTextField_ruc.getText().length() < 1)
                        || (Proveedores_ABM.jTextField_telefono.getText().length() < 1)) {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    Statement st1 = conexion.createStatement();

                    ResultSet result = st1.executeQuery("SELECT MAX(id_proveedor) FROM proveedor ");
                    if (result.next()) {
                        id_proveedor = result.getInt(1) + 1;
                    }

                    PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO proveedor VALUES(?,?,?,?,?,?)");
                    stUpdateProducto.setInt(1, id_proveedor);
                    stUpdateProducto.setString(2, Proveedores_ABM.jTextField_razon_social.getText());
                    stUpdateProducto.setString(3, Proveedores_ABM.jTextField_ruc.getText());
                    stUpdateProducto.setString(4, Proveedores_ABM.jTextField_telefono.getText());
                    stUpdateProducto.setString(5, Proveedores_ABM.jTextField_direccion.getText());
                    stUpdateProducto.setInt(6, 0); //borrado
                    stUpdateProducto.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Guardado correctamente");
                }
            }

        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public synchronized static void Empresa_guardar() {
        try {
            if (id_empresa == 0) {
                if ((id_cliente == 0)
                        || (Empresas_ABM.jTextField_razon_social.getText().length() < 1)
                        || (Empresas_ABM.jTextField_ruc.getText().length() < 1)
                        || (Empresas_ABM.jTextField_direccion.getText().length() < 1)
                        || (Empresas_ABM.jTextField_telefono.getText().length() < 1)) {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    Statement st1 = conexion.createStatement();
                    ResultSet result = st1.executeQuery("SELECT MAX(id_empresa) FROM empresa");
                    if (result.next()) {
                        id_empresa = result.getInt(1) + 1;
                    }
                    PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO empresa VALUES(?,?,?,?,?,?)");
                    stUpdateProducto.setInt(1, id_empresa);
                    stUpdateProducto.setString(2, Empresas_ABM.jTextField_razon_social.getText());
                    stUpdateProducto.setString(3, Empresas_ABM.jTextField_ruc.getText());
                    stUpdateProducto.setString(4, Empresas_ABM.jTextField_telefono.getText());
                    stUpdateProducto.setString(5, Empresas_ABM.jTextField_direccion.getText());
                    stUpdateProducto.setInt(6, id_cliente);
                    stUpdateProducto.executeUpdate();

                    Statement st2 = conexion.createStatement();
                    ResultSet result2 = st2.executeQuery("SELECT MAX(id_sucursal) FROM sucursal");
                    if (result2.next()) {
                        id = result2.getInt(1) + 1;
                    }
                    PreparedStatement stUpdateProducto2 = conexion.prepareStatement("INSERT INTO sucursal VALUES(?,?,?,?)");
                    stUpdateProducto2.setInt(1, id);
                    stUpdateProducto2.setString(2, "Casa Matriz");
                    stUpdateProducto2.setInt(3, id_empresa);
                    stUpdateProducto2.setInt(4, 0);
                    stUpdateProducto2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Guardado correctamente");
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

        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void Compras_agregar_detalle_calculo_gravada10() {
        String gravada_10_str = Compras_agregar_detalle.jTextField_gravadas10.getText().replace(".", "");
        gravada_10_long = Long.parseLong(gravada_10_str);
        iva_10 = gravada_10_long / 11;
        gravada_10_long = gravada_10_long - iva_10;
        Compras_agregar_detalle.jTextField_gravadas10.setText(getSepararMiles(String.valueOf(gravada_10_long)));
        Compras_agregar_detalle.jTextField_iva10.setText(getSepararMiles(String.valueOf(iva_10)));
        total = gravada_5_long + iva_5 + gravada_10_long + iva_10 + exentas;
        Compras_agregar_detalle.jTextField_total.setText(getSepararMiles(String.valueOf(total)));
    }

    public static void Ventas_agregar_detalle_calculo_gravada10() {
        String gravada_10_str = Ventas_agregar_detalle.jTextField_gravadas10.getText().replace(".", "");
        gravada_10_long = Long.parseLong(gravada_10_str);
        iva_10 = gravada_10_long / 11;
        gravada_10_long = gravada_10_long - iva_10;
        Ventas_agregar_detalle.jTextField_gravadas10.setText(getSepararMiles(String.valueOf(gravada_10_long)));
        Ventas_agregar_detalle.jTextField_iva10.setText(getSepararMiles(String.valueOf(iva_10)));
        total = gravada_5_long + iva_5 + gravada_10_long + iva_10 + exentas;
        Ventas_agregar_detalle.jTextField_total.setText(getSepararMiles(String.valueOf(total)));
    }

    public static void Compras_agregar_detalle_calculo_exentas() {
        String exentas_str = Compras_agregar_detalle.jTextField_exentas.getText().replace(".", "");
        exentas = Long.parseLong(exentas_str);
        Compras_agregar_detalle.jTextField_exentas.setText(getSepararMiles(exentas_str));
        total = gravada_5_long + iva_5 + gravada_10_long + iva_10 + exentas;
        Compras_agregar_detalle.jTextField_total.setText(getSepararMiles(String.valueOf(total)));
    }

    public static void Ventas_agregar_detalle_calculo_exentas() {
        String exentas_str = Ventas_agregar_detalle.jTextField_exentas.getText().replace(".", "");
        exentas = Long.parseLong(exentas_str);
        Ventas_agregar_detalle.jTextField_exentas.setText(getSepararMiles(exentas_str));
        total = gravada_5_long + iva_5 + gravada_10_long + iva_10 + exentas;
        Ventas_agregar_detalle.jTextField_total.setText(getSepararMiles(String.valueOf(total)));
    }

    public static long exentas = 0;
    public static long gravada_10_long = 0;
    public static long gravada_5_long = 0;
    public static long iva_5 = 0;
    public static long iva_10 = 0;
    public static long total = 0;

    public static void Compras_agregar_detalle_calculo_gravada5() {
        String gravada_5_str = Compras_agregar_detalle.jTextField_gravadas_5.getText().replace(".", "");
        gravada_5_long = Long.parseLong(gravada_5_str);
        iva_5 = gravada_5_long / 21;
        gravada_5_long = gravada_5_long - iva_5;
        Compras_agregar_detalle.jTextField_gravadas_5.setText(getSepararMiles(String.valueOf(gravada_5_long)));
        Compras_agregar_detalle.jTextField_iva5.setText(getSepararMiles(String.valueOf(iva_5)));
        total = gravada_5_long + iva_5 + gravada_10_long + iva_10 + exentas;
        Compras_agregar_detalle.jTextField_total.setText(getSepararMiles(String.valueOf(total)));
    }

    public static void Ventas_agregar_detalle_calculo_gravada5() {
        String gravada_5_str = Ventas_agregar_detalle.jTextField_gravadas_5.getText().replace(".", "");
        gravada_5_long = Long.parseLong(gravada_5_str);
        iva_5 = gravada_5_long / 21;
        gravada_5_long = gravada_5_long - iva_5;
        Ventas_agregar_detalle.jTextField_gravadas_5.setText(getSepararMiles(String.valueOf(gravada_5_long)));
        Ventas_agregar_detalle.jTextField_iva5.setText(getSepararMiles(String.valueOf(iva_5)));
        total = gravada_5_long + iva_5 + gravada_10_long + iva_10 + exentas;
        Ventas_agregar_detalle.jTextField_total.setText(getSepararMiles(String.valueOf(total)));
    }

    public synchronized static String getSepararMiles(String txtprec) {
        String valor = txtprec;

        int largo = valor.length();
        if (largo > 8) {
            valor = valor.substring(largo - 9, largo - 6) + "." + valor.substring(largo - 6, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 7) {
            valor = valor.substring(largo - 8, largo - 6) + "." + valor.substring(largo - 6, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 6) {
            valor = valor.substring(largo - 7, largo - 6) + "." + valor.substring(largo - 6, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 5) {
            valor = valor.substring(largo - 6, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 4) {
            valor = valor.substring(largo - 5, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 3) {
            valor = valor.substring(largo - 4, largo - 3) + "." + valor.substring(largo - 3, largo);
        }
        txtprec = valor;
        return valor;
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

    public static void Facturas_de_compra_clear() {
        id_factura = 0;
        id_moneda = 1;
        id_condicion = 1;
        id_comprobante = 1;

        Compras.jTextField_fac_sucursal.setText("001");
        Compras.jTextField_fac_caja.setText("001");
        Compras.jTextField_fac_numero.setText("");
        Compras.jTextField_moneda.setText("GUARANIES");
        Compras.jTextField_condicion.setText("CONTADO");
        Compras.jTextField_comprobante.setText("FACTURA");
        Compras.jTextField_descripcion.setText("");
        Compras.jTextField_cuenta.setText("");
        Compras.jTextField_proveedor.setText("");
        Compras.jTextField_ruc.setText("");
        Compras.jTextField_timbrado.setText("");
        Compras.jDateChooser_fecha.setDate(null);
        Compras.jTextField_total.setText("");

    }

    public static void Facturas_de_venta_clear() {
        id_factura = 0;
        id_moneda = 1;
        id_condicion = 1;
        id_comprobante = 1;

        Ventas.jTextField_fac_sucursal.setText("001");
        Ventas.jTextField_fac_caja.setText("001");
        Ventas.jTextField_fac_numero.setText("");
        Ventas.jTextField_moneda.setText("GUARANIES");
        Ventas.jTextField_condicion.setText("CONTADO");
        Ventas.jTextField_comprobante.setText("FACTURA");
        Ventas.jTextField_descripcion.setText("");
        Ventas.jTextField_cuenta.setText("");
        Ventas.jTextField_razon_social.setText("");
        Ventas.jTextField_ruc.setText("");
        Ventas.jTextField_timbrado.setText("");
        Ventas.jDateChooser_fecha.setDate(null);
        Ventas.jTextField_total.setText("");
        Ventas.jTextField_sucursal.setText("Casa matriz");

    }

    public static void Proveedores_clear() {
        id_proveedor = 0;
        Proveedores_ABM.jTextField_direccion.setText("");
        Proveedores_ABM.jTextField_razon_social.setText("");
        Proveedores_ABM.jTextField_ruc.setText("");
        Proveedores_ABM.jTextField_telefono.setText("");
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
                    + "where cuenta ilike '%" + Cuentas.jTextField_buscar.getText() + "%' order by nv1, nv2,nv3,nv4,nv5");
            ResultSet rs2 = ps2.executeQuery();
            ResultSetMetaData rsm = rs2.getMetaData();
            ArrayList<Object[]> data2 = new ArrayList<>();
            while (rs2.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {

                    String cadena = rs2.getObject(i + 1).toString().trim().replace("....", "                    ");
                    cadena = cadena.replace(".0.0.0.0", " ");
                    cadena = cadena.replace(".0.0.0", " ");
                    cadena = cadena.replace(".0.0", " ");
                    cadena = cadena.replace(".0", " ");
                    rows[i] = cadena;
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

    public synchronized static void Factura_compra_detalle_modificar_cuentas_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Factura_compra_detalle_modificar_cuentas_buscar.jTable1.getModel();
            for (int j = 0; j < Factura_compra_detalle_modificar_cuentas_buscar.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_cuenta,  (nv1 || '.' || nv2|| '.' || nv3|| '.' || nv4|| '.' || nv5|| ' ' || cuenta) AS cuenta  "
                    + "from cuenta "
                    + "where cuenta ilike '%" + Factura_compra_detalle_modificar_cuentas_buscar.jTextField_buscar.getText() + "%' "
                    + "order by nv1,nv2,nv3,nv4,nv5");
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
            dtm = (DefaultTableModel) Factura_compra_detalle_modificar_cuentas_buscar.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Factura_venta_detalle_modificar_cuentas_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Factura_venta_detalle_modificar_cuentas_buscar.jTable1.getModel();
            for (int j = 0; j < Factura_venta_detalle_modificar_cuentas_buscar.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_cuenta,  (nv1 || '.' || nv2|| '.' || nv3|| '.' || nv4|| '.' || nv5|| ' ' || cuenta) AS cuenta  "
                    + "from cuenta "
                    + "where cuenta ilike '%" + Factura_venta_detalle_modificar_cuentas_buscar.jTextField_buscar.getText() + "%' "
                    + "order by nv1,nv2,nv3,nv4,nv5");
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
            dtm = (DefaultTableModel) Factura_venta_detalle_modificar_cuentas_buscar.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Parametros_cuentas_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Parametros_buscar_cuentas.jTable1.getModel();
            for (int j = 0; j < Parametros_buscar_cuentas.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_cuenta,  (nv1 || '.' || nv2|| '.' || nv3|| '.' || nv4|| '.' || nv5|| ' ' || cuenta) AS cuenta  "
                    + "from cuenta "
                    + "where cuenta ilike '%" + Parametros_buscar_cuentas.jTextField_buscar.getText() + "%' "
                    + "order by nv1,nv2,nv3,nv4,nv5");
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
            dtm = (DefaultTableModel) Parametros_buscar_cuentas.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Cuentas_asociadas_agregar_detalle_buscar_cuenta_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Cuentas_asociadas_agregar_detalle_buscar_cuenta.jTable1.getModel();
            for (int j = 0; j < Cuentas_asociadas_agregar_detalle_buscar_cuenta.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_cuenta,  (nv1 || '.' || nv2|| '.' || nv3|| '.' || nv4|| '.' || nv5|| ' ' || cuenta) AS cuenta  "
                    + "from cuenta "
                    + "where cuenta ilike '%" + Cuentas_asociadas_agregar_detalle_buscar_cuenta.jTextField_buscar.getText() + "%' "
                    + "order by nv1,nv2,nv3,nv4,nv5");
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
            dtm = (DefaultTableModel) Cuentas_asociadas_agregar_detalle_buscar_cuenta.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Cuentas_asociadas_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Cuentas_asociadas.jTable_cuentas.getModel();
            for (int j = 0; j < Cuentas_asociadas.jTable_cuentas.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_cuenta,  (nv1 || '.' || nv2|| '.' || nv3|| '.' || nv4|| '.' || nv5|| ' ' || cuenta) AS cuenta  "
                    + "from cuenta "
                    + "where cuenta ilike '%" + Cuentas_asociadas.jTextField_buscar.getText() + "%' "
                    + "order by nv1,nv2,nv3,nv4,nv5");
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
            dtm = (DefaultTableModel) Cuentas_asociadas.jTable_cuentas.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Condicion_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Condicion.jTable1.getModel();
            for (int j = 0; j < Condicion.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_condicion,  condicion  "
                    + "from condicion ");
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
            dtm = (DefaultTableModel) Condicion.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Comprobante_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Comprobante.jTable1.getModel();
            for (int j = 0; j < Comprobante.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_comprobante,  comprobante  "
                    + "from comprobante ");
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
            dtm = (DefaultTableModel) Comprobante.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Moneda_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Moneda.jTable1.getModel();
            for (int j = 0; j < Moneda.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_moneda,  moneda  "
                    + "from moneda ");
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
            dtm = (DefaultTableModel) Moneda.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Compras_proveedores_buscar_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Compras_proveedores_buscar.jTable1.getModel();
            for (int j = 0; j < Compras_proveedores_buscar.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_proveedor, nombre, ruc, telefono "
                    + "from proveedor "
                    + "where nombre ilike '%" + Compras_proveedores_buscar.jTextField_buscar.getText() + "%' and id_proveedor > '0' ");
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
            dtm = (DefaultTableModel) Compras_proveedores_buscar.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Ventas_proveedores_buscar_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Ventas_proveedores_buscar.jTable1.getModel();
            for (int j = 0; j < Ventas_proveedores_buscar.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_proveedor, nombre, ruc, telefono "
                    + "from proveedor "
                    + "where nombre ilike '%" + Ventas_proveedores_buscar.jTextField_buscar.getText() + "%' and id_proveedor > '0' ");
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
            dtm = (DefaultTableModel) Ventas_proveedores_buscar.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Seleccionar_empresas_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Seleccionar_empresa.jTable1.getModel();
            for (int j = 0; j < Seleccionar_empresa.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_empresa, razon_social, cliente.nombre  "
                    + "from empresa "
                    + "inner join cliente on cliente.id_cliente = empresa.id_cliente "
                    + "where razon_social ilike '%" + Seleccionar_empresa.jTextField_buscar.getText() + "%' "
                    + "or nombre ilike '%" + Seleccionar_empresa.jTextField_buscar.getText() + "%'");
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
            dtm = (DefaultTableModel) Seleccionar_empresa.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Empresas_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Empresas.jTable1.getModel();
            for (int j = 0; j < Empresas.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_empresa, razon_social, id_cliente  "
                    + "from empresa "
                    + "where razon_social ilike '%" + Empresas.jTextField_buscar.getText() + "%'");
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
            dtm = (DefaultTableModel) Empresas.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Sucursal_empresas_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Sucursal_empresas_buscar.jTable1.getModel();
            for (int j = 0; j < Sucursal_empresas_buscar.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_empresa, razon_social, nombre  "
                    + "from empresa "
                    + "inner join cliente on cliente.id_cliente = empresa.id_cliente "
                    + "where razon_social ilike '%" + Sucursal_empresas_buscar.jTextField_buscar.getText() + "%'");
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
            dtm = (DefaultTableModel) Sucursal_empresas_buscar.jTable1.getModel();
            for (int i = 0; i < data2.size(); i++) {
                dtm.addRow(data2.get(i));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Ventas_sucursal_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Ventas_sucursal_buscar.jTable1.getModel();
            for (int j = 0; j < Ventas_sucursal_buscar.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_sucursal, sucursal  "
                    + "from sucursal where id_empresa = '" + empresa + "' ");
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
            dtm = (DefaultTableModel) Ventas_sucursal_buscar.jTable1.getModel();
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
                    + "select id_cliente, nombre, ci, telefono  "
                    + "from cliente "
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
                    + "select id_cliente, nombre, ci, telefono  "
                    + "from cliente "
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
                    + "where cuenta ilike '%" + Compras_buscar_cuentas.jTextField_buscar.getText() + "%' "
                    + "order by nv1,nv2,nv3,nv4,nv5");
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

    public synchronized static void Ventas_cuentas_cargar_jtable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) Ventas_buscar_cuentas.jTable1.getModel();
            for (int j = 0; j < Ventas_buscar_cuentas.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            PreparedStatement ps2 = conexion.prepareStatement(""
                    + "select id_cuenta,  (nv1 || '.' || nv2|| '.' || nv3|| '.' || nv4|| '.' || nv5|| ' ' || cuenta) AS cuenta  "
                    + "from cuenta "
                    + "where cuenta ilike '%" + Ventas_buscar_cuentas.jTextField_buscar.getText() + "%' "
                    + "order by nv1,nv2,nv3,nv4,nv5");
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
            dtm = (DefaultTableModel) Ventas_buscar_cuentas.jTable1.getModel();
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
                cuenta = RS.getString("cuenta").trim();
                Compras.jTextField_cuenta.setText(RS.getString("cuenta").trim());

                if (Compras.jTextField_descripcion.getText().length() > 0) {
                } else {
                    PreparedStatement st = conexion.prepareStatement(""
                            + "UPDATE factura "
                            + "SET descripcion ='" + cuenta + "' "
                            + "WHERE id_factura = '" + id_factura + "'");
                    st.executeUpdate();
                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public synchronized static void Ventas_buscar_cuentas_seleccionar_cuenta() {

        DefaultTableModel tm = (DefaultTableModel) Ventas_buscar_cuentas.jTable1.getModel();
        id_cuenta = Integer.parseInt(String.valueOf(tm.getValueAt(Ventas_buscar_cuentas.jTable1.getSelectedRow(), 0)));

        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM cuenta where id_cuenta = '" + id_cuenta + "'");
            if (RS.next()) {
                cuenta = RS.getString("cuenta").trim();
                Ventas.jTextField_cuenta.setText(RS.getString("cuenta").trim());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public synchronized static void Parametros_cuentas_seleccionar() {
        DefaultTableModel tm = (DefaultTableModel) Parametros_buscar_cuentas.jTable1.getModel();
        if (cuenta_parametros == 1) {
            cuenta_iva_10 = Integer.parseInt(String.valueOf(tm.getValueAt(Parametros_buscar_cuentas.jTable1.getSelectedRow(), 0)));
            Parametros.jTextField_iva_10.setText(String.valueOf(tm.getValueAt(Parametros_buscar_cuentas.jTable1.getSelectedRow(), 1)));
            Metodos.Parametros_cuenta_iva_10_update();
        }
        if (cuenta_parametros == 2) {
            cuenta_caja = Integer.parseInt(String.valueOf(tm.getValueAt(Parametros_buscar_cuentas.jTable1.getSelectedRow(), 0)));
            Parametros.jTextField_caja.setText(String.valueOf(tm.getValueAt(Parametros_buscar_cuentas.jTable1.getSelectedRow(), 1)));
            Metodos.Parametros_caja_update();
        }
        if (cuenta_parametros == 3) {
            cuenta_iva_5 = Integer.parseInt(String.valueOf(tm.getValueAt(Parametros_buscar_cuentas.jTable1.getSelectedRow(), 0)));
            Parametros.jTextField_iva_5.setText(String.valueOf(tm.getValueAt(Parametros_buscar_cuentas.jTable1.getSelectedRow(), 1)));
            Metodos.Parametros_iva_5_update();
        }
//        if (cuenta_parametros == 4) {
//            cuenta_exentas = Integer.parseInt(String.valueOf(tm.getValueAt(Parametros_buscar_cuentas.jTable1.getSelectedRow(), 0)));
//            Parametros.jTextField_exentas.setText(String.valueOf(tm.getValueAt(Parametros_buscar_cuentas.jTable1.getSelectedRow(), 1)));
//            Metodos.Parametros_exentas_update();
//        }
    }

    public synchronized static void Empresas_cliente_seleccionar() {
        DefaultTableModel tm = (DefaultTableModel) Empresas_buscar_clientes.jTable1.getModel();
        id_cliente = Integer.parseInt(String.valueOf(tm.getValueAt(Empresas_buscar_clientes.jTable1.getSelectedRow(), 0)));
        Empresas_ABM.jTextField_cliente.setText(String.valueOf(tm.getValueAt(Empresas_buscar_clientes.jTable1.getSelectedRow(), 1)));
    }

    public synchronized static void Condicion_selecionar() {
        DefaultTableModel tm = (DefaultTableModel) Condicion.jTable1.getModel();
        id_condicion = Integer.parseInt((String.valueOf(tm.getValueAt(Condicion.jTable1.getSelectedRow(), 0))));
        Compras.jTextField_condicion.setText(String.valueOf(tm.getValueAt(Condicion.jTable1.getSelectedRow(), 1)));
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE factura "
                    + "SET id_condicion ='" + id_condicion + "' "
                    + "WHERE id_factura = '" + id_factura + "'");
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public synchronized static void Comprobante_selecionar() {
        DefaultTableModel tm = (DefaultTableModel) Comprobante.jTable1.getModel();
        id_comprobante = Integer.parseInt((String.valueOf(tm.getValueAt(Comprobante.jTable1.getSelectedRow(), 0))));
        Compras.jTextField_comprobante.setText(String.valueOf(tm.getValueAt(Comprobante.jTable1.getSelectedRow(), 1)));

        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE factura "
                    + "SET id_comprobante ='" + id_comprobante + "' "
                    + "WHERE id_factura = '" + id_factura + "'");
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public synchronized static void Cuentas_asociadas_seleccionar() {
        DefaultTableModel tm = (DefaultTableModel) Cuentas_asociadas.jTable_cuentas.getModel();
        id_cuenta = Integer.parseInt((String.valueOf(tm.getValueAt(Cuentas_asociadas.jTable_cuentas.getSelectedRow(), 0))));
        cuenta = (String.valueOf(tm.getValueAt(Cuentas_asociadas.jTable_cuentas.getSelectedRow(), 1)));
//
//        try {
//            PreparedStatement st = conexion.prepareStatement(""
//                    + "UPDATE factura "
//                    + "SET id_comprobante ='" + id_comprobante + "' "
//                    + "WHERE id_factura = '" + id_factura + "'");
//            st.executeUpdate();
//        } catch (SQLException ex) {
//            System.err.println(ex);
//        }
    }

    public synchronized static void Moneda_selecionar() {
        DefaultTableModel tm = (DefaultTableModel) Moneda.jTable1.getModel();
        id_moneda = Integer.parseInt((String.valueOf(tm.getValueAt(Moneda.jTable1.getSelectedRow(), 0))));
        Compras.jTextField_moneda.setText(String.valueOf(tm.getValueAt(Moneda.jTable1.getSelectedRow(), 1)));

        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE factura "
                    + "SET id_moneda ='" + id_moneda + "' "
                    + "WHERE id_factura = '" + id_factura + "'");
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public synchronized static void Clientes_seleccionar() {
        DefaultTableModel tm = (DefaultTableModel) Clientes.jTable1.getModel();
        id_cliente = Integer.parseInt((String.valueOf(tm.getValueAt(Clientes.jTable1.getSelectedRow(), 0))));

        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM cliente where id_cliente = '" + id_cliente + "'");
            if (RS.next()) {
                Clientes_ABM.jTextField_nombre.setText(RS.getString("nombre").trim());
                Clientes_ABM.jTextField_ci.setText(RS.getString("ci"));
                Clientes_ABM.jTextField_direccion.setText(RS.getString("direccion").trim());
                Clientes_ABM.jTextField_email.setText(RS.getString("email").trim());
                Clientes_ABM.jTextField_telefono.setText(RS.getString("telefono").trim());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public synchronized static void Cuentas_asociadas_agregar_cuenta_asociada_seleccionar() {
        DefaultTableModel tm = (DefaultTableModel) Cuentas_asociadas_agregar_detalle_buscar_cuenta.jTable1.getModel();
        id_cuenta_asociada = Integer.parseInt((String.valueOf(tm.getValueAt(Cuentas_asociadas_agregar_detalle_buscar_cuenta.jTable1.getSelectedRow(), 0))));
        Cuentas_asociadas_agregar_detalle.jTextField_asociar.setText(String.valueOf(tm.getValueAt(Cuentas_asociadas_agregar_detalle_buscar_cuenta.jTable1.getSelectedRow(), 1)));
    }

    public synchronized static void Seleccionar_empresa() {
        try {
            DefaultTableModel tm = (DefaultTableModel) Seleccionar_empresa.jTable1.getModel();
            empresa = Integer.parseInt(String.valueOf(tm.getValueAt(Seleccionar_empresa.jTable1.getSelectedRow(), 0)));
            empresa_razon_social = "Empresa activa: " + String.valueOf(tm.getValueAt(Seleccionar_empresa.jTable1.getSelectedRow(), 1));

            Statement st14 = conexion.createStatement();
            ResultSet result44 = st14.executeQuery("SELECT * FROM sucursal where id_empresa = '" + empresa + "' order by id_sucursal ASC");
            if (result44.next()) {
                id_sucursal = result44.getInt(1);
            }

            System.err.println("Empresa " + empresa);

        } catch (SQLException ex) {
            System.err.println(ex);
        }

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

    public synchronized static void Sucursal_empresas_buscar_cuentas_seleccionar() {
        DefaultTableModel tm = (DefaultTableModel) Sucursal_empresas_buscar.jTable1.getModel();
        id_empresa = Integer.parseInt(String.valueOf(tm.getValueAt(Sucursal_empresas_buscar.jTable1.getSelectedRow(), 0)));
        Sucursal_ABM.jTextField_empresa.setText((String.valueOf(tm.getValueAt(Sucursal_empresas_buscar.jTable1.getSelectedRow(), 1))));
    }

    public synchronized static void Ventas_sucursal_buscar_sucursal_seleccionar() {
        DefaultTableModel tm = (DefaultTableModel) Ventas_sucursal_buscar.jTable1.getModel();
        id_sucursal = Integer.parseInt(String.valueOf(tm.getValueAt(Ventas_sucursal_buscar.jTable1.getSelectedRow(), 0)));
        Ventas.jTextField_sucursal.setText((String.valueOf(tm.getValueAt(Ventas_sucursal_buscar.jTable1.getSelectedRow(), 1))));
    }

    public synchronized static void Factura_compra_detalle_modificar_cuentas_seleccionar() {
        DefaultTableModel tm = (DefaultTableModel) Factura_compra_detalle_modificar_cuentas_buscar.jTable1.getModel();
        id_cuenta = Integer.parseInt(String.valueOf(tm.getValueAt(Factura_compra_detalle_modificar_cuentas_buscar.jTable1.getSelectedRow(), 0)));

        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE factura_detalle "
                    + "SET id_cuenta ='" + id_cuenta + "' "
                    + "WHERE id_factura_detalle = '" + id_factura_detalle + "'");
            st.executeUpdate();

            Facturas_de_compra_buscar();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public synchronized static void Factura_venta_detalle_modificar_cuentas_seleccionar() {
        DefaultTableModel tm = (DefaultTableModel) Factura_venta_detalle_modificar_cuentas_buscar.jTable1.getModel();
        id_cuenta = Integer.parseInt(String.valueOf(tm.getValueAt(Factura_venta_detalle_modificar_cuentas_buscar.jTable1.getSelectedRow(), 0)));

        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE factura_detalle "
                    + "SET id_cuenta ='" + id_cuenta + "' "
                    + "WHERE id_factura_detalle = '" + id_factura_detalle + "'");
            st.executeUpdate();

            Facturas_de_venta_buscar();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public synchronized static void Compras_proveedores_selecionar() {
        DefaultTableModel tm = (DefaultTableModel) Compras_proveedores_buscar.jTable1.getModel();
        id_proveedor = Integer.parseInt(String.valueOf(tm.getValueAt(Compras_proveedores_buscar.jTable1.getSelectedRow(), 0)));
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(""
                    + "SELECT * FROM proveedor "
                    + "where id_proveedor = '" + id_proveedor + "'");
            if (RS.next()) {

                Compras.jTextField_proveedor.setText(RS.getString("nombre"));
                Compras.jTextField_ruc.setText(RS.getString("ruc"));

                Statement ST2 = conexion.createStatement();
                ResultSet RS2 = ST2.executeQuery(""
                        + "SELECT * FROM timbrado "
                        + "where id_proveedor = '" + id_proveedor + "' order by vencimiento DESC");
                if (RS2.next()) {
                    Compras.jTextField_timbrado.setText(RS2.getString("timbrado"));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public synchronized static void Ventas_proveedores_selecionar() {
        DefaultTableModel tm = (DefaultTableModel) Ventas_proveedores_buscar.jTable1.getModel();
        id_proveedor = Integer.parseInt(String.valueOf(tm.getValueAt(Ventas_proveedores_buscar.jTable1.getSelectedRow(), 0)));
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(""
                    + "SELECT * FROM proveedor "
                    + "where id_proveedor = '" + id_proveedor + "'");
            if (RS.next()) {

                Ventas.jTextField_razon_social.setText(RS.getString("nombre"));
                Ventas.jTextField_ruc.setText(RS.getString("ruc"));

                Statement ST2 = conexion.createStatement();
                ResultSet RS2 = ST2.executeQuery(""
                        + "SELECT * FROM timbrado "
                        + "where id_proveedor = '" + id_proveedor + "' order by vencimiento DESC");
                if (RS2.next()) {
                    Ventas.jTextField_timbrado.setText(RS2.getString("timbrado"));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public synchronized static void Compras_detalle_seleccionar_detalle() {
        DefaultTableModel tm = (DefaultTableModel) Compras.jTable_compras_detalle.getModel();
        id_factura_detalle = Integer.parseInt(String.valueOf(tm.getValueAt(Compras.jTable_compras_detalle.getSelectedRow(), 0)));
        Compras_detalle_modificar.jTextField_cuenta.setText(String.valueOf(tm.getValueAt(Compras.jTable_compras_detalle.getSelectedRow(), 1)));
    }

    public synchronized static void Ventas_detalle_seleccionar_detalle() {
        DefaultTableModel tm = (DefaultTableModel) Ventas.jTable_compras_detalle.getModel();
        id_factura_detalle = Integer.parseInt(String.valueOf(tm.getValueAt(Ventas.jTable_compras_detalle.getSelectedRow(), 0)));
        Ventas_detalle_modificar.jTextField_cuenta.setText(String.valueOf(tm.getValueAt(Ventas.jTable_compras_detalle.getSelectedRow(), 1)));
    }
}
