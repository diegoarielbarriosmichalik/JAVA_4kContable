package FORM;

import DEV.Metodos;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;

public class Ventas_agregar_detalle extends javax.swing.JFrame {

    public Ventas_agregar_detalle() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Detalle");
        new File(".").getAbsolutePath();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icon.png")).getImage());
        //  jTextField_cuenta.setText(Metodos.cuenta);

        jTextField_gravadas10.requestFocus();
        jTextField_gravadas10.selectAll();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField_gravadas10 = new javax.swing.JTextField();
        jTextField_gravadas_5 = new javax.swing.JTextField();
        jTextField_iva5 = new javax.swing.JTextField();
        jTextField_exentas = new javax.swing.JTextField();
        jTextField_iva10 = new javax.swing.JTextField();
        jTextField_total = new javax.swing.JTextField();
        jButton_terminar = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField_gravadas10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_gravadas10.setBorder(javax.swing.BorderFactory.createTitledBorder("Gravadas 10%"));
        jTextField_gravadas10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_gravadas10ActionPerformed(evt);
            }
        });
        jTextField_gravadas10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_gravadas10FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_gravadas10FocusLost(evt);
            }
        });
        jTextField_gravadas10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_gravadas10KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_gravadas10KeyReleased(evt);
            }
        });

        jTextField_gravadas_5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_gravadas_5.setBorder(javax.swing.BorderFactory.createTitledBorder("Gravadas 5%"));
        jTextField_gravadas_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_gravadas_5ActionPerformed(evt);
            }
        });
        jTextField_gravadas_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_gravadas_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_gravadas_5FocusLost(evt);
            }
        });
        jTextField_gravadas_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_gravadas_5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_gravadas_5KeyReleased(evt);
            }
        });

        jTextField_iva5.setEditable(false);
        jTextField_iva5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_iva5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_iva5.setBorder(javax.swing.BorderFactory.createTitledBorder("I.V.A. 5%"));
        jTextField_iva5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_iva5FocusGained(evt);
            }
        });
        jTextField_iva5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_iva5KeyPressed(evt);
            }
        });

        jTextField_exentas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_exentas.setBorder(javax.swing.BorderFactory.createTitledBorder("Exentas"));
        jTextField_exentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_exentasActionPerformed(evt);
            }
        });
        jTextField_exentas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_exentasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_exentasFocusLost(evt);
            }
        });
        jTextField_exentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_exentasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_exentasKeyReleased(evt);
            }
        });

        jTextField_iva10.setEditable(false);
        jTextField_iva10.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_iva10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_iva10.setBorder(javax.swing.BorderFactory.createTitledBorder("I.V.A. 10%"));
        jTextField_iva10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_iva10FocusGained(evt);
            }
        });
        jTextField_iva10.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jTextField_iva10CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jTextField_iva10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_iva10KeyPressed(evt);
            }
        });

        jTextField_total.setEditable(false);
        jTextField_total.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField_total.setForeground(new java.awt.Color(0, 102, 0));
        jTextField_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_total.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));
        jTextField_total.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_totalFocusGained(evt);
            }
        });
        jTextField_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_totalKeyPressed(evt);
            }
        });

        jButton_terminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/terminar_mini.jpg"))); // NOI18N
        jButton_terminar.setMnemonic('g');
        jButton_terminar.setToolTipText("Alt + G");
        jButton_terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_terminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_iva10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_iva5))
                            .addComponent(jTextField_exentas, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField_gravadas_5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_gravadas10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField_total, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_terminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField_gravadas10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_gravadas_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField_exentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_iva10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_iva5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_terminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_terminarActionPerformed
        Metodos.Ventas_detalle_guardar();
        this.setVisible(false);
    }//GEN-LAST:event_jButton_terminarActionPerformed

    private void jTextField_gravadas10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_gravadas10KeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ESCAPE)) {
            this.setVisible(false);
            Ventas.jTextField_cuenta.requestFocus();
            Ventas.jTextField_cuenta.selectAll();
        }

        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            Metodos.Ventas_agregar_detalle_calculo_gravada10();
            jTextField_gravadas_5.requestFocus();
            jTextField_gravadas_5.selectAll();
        }
    }//GEN-LAST:event_jTextField_gravadas10KeyPressed

    private void jTextField_gravadas10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_gravadas10FocusLost

    }//GEN-LAST:event_jTextField_gravadas10FocusLost

    private void jTextField_gravadas10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_gravadas10KeyReleased
        jTextField_gravadas10.setText(Metodos.getSepararMiles(jTextField_gravadas10.getText().replace(".", "")));
    }//GEN-LAST:event_jTextField_gravadas10KeyReleased

    private void jTextField_gravadas10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_gravadas10FocusGained
        jTextField_gravadas10.selectAll();
    }//GEN-LAST:event_jTextField_gravadas10FocusGained

    private void jTextField_gravadas_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_gravadas_5FocusGained
        jTextField_gravadas_5.selectAll();
    }//GEN-LAST:event_jTextField_gravadas_5FocusGained

    private void jTextField_iva10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_iva10FocusGained
        jTextField_iva10.selectAll();
    }//GEN-LAST:event_jTextField_iva10FocusGained

    private void jTextField_iva5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_iva5FocusGained
        jTextField_iva5.selectAll();
    }//GEN-LAST:event_jTextField_iva5FocusGained

    private void jTextField_exentasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_exentasFocusGained
        jTextField_exentas.selectAll();
    }//GEN-LAST:event_jTextField_exentasFocusGained

    private void jTextField_totalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_totalFocusGained
        jTextField_total.selectAll();
    }//GEN-LAST:event_jTextField_totalFocusGained

    private void jTextField_gravadas10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_gravadas10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_gravadas10ActionPerformed

    private void jTextField_gravadas_5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_gravadas_5KeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ESCAPE)) {
            this.setVisible(false);
        }
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            Metodos.Ventas_agregar_detalle_calculo_gravada5();
            jTextField_exentas.requestFocus();
            jTextField_exentas.selectAll();
        }
    }//GEN-LAST:event_jTextField_gravadas_5KeyPressed

    private void jTextField_iva10CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField_iva10CaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_iva10CaretPositionChanged

    private void jTextField_iva10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_iva10KeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ESCAPE)) {
            this.setVisible(false);
        }

    }//GEN-LAST:event_jTextField_iva10KeyPressed

    private void jTextField_iva5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_iva5KeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ESCAPE)) {
            this.setVisible(false);
        }

    }//GEN-LAST:event_jTextField_iva5KeyPressed

    private void jTextField_exentasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_exentasKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ESCAPE)) {
            this.setVisible(false);
        }
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            Metodos.Ventas_agregar_detalle_calculo_exentas();
            jButton_terminar.requestFocus();
        }

    }//GEN-LAST:event_jTextField_exentasKeyPressed

    private void jTextField_totalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_totalKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ESCAPE)) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_jTextField_totalKeyPressed

    private void jTextField_gravadas_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_gravadas_5FocusLost

    }//GEN-LAST:event_jTextField_gravadas_5FocusLost

    private void jTextField_gravadas_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_gravadas_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_gravadas_5ActionPerformed

    private void jTextField_exentasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_exentasFocusLost

    }//GEN-LAST:event_jTextField_exentasFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jTextField_gravadas10.selectAll();
    }//GEN-LAST:event_formWindowOpened

    private void jTextField_exentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_exentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_exentasActionPerformed

    private void jTextField_gravadas_5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_gravadas_5KeyReleased
        jTextField_gravadas_5.setText(Metodos.getSepararMiles(jTextField_gravadas_5.getText().replace(".", "")));
    }//GEN-LAST:event_jTextField_gravadas_5KeyReleased

    private void jTextField_exentasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_exentasKeyReleased
        jTextField_exentas.setText(Metodos.getSepararMiles(jTextField_exentas.getText().replace(".", "")));
    }//GEN-LAST:event_jTextField_exentasKeyReleased

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas_agregar_detalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Ventas_agregar_detalle().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_terminar;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField jTextField_exentas;
    public static javax.swing.JTextField jTextField_gravadas10;
    public static javax.swing.JTextField jTextField_gravadas_5;
    public static javax.swing.JTextField jTextField_iva10;
    public static javax.swing.JTextField jTextField_iva5;
    public static javax.swing.JTextField jTextField_total;
    // End of variables declaration//GEN-END:variables
}
