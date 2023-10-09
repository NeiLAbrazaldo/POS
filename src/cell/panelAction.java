/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Neil
 */
public class panelAction extends javax.swing.JPanel {

    /**
     * Creates new form panelAction
     */
    public panelAction() {
        initComponents();
    }
    public void  initEvent (TableActionEvent event, int row) {
    
        /*cmdEdit.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent ae) {
        event.onEdit(row);
        }
        });*/
        cmdDelete.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent ae) {
        event.onDelete(row);
        }
        });
        /*cmdView.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent ae) {
        event.onView(row);
        }
        });*/
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdDelete = new cell.ActionButton();

        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAndGIF/delete 15x15.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cell.ActionButton cmdDelete;
    // End of variables declaration//GEN-END:variables
}
