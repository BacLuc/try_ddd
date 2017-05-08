/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package try_ddd.try_ddd.swingxgui;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import try_ddd.try_ddd.domain.comic.ComicCollection;
import try_ddd.try_ddd.domain.comic.testdata.ComicGenerator;

/**
 *
 * @author lucius
 */
public class SwingGuiMain extends JFrame {
    
    private GroupLayout groupLayout;
    
    private static ComicCollection collection = ComicGenerator.fillWithCopies(new ComicCollection());
    
    public SwingGuiMain() throws ParseException{
      
       
       initComponents();
    }
    
    
    public static final JPanel MAIN_JPANEL = new MainJPanel();
    
    public static final JPanel ADD_COPY_PANEL = new AddCopyPanel();
    
    
    public static final JPanel DEFAULT_JPANEL = SwingGuiMain.MAIN_JPANEL;
    
    private JPanel currentPanel = this.MAIN_JPANEL;
    

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.add(MAIN_JPANEL);
        pack();
    }
    
    
    public void switchJPanel(JPanel newPanel){
        getContentPane().remove(this.currentPanel);
        this.currentPanel = newPanel;
        getContentPane().add(newPanel);
        pack();
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SwingGuiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SwingGuiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SwingGuiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SwingGuiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                try {
                    new SwingGuiMain().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(SwingGuiMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    public static ComicCollection getComicCollection(){
        return SwingGuiMain.collection;
    }
    
    
}
