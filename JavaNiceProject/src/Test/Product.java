/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author NA SysTem
 */
public class Product {
    private int id;
    private String name;
    private float price;
    private String adddate;
    private byte[] picture;
    
    
    
           public Product(int pid,String pname,float pprice,String pAddDate,byte[] pimg)
           {
               this.id=pid;
               this.name=pname;
               this.price=pprice;
               this.adddate=pAddDate;
               this.picture=pimg;
           }
           
           
           public int getId()
           {
               return id;
           }
           
           public String getName()
           {
               return name;
           }
    
            
           public float getPrice()
           {
               return price;
           }
           
           public String getAddDate()
           {
               return adddate;
           }
           
           public byte[] getImage()
           {
               return picture;
           }
    
    
}
