/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

//import com.mysql.jdbc.Connection;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author NA SysTem
 */
public class Main_window extends javax.swing.JFrame {

    /**
     * Creates new form Main_window
     */
    public Main_window() {
        initComponents();
        //getConnection();
        Show_Products_In_JTable();
        
    }
    
    
    
    String ImgPath=null;
    int pos=0;
    public Connection getConnection(){
        Connection con =null;
        try{
          // Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","wordpress","wordpress");
          // JOptionPane.showMessageDialog(null,"connected");
            return con;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Main_window.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,"not connected");
            return null;
        }
    }
    
    
    
        public boolean checkInputs()
        {
            if(txtName.getText()==null || txtPrice.getText()==null || txtAddDate.getDate()==null)
            {
                return false;
            }
            
            else
            {
                  try{
                      Float.parseFloat(txtPrice.getText());
                      return true;
                  }
                  catch(Exception ex)
                  {
                      return false;
                  }
            }
        }
    
    
    
    
    
    
     public ImageIcon ResizeImage(String imagePath, byte[] pic)
     {
         ImageIcon myImage=null;
         
          if(imagePath!=null)
          {
              myImage=new ImageIcon(imagePath);
          }
          
           else
          {
              myImage=new ImageIcon(pic);
          }
           Image img=myImage.getImage();
          Image img2=img.getScaledInstance(lbl_image.getWidth(),lbl_image.getHeight(),Image.SCALE_SMOOTH);
     
        ImageIcon image=new ImageIcon(img2);
        return image;
     
     }
     
     
     
    
    public ArrayList<Product>getProductList()
     {
           ArrayList<Product>productList=new ArrayList<Product>();
             Connection con=getConnection();
             String query="select * from products";
             
             Statement st;
             ResultSet rs;
         try{
           
             st=con.createStatement();
             rs=st.executeQuery(query);
             Product product;
             
               while(rs.next())
               {
                   product=new Product(rs.getInt("id"),rs.getString("name"),Float.parseFloat(rs.getString("price")),rs.getString("add_date"),rs.getBytes("image"));
                   productList.add(product);
               }
             
         }
         
         catch(SQLException ex)
         {
              Logger.getLogger(Main_window.class.getName()).log(Level.SEVERE,null,ex);
          
         }

      
      return productList;
       
     }
     
     
     
       
     
      public void Show_Products_In_JTable()
      {
          ArrayList<Product>list=getProductList();
           DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
           
             Object[] row=new Object[4];
              for(int i=0;i<list.size();i++)
              {
                  row[0]=list.get(i).getId();
                  row[1]=list.get(i).getName();
                  row[2]=list.get(i).getPrice();
                  row[3]=list.get(i).getAddDate();
                  
                  
                  model.addRow(row);
              }
      }
      
      
      
      public void ShowItem(int index)
      {
          txtId.setText(Integer.toString(getProductList().get(index).getId()));
          txtName.setText(getProductList().get(index).getName());
          txtPrice.setText(Float.toString(getProductList().get(index).getPrice()));
          
          try{
              Date addDate=null;
              addDate=new SimpleDateFormat("yyyy-MM-dd").parse((String)getProductList().get(index).getAddDate());
              
              txtAddDate.setDate(addDate);
          }
          catch(ParseException ex)
          {
                 Logger.getLogger(Main_window.class.getName()).log(Level.SEVERE,null,ex);
                 
          
          }
          
          lbl_image.setIcon(ResizeImage(null,getProductList().get(index).getImage()));
          
      }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtAddDate = new com.toedter.calendar.JDateChooser();
        lbl_image = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_chooseimage = new javax.swing.JButton();
        btn_insert = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_previous = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Price");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Add Date");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Image");

        txtName.setPreferredSize(new java.awt.Dimension(59, 50));

        txtPrice.setPreferredSize(new java.awt.Dimension(59, 50));

        txtId.setPreferredSize(new java.awt.Dimension(59, 50));

        txtAddDate.setDateFormatString("yyyy-MM-dd");
        txtAddDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_image.setBackground(new java.awt.Color(204, 255, 255));
        lbl_image.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Add Date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btn_chooseimage.setText("Choose Image");
        btn_chooseimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chooseimageActionPerformed(evt);
            }
        });

        btn_insert.setText("insert");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        btn_update.setText("update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_next.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_next.setText("> Next");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_first.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_first.setText("<| First");
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_last.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_last.setText(">| Last");
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        btn_previous.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_previous.setText("< Previous");
        btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtAddDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btn_insert)
                                .addGap(30, 30, 30)
                                .addComponent(btn_update)
                                .addGap(18, 18, 18)
                                .addComponent(btn_delete))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_previous)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(btn_chooseimage, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(txtAddDate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_insert)
                                    .addComponent(btn_update)
                                    .addComponent(btn_delete))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_next)
                                    .addComponent(btn_first)
                                    .addComponent(btn_previous)
                                    .addComponent(btn_last)))
                            .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_chooseimage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_chooseimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chooseimageActionPerformed
        JFileChooser file=new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter=new FileNameExtensionFilter("*.images","jpg","png");
        
        file.addChoosableFileFilter(filter);
        int result=file.showSaveDialog(null);
         if(result==JFileChooser.APPROVE_OPTION)
         {
             File selectedFile=file.getSelectedFile();
             String path=selectedFile.getAbsolutePath();
             lbl_image.setIcon(ResizeImage(path,null));
             ImgPath=path;
             
         }
         
         else
         {
             System.out.println("no selected image");
         }
    }//GEN-LAST:event_btn_chooseimageActionPerformed

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
       if(checkInputs() && ImgPath!=null)
       {
         
            try{
                  Connection con=getConnection();
                PreparedStatement ps=con.prepareStatement("insert into products(name,price,add_date,image)" + "values(?,?,?,?)");
                
                ps.setString(1,txtName.getText());
                ps.setString(2,txtPrice.getText());
                
                
                
                 SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                 String addDate=dateFormat.format(txtAddDate.getDate());
                 ps.setString(3,addDate);
                 
                 InputStream img = new FileInputStream(new File(ImgPath));
                 ps.setBlob(4,img);
                ps.executeUpdate();
               // Show_Products_In_JTable();
                JOptionPane.showMessageDialog(null,"Data inserted");
            }
                
           
            catch(SQLException ex)
            {
               JOptionPane.showMessageDialog(null,ex.getMessage());
            } 
            
            catch (FileNotFoundException ex) {
               Logger.getLogger(Main_window.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            
            
       }
       else
       {
           JOptionPane.showMessageDialog(null,"one or more field empty");
       }
       
       
       System.out.println("Name=>"+txtName.getText());
        System.out.println("Price=>"+txtPrice.getText());
         System.out.println("Image=>"+ImgPath);
    }//GEN-LAST:event_btn_insertActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
      if(checkInputs() && txtId.getText()!=null)
      {
          String UpdateQuery=null;
          PreparedStatement ps=null;
          Connection con=getConnection();
          
            if(ImgPath==null)
            {
                 try{
                      UpdateQuery="update products set name=?, price=?"+ ", add_date=? where id=?";
                 
                      ps=con.prepareStatement(UpdateQuery);
                     
                 
                    ps.setString(1,txtName.getText());
                ps.setString(2,txtPrice.getText());
                
                
                
                 SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                 String addDate=dateFormat.format(txtAddDate.getDate());
                 
                 
                 ps.setString(3, addDate);
                 ps.setInt(4,Integer.parseInt(txtId.getText()));
                 
                 ps.executeUpdate();
                 //Show_Products_In_JTable();
                 
                 JOptionPane.showMessageDialog(null,"Data updated");
                 
                 }
                 
                  catch(SQLException ex)
                  {
                       Logger.getLogger(Main_window.class.getName()).log(Level.SEVERE,null,ex);
          
                  }
               
            }
            
            
            else
            {
                try{
                       InputStream img = new FileInputStream(new File(ImgPath));
                  UpdateQuery="update products set name=?, price=?"+ ", add_date=?,image=? where id=?";
                 
                    
                ps=con.prepareStatement(UpdateQuery);
                     
                 
                ps.setString(1,txtName.getText());
                ps.setString(2,txtPrice.getText());
                
                
                
                 SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                 String addDate=dateFormat.format(txtAddDate.getDate());
                 
                 
                 ps.setString(3, addDate);
                 ps.setBlob(4, img);
                 ps.setInt(5,Integer.parseInt(txtId.getText()));
                
                ps.executeUpdate();
               // Show_Products_In_JTable();
                 JOptionPane.showMessageDialog(null,"Data updated");
                 
                
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
            
            
            
            
            
      }
      
      else
      {
          JOptionPane.showMessageDialog(null,"wrong input");
      }
      
      
      
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        pos=0;
        ShowItem(pos);
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
    pos++;
    if(pos>=getProductList().size())
      {
        pos=getProductList().size()-1;
      }
    ShowItem(pos);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousActionPerformed
       pos--;
       if(pos<0)
       {
           pos=0;
       }
       ShowItem(pos);
    }//GEN-LAST:event_btn_previousActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        pos=getProductList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if(!txtId.getText().equals(""))
        {
            try{
                Connection con=getConnection();
                PreparedStatement ps=con.prepareStatement("delete from products where id=?");
                int id=Integer.parseInt(txtId.getText());
                ps.setInt(1,id);
                ps.executeUpdate();
                
                 JOptionPane.showMessageDialog(null,"Data deleted");
                 
                        
                
                }
                catch(SQLException ex)
                 {
                   Logger.getLogger(Main_window.class.getName()).log(Level.SEVERE,null,ex);
                  JOptionPane.showMessageDialog(null,"Data not deleted,Please enter product id number");
                
                 }
            }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     int index=jTable1.getSelectedRow();
     ShowItem(index);
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Main_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chooseimage;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_image;
    private com.toedter.calendar.JDateChooser txtAddDate;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
