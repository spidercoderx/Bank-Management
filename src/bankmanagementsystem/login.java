package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    JButton Login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    login() {
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");

        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image l2 = l1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);

        JLabel label = new JLabel(l3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardNo = new JLabel("Card No.:");
        cardNo.setFont(new Font("Raieway", Font.BOLD, 28));
        cardNo.setBounds(120, 150, 150, 30);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pinno = new JLabel("Pin:");
        pinno.setFont(new Font("Raieway", Font.BOLD, 28));
        pinno.setBounds(120, 220, 250, 30);
        add(pinno);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        Login = new JButton("SIGN IN");
        Login.setBounds(300, 300, 100, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == Login) {
           Conn conn = new Conn();
           String cardnumber = cardTextField.getText();
           String pin = pinTextField.getText();
          String query = "select * from login where cardnumber = '" + cardnumber + "' and pin = '" + pin + "'";
            try {
                //Connection con = conn.createConnection();
                //Statement st = con.createStatement();
                Conn con = new Conn();
                ResultSet rs = con.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number/Pin");
                }
            } catch (Exception e) {
                System.out.print(e);
            }

         } else if (ae.getSource() == signup) {
            // Signup logic here
            setVisible(false);
            new signUpOne().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new login();
    }
}
