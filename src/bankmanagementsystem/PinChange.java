/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;



public class PinChange extends JFrame implements ActionListener{
    
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image l2 = l1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel image = new JLabel(l3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,20);
        image.add(text);
        
        
        JLabel pintext = new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
        
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        
        
        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==change){
       try{
           String npin=pin.getText();
           String rpin = repin.getText();
           
           if(!npin.equals(rpin)){
               JOptionPane.showMessageDialog(null, "Entered PIN does not match");
               return;
           }
           
           if(npin.equals("")){
               JOptionPane.showMessageDialog(null, "Please enter new PIN");
               return;
           }
            if(rpin.equals("")){
               JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
               return;
           }
           // Connection con = Conn.createConnection();
            //    Statement st = con.createStatement();
            Conn con = new Conn();
           String query1 = "update bank set pin = '"+rpin+"' where pin= '"+pinnumber+"'";
           String query2 = "update login set pin = '"+rpin+"' where pin= '"+pinnumber+"'";
           String query3 = "update signup3 set pin = '"+rpin+"' where pin= '"+pinnumber+"'";
           
           con.s.executeUpdate(query1);
           con.s.executeUpdate(query2);
           con.s.executeUpdate(query3);
           
      JOptionPane.showMessageDialog(null, "PIN changed successfully");
       
       setVisible(false);
       new Transaction(rpin).setVisible(true);
           
       }
       catch(Exception e){
           System.out.println(e);
           
       }
       }else {
              setVisible(false);
           
              new Transaction(pinnumber).setVisible(true);
               }
    }
    
    
    public static void main(String []args){
        new PinChange("").setVisible(true);
        
    }

    
    
    
}
