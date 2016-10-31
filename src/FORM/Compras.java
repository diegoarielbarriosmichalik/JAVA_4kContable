package FORM;

import DEV.Metodos;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;

public class Compras extends javax.swing.JFrame {

    public Compras() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Compras");
        new File(".").getAbsolutePath();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icon.png")).getImage());

        Metodos.id_condicion = 1;
        Metodos.id_moneda = 1;
        Metodos.id_comprobante = 1;

        Metodos.Facturas_de_compra_max();
        Metodos.Facturas_de_compra_buscar();
        jTextField_proveedor.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_compras_detalle = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextField_fac_sucursal = new javax.swing.JTextField();
        jTextField_fac_caja = new javax.swing.JTextField();
        jTextField_fac_numero = new javax.swing.JTextField();
        jTextField_comprobante = new javax.swing.JTextField();
        jDateChooser_fecha = new com.toedter.calendar.JDateChooser();
        jTextField_proveedor = new javax.swing.JTextField();
        jTextField_condicion = new javax.swing.JTextField();
        jTextField_descripcion = new javax.swing.JTextField();
        jTextField_timbrado = new javax.swing.JTextField();
        jTextField_ruc = new javax.swing.JTextField();
        jTextField_moneda = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField_cuenta = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField_total = new javax.swing.JTextField();

        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable_compras_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cuenta", "Debe", "Haber", "Tipo de Imp.", "Impuesto", "Ventas", "Ded.", "Gra.", "IVA"
            }
        ));
        jTable_compras_detalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_compras_detalleMouseClicked(evt);
            }
        });
        jTable_compras_detalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable_compras_detalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_compras_detalle);
        if (jTable_compras_detalle.getColumnModel().getColumnCount() > 0) {
            jTable_compras_detalle.getColumnModel().getColumn(0).setPreferredWidth(2);
            jTable_compras_detalle.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTable_compras_detalle.getColumnModel().getColumn(2).setPreferredWidth(20);
            jTable_compras_detalle.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTable_compras_detalle.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTable_compras_detalle.getColumnModel().getColumn(5).setPreferredWidth(10);
            jTable_compras_detalle.getColumnModel().getColumn(6).setPreferredWidth(10);
            jTable_compras_detalle.getColumnModel().getColumn(7).setPreferredWidth(2);
            jTable_compras_detalle.getColumnModel().getColumn(8).setPreferredWidth(2);
            jTable_compras_detalle.getColumnModel().getColumn(9).setPreferredWidth(2);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Número de comprobante"));

        jTextField_fac_sucursal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_fac_sucursal.setText("001");
        jTextField_fac_sucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_fac_sucursalActionPerformed(evt);
            }
        });
        jTextField_fac_sucursal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_fac_sucursalFocusGained(evt);
            }
        });

        jTextField_fac_caja.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_fac_caja.setText("001");
        jTextField_fac_caja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_fac_cajaFocusGained(evt);
            }
        });

        jTextField_fac_numero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_fac_numero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_fac_numeroFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTextField_fac_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_fac_caja, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_fac_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_fac_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_fac_caja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_fac_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField_comprobante.setText("FACTURA");
        jTextField_comprobante.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comprobante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));
        jTextField_comprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_comprobanteActionPerformed(evt);
            }
        });
        jTextField_comprobante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_comprobanteFocusLost(evt);
            }
        });
        jTextField_comprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_comprobanteKeyPressed(evt);
            }
        });

        jDateChooser_fecha.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser_fecha.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha"));
        jDateChooser_fecha.setDateFormatString("dd-MM-yyyy");
        jDateChooser_fecha.setPreferredSize(new java.awt.Dimension(16, 39));
        jDateChooser_fecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDateChooser_fechaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jDateChooser_fechaFocusLost(evt);
            }
        });

        jTextField_proveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proveedor (ENTER para buscar)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));
        jTextField_proveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_proveedorFocusLost(evt);
            }
        });
        jTextField_proveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_proveedorKeyPressed(evt);
            }
        });

        jTextField_condicion.setText("CONTADO");
        jTextField_condicion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Condición", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));
        jTextField_condicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_condicionKeyPressed(evt);
            }
        });

        jTextField_descripcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción"));
        jTextField_descripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_descripcionFocusLost(evt);
            }
        });

        jTextField_timbrado.setBorder(javax.swing.BorderFactory.createTitledBorder("Timbrado"));
        jTextField_timbrado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_timbradoFocusLost(evt);
            }
        });

        jTextField_ruc.setEditable(false);
        jTextField_ruc.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_ruc.setBorder(javax.swing.BorderFactory.createTitledBorder("R.U.C."));

        jTextField_moneda.setText("GUARANIES");
        jTextField_moneda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Moneda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));
        jTextField_moneda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_monedaKeyPressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exit1.png"))); // NOI18N
        jButton2.setMnemonic('x');
        jButton2.setToolTipText("Alt + X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo_mini.png"))); // NOI18N
        jButton3.setMnemonic('n');
        jButton3.setToolTipText("Alt + N");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField_cuenta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuentas (ENTER para buscar)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));
        jTextField_cuenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_cuentaFocusLost(evt);
            }
        });
        jTextField_cuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_cuentaKeyPressed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gravadas 5%"));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder("Gravadas 10%"));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder("IVA 5%"));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder("IVA 10%"));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField5.setBorder(javax.swing.BorderFactory.createTitledBorder("Exentas"));

        jTextField_total.setEditable(false);
        jTextField_total.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_total.setForeground(new java.awt.Color(0, 102, 51));
        jTextField_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_total.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_ruc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_timbrado)
                        .addGap(494, 494, 494)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField_descripcion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField_total)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_condicion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_proveedor)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_timbrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser_fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_condicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_fac_sucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_fac_sucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_fac_sucursalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Metodos.id_factura_de_compra = 0;
        Metodos.Facturas_de_compra_clear();
        Metodos.Compras_clear_jtable();
        jTextField_proveedor.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField_cuentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_cuentaKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            new Compras_buscar_cuentas().setVisible(true);
        }
    }//GEN-LAST:event_jTextField_cuentaKeyPressed

    private void jTextField_proveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_proveedorKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            new Compras_proveedores_buscar().setVisible(true);
        }
    }//GEN-LAST:event_jTextField_proveedorKeyPressed

    private void jTextField_fac_numeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_fac_numeroFocusLost

        Metodos.Factura_de_compra_guardar();

        jDateChooser_fecha.requestFocus();
    }//GEN-LAST:event_jTextField_fac_numeroFocusLost

    private void jDateChooser_fechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateChooser_fechaFocusGained

    }//GEN-LAST:event_jDateChooser_fechaFocusGained

    private void jTextField_comprobanteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_comprobanteFocusLost
//        Compras.jTextField_proveedor.requestFocus();
    }//GEN-LAST:event_jTextField_comprobanteFocusLost

    private void jTextField_proveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_proveedorFocusLost
//        jTextField_timbrado.requestFocus();
    }//GEN-LAST:event_jTextField_proveedorFocusLost

    private void jTextField_descripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_descripcionFocusLost
        Metodos.Compras_actualizar_fecha();
    }//GEN-LAST:event_jTextField_descripcionFocusLost

    private void jTextField_cuentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_cuentaFocusLost
//        jTextField_fac_sucursal.requestFocus();
    }//GEN-LAST:event_jTextField_cuentaFocusLost

    private void jTextField_fac_sucursalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_fac_sucursalFocusGained
        jTextField_fac_sucursal.selectAll();
    }//GEN-LAST:event_jTextField_fac_sucursalFocusGained

    private void jTextField_fac_cajaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_fac_cajaFocusGained
        jTextField_fac_caja.selectAll();
    }//GEN-LAST:event_jTextField_fac_cajaFocusGained

    private void jTextField_timbradoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_timbradoFocusLost
        Metodos.Timbrado_guardar();
        jTextField_fac_sucursal.requestFocus();
    }//GEN-LAST:event_jTextField_timbradoFocusLost

    private void jTextField_condicionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_condicionKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            new Condicion().setVisible(true);
        }
    }//GEN-LAST:event_jTextField_condicionKeyPressed

    private void jTextField_monedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_monedaKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            new Moneda().setVisible(true);
        }
    }//GEN-LAST:event_jTextField_monedaKeyPressed

    private void jTextField_comprobanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_comprobanteKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            new Comprobante().setVisible(true);
        }
    }//GEN-LAST:event_jTextField_comprobanteKeyPressed

    private void jDateChooser_fechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateChooser_fechaFocusLost
        //  Metodos.Compras_actualizar_fecha();
    }//GEN-LAST:event_jDateChooser_fechaFocusLost

    private void jTextField_comprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_comprobanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_comprobanteActionPerformed

    private void jTable_compras_detalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_compras_detalleMouseClicked
        new Compras_detalle_modificar().setVisible(true);
        Metodos.Compras_detalle_seleccionar_detalle();
    }//GEN-LAST:event_jTable_compras_detalleMouseClicked

    private void jTable_compras_detalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable_compras_detalleKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            new Compras_detalle_modificar().setVisible(true);
            Metodos.Compras_detalle_seleccionar_detalle();
        }
    }//GEN-LAST:event_jTable_compras_detalleKeyPressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Compras().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static com.toedter.calendar.JDateChooser jDateChooser_fecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_compras_detalle;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField_comprobante;
    public static javax.swing.JTextField jTextField_condicion;
    public static javax.swing.JTextField jTextField_cuenta;
    public static javax.swing.JTextField jTextField_descripcion;
    public static javax.swing.JTextField jTextField_fac_caja;
    public static javax.swing.JTextField jTextField_fac_numero;
    public static javax.swing.JTextField jTextField_fac_sucursal;
    public static javax.swing.JTextField jTextField_moneda;
    public static javax.swing.JTextField jTextField_proveedor;
    public static javax.swing.JTextField jTextField_ruc;
    public static javax.swing.JTextField jTextField_timbrado;
    public static javax.swing.JTextField jTextField_total;
    // End of variables declaration//GEN-END:variables
}
