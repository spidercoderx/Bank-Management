package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton exit;
    JLabel mini;

    MiniStatement(String pin) {
        super("Mini Statement");

       

        mini = new JLabel();
        mini.setBounds(20, 140, 360, 200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        
        add(card);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        
        

        try {
            Conn con = new Conn();
            // Retrieve card number
            ResultSet rs = con.s.executeQuery("SELECT * FROM login WHERE pin = '" + pin + "'");
            if (rs.next()) {
                String cardNumber = rs.getString("cardnumber");
                card.setText("Card Number: " + cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12));
               System.out.print(cardNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int balance = 0;
            Conn con = new Conn();
            // Retrieve bank transactions
            ResultSet rs = con.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            StringBuilder miniStatement = new StringBuilder();
            while (rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");
                miniStatement.append("<html>").append(date).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(type).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(amount).append("<br><br></html>");
                
                if (type.equals("Deposit")) {
                    balance -= Integer.parseInt(amount);
                } else {
                    balance += Integer.parseInt(amount);
                }
            }
            mini.setText(miniStatement.toString());
            l4.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBounds(20, 500, 100, 25);
        add(exit);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);
    }
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        // Pass a valid PIN to test
        new MiniStatement("").setVisible(true);
    }
}
