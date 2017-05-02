/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package try_ddd.try_ddd.swingxgui;

import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author lucius
 */
public class MainJPanel extends JPanel {
    
    private SwingGuiMain topFrame;
    
    public MainJPanel(){
        initComponents();
        
    }
    
    
    public void initComponents(){
        manageBorrow = new javax.swing.JButton();

        

        manageBorrow.setText("Manage Borrow");
        manageBorrow.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBorrowActionPerformed(evt);
            }

            
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(manageBorrow)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(manageBorrow)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        

    }
    
    private void manageBorrowActionPerformed(ActionEvent evt) {
        JFrame topFrame = (SwingGuiMain) SwingUtilities.getWindowAncestor(this);
        
        topFrame.remove(this);
        topFrame.add(SwingGuiMain.ADD_COPY_PANEL);
        topFrame.pack();
        
    }
    
    
    private javax.swing.JButton manageBorrow;
    
    
    
}
