/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package try_ddd.try_ddd.swingxgui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import try_ddd.try_ddd.domain.comic.Borrow;
import try_ddd.try_ddd.domain.comic.Comic;
import try_ddd.try_ddd.domain.comic.ComicCollection;
import try_ddd.try_ddd.domain.comic.Copy;

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
        
        
        
        Map<Comic, List<Copy>> map = SwingGuiMain.getComicCollection().getAvailableComics();
        
        Set<Comic> comics = map.keySet();
        
        ArrayList<Comic> comicList = new ArrayList<>();
        
        comicList.addAll(comics);
        
        TableModel dataModel = new AbstractTableModel(){
          public int getColumnCount() { return 3; }
          public int getRowCount() { return comicList.size();}
          public Object getValueAt(int row, int col) { 
              Comic comic = comicList.get(row);
              switch(col){
                  case 0:
                      return comic.getNum();
                  case 1:
                      return comic.getTitle();
                  case 2:
                      return comic.getYear();
                  default:
                      throw new IllegalArgumentException("Comic only supports columns 0 to 2");
              }
          
            }
        };
        
        JTable table = new JTable(dataModel);
        JScrollPane scrollPane = new JScrollPane(table);
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 63)
                .addComponent(manageBorrow)
                .addComponent(scrollPane)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 87)
                .addComponent(manageBorrow)
                .addGap(10)
                .addComponent(scrollPane)
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
    private ArrayList<Comic> borrowList;
    
    
    
}
