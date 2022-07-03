/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectogrupo6.Vistas;

import proyectogrupo6.control.Conexion;

/**
 * @author Grupo 6 
 *  Fernandez Valentina
 *  Amieva Agustina
 *  Romero Jorge
 *  Gutierrez Manuel
 */
public class Menu extends javax.swing.JFrame {
    private Conexion conexion;

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.conexion = new Conexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jDPescritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMinicio = new javax.swing.JMenu();
        jMIalumno = new javax.swing.JMenuItem();
        jMImateria = new javax.swing.JMenuItem();
        jMIcursada = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmiConsultas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMIsalir = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jDPescritorio.setPreferredSize(new java.awt.Dimension(1, 475));

        javax.swing.GroupLayout jDPescritorioLayout = new javax.swing.GroupLayout(jDPescritorio);
        jDPescritorio.setLayout(jDPescritorioLayout);
        jDPescritorioLayout.setHorizontalGroup(
            jDPescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );
        jDPescritorioLayout.setVerticalGroup(
            jDPescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );

        jMinicio.setText("Inicio");
        jMinicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMIalumno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMIalumno.setText("Alumnos");
        jMIalumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIalumnoActionPerformed(evt);
            }
        });
        jMinicio.add(jMIalumno);

        jMImateria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMImateria.setText("Materias");
        jMImateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMImateriaActionPerformed(evt);
            }
        });
        jMinicio.add(jMImateria);

        jMIcursada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMIcursada.setText("Cursada");
        jMIcursada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIcursadaActionPerformed(evt);
            }
        });
        jMinicio.add(jMIcursada);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setText("Carga de Notas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMinicio.add(jMenuItem1);

        jmiConsultas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmiConsultas.setText("Consultas");
        jmiConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultasActionPerformed(evt);
            }
        });
        jMinicio.add(jmiConsultas);
        jMinicio.add(jSeparator1);

        jMIsalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMIsalir.setText("Salir");
        jMIsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIsalirActionPerformed(evt);
            }
        });
        jMinicio.add(jMIsalir);

        jMenuBar1.add(jMinicio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPescritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPescritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIalumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIalumnoActionPerformed
        // TODO add your handling code here:
        jDPescritorio.removeAll();
        jDPescritorio.repaint();
        AlumnoView av = new AlumnoView(conexion);
        av.setVisible(true);
        jDPescritorio.add(av);
        jDPescritorio.moveToFront(av);
    }//GEN-LAST:event_jMIalumnoActionPerformed

    private void jMIsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIsalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMIsalirActionPerformed

    private void jMImateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMImateriaActionPerformed
        // TODO add your handling code here:
        jDPescritorio.removeAll();
        jDPescritorio.repaint();
        MateriaView mv = new MateriaView(conexion);
        mv.setVisible(true);
        jDPescritorio.add(mv);
        jDPescritorio.moveToFront(mv);
    }//GEN-LAST:event_jMImateriaActionPerformed

    private void jMIcursadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIcursadaActionPerformed
        // TODO add your handling code here:
        jDPescritorio.removeAll();
        jDPescritorio.repaint();
        CursadaView cv = new CursadaView(conexion);
        cv.setVisible(true);
        jDPescritorio.add(cv);
        jDPescritorio.moveToFront(cv);
    }//GEN-LAST:event_jMIcursadaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        jDPescritorio.removeAll();
        jDPescritorio.repaint();
        CargaNotasView cnv = new CargaNotasView();
        cnv.setVisible(true);
        jDPescritorio.add(cnv);
        jDPescritorio.moveToFront(cnv);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmiConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultasActionPerformed
        // TODO add your handling code here:
        jDPescritorio.removeAll();
        jDPescritorio.repaint();
        ListadoAlumnoMateriaView lamv = new ListadoAlumnoMateriaView(conexion);
        lamv.setVisible(true);
        jDPescritorio.add(lamv);
        jDPescritorio.moveToFront(lamv);
    }//GEN-LAST:event_jmiConsultasActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Menu().setVisible(true);
//                
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDPescritorio;
    private javax.swing.JMenuItem jMIalumno;
    private javax.swing.JMenuItem jMIcursada;
    private javax.swing.JMenuItem jMImateria;
    private javax.swing.JMenuItem jMIsalir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu jMinicio;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem jmiConsultas;
    // End of variables declaration//GEN-END:variables
}
