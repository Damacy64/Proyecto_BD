package banco.vista;

import banco.modelo.Cliente;
import banco.modelo.Cuenta;
import banco.modelo.DAOCliente;
import banco.modelo.DAOCuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pzx64
 */
public class Transferencias extends javax.swing.JInternalFrame {

    /**
     * Creates new form Transferencias
     */
    public Transferencias() {
        initComponents();
    }

    public void obtenerClientes() {
        List<Cliente> clientes = new DAOCliente().registros();
        jComboBox1.removeAll();
        jComboBox1.addItem("");
        for (Cliente cl : clientes) {
            jComboBox1.addItem(cl.getRfc() + " - " + cl.getNombre());
        }

        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerCuentas();
            }
        });

    }

    public void obtenerCuentas() {
        if (jComboBox1.getSelectedIndex() > 0) {
            String seleccion = (String) jComboBox1.getSelectedItem();
            String[] datos = seleccion.split(" ");
            String rfc = datos[0].trim();
            List<Cuenta> cuentas = new DAOCuenta().registros(rfc);
            jComboBox2.removeAllItems();
            jComboBox2.addItem("");
            for (Cuenta cta : cuentas) {
                jComboBox2.addItem(cta.getNo_cuenta() + " - Saldo: " + cta.getSaldo());
            }
        }
    }
    
    public void obtenerClientesD() {
        List<Cliente> clientes = new DAOCliente().registros();
        jComboBox3.removeAll();
        jComboBox3.addItem("");
        for (Cliente cl : clientes) {
            jComboBox3.addItem(cl.getRfc() + " - " + cl.getNombre());
        }

        jComboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerCuentasD();
            }
        });

    }

    public void obtenerCuentasD() {
        if (jComboBox3.getSelectedIndex() > 0) {
            String seleccion = (String) jComboBox3.getSelectedItem();
            String[] datos = seleccion.split(" ");
            String rfc = datos[0].trim();
            List<Cuenta> cuentas = new DAOCuenta().registros(rfc);
            jComboBox4.removeAllItems();
            jComboBox4.addItem("");
            for (Cuenta cta : cuentas) {
                jComboBox4.addItem(cta.getNo_cuenta() + " - Saldo: " + cta.getSaldo());
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("ClienteO");

        jLabel2.setText("CuentaO");

        jLabel3.setText("Monto");

        jLabel4.setText("ClienteD");

        jLabel5.setText("CuentaD");

        jButton1.setText("Transferir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2, 0, 110, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox4, 0, 110, Short.MAX_VALUE)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String seleccion = (String) jComboBox2.getSelectedItem();
        String[] datos = seleccion.split("-");
        String noCuenta = datos[0].trim();

        String seleccionD = (String) jComboBox4.getSelectedItem();
        String[] datosD = seleccionD.split("-");
        String noCuentaD = datosD[0].trim();

        String monto = jTextField1.getText();

        if (!monto.equals("") && !noCuenta.equals("") && !noCuentaD.equals("")) {
            double montoDep = Double.valueOf(monto);
            int no_cuenta = Integer.valueOf(noCuenta);
            int no_cuentaD = Integer.valueOf(noCuentaD);
            int res = new DAOCuenta().transferir(no_cuenta,no_cuentaD, montoDep);
            if (res > 0) {
                JOptionPane.showMessageDialog(rootPane, "Transferencia realizada");
                jComboBox1.setSelectedIndex(0);
                jComboBox2.removeAllItems();
                jComboBox3.setSelectedIndex(0);
                jComboBox4.removeAllItems();
                jTextField1.setText("");
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
