
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balancequiry,exit;
   String pin;
    Transaction(String pin){
        this.pin = pin;
        setLayout(null);
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image l2 = l1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon  l3 = new ImageIcon(l2);
       
        JLabel image = new JLabel(l3);
         image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
         deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
         withdrawl.addActionListener(this);
        image.add(withdrawl);
        
         fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
         pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
         image.add(pinchange);
        
           balancequiry = new JButton("Balance Enquiry");
        balancequiry.setBounds(355,485,150,30);
        balancequiry.addActionListener(this);
        image.add(balancequiry);
        
        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
         image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
    //   setUndecorated(true);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }else if (ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if (ae.getSource()== withdrawl){
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
            
        }
        else if (ae.getSource()== fastcash){
            setVisible(false);
            new Fastcash(pin).setVisible(true);
            
        }
        else if (ae.getSource()==pinchange){
            setVisible(false);
              new PinChange(pin).setVisible(true);
        }else if(ae.getSource()==balancequiry){
             setVisible(false);
              new BalenceEnquiry(pin).setVisible(true);
        }else if(ae.getSource()== ministatement ){
             new MiniStatement(pin).setVisible(true);
        }
    }
    public static void main(String args[]){
        Transaction transaction = new Transaction("");
    }
}
