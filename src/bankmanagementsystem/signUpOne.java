package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class signUpOne extends JFrame implements ActionListener{
    long random;
    JTextField nTextField,fTextField,eTextField,aTextField,cTextField,sTextField,pTextField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser date;
    JLabel formno;
    

    signUpOne(){
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        formno = new JLabel("Application form no: " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel persnolDetails = new JLabel("Page 1 : Personal Details");
        persnolDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        persnolDetails.setBounds(290, 80, 400, 30);
        add(persnolDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);
        add(name);

        nTextField = new JTextField();
        nTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nTextField.setBounds(300, 140, 400, 30);
        add(nTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fTextField = new JTextField();
        fTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fTextField.setBounds(300, 190, 400, 30);
        add(fTextField);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 300, 30);
        add(dob);

        date = new JDateChooser();
        date.setBounds(300, 240, 400, 30);
        date.setForeground(new Color(105, 105, 105));
        add(date);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 300, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(360, 290, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup button = new ButtonGroup();
        button.add(male);
        button.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 300, 30);
        add(email);

        eTextField = new JTextField();
        eTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        eTextField.setBounds(300, 340, 400, 30);
        add(eTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 300, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(405, 390, 130, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(540, 390, 170, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup marriedButton = new ButtonGroup();
        marriedButton.add(married);
        marriedButton.add(unmarried);
        marriedButton.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 300, 30);
        add(address);

        aTextField = new JTextField();
        aTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aTextField.setBounds(300, 440, 400, 30);
        add(aTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 300, 30);
        add(city);

        cTextField = new JTextField();
        cTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cTextField.setBounds(300, 490, 400, 30);
        add(cTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 300, 30);
        add(state);

        sTextField = new JTextField();
        sTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        sTextField.setBounds(300, 540, 400, 30);
        add(sTextField);

        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 590, 300, 30);
        add(pin);

        pTextField = new JTextField();
        pTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pTextField.setBounds(300, 590, 400, 30);
        add(pTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String form = ""+random;
        String name = nTextField.getText();
        String fname = fTextField.getText();
        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = eTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }
        String address = aTextField.getText();
        String city = cTextField.getText();
        String state = sTextField.getText();
        String pin = pTextField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
               // Connection con = Conn.createConnection();
               // Statement st = con.createStatement();
               Conn con = new Conn();
                String query = "INSERT INTO signup (formno, name, fname, dob, gender, email, marital, address, city, pin, state) VALUES ('" + form + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + pin + "', '" + state + "')";
                con.s.executeUpdate(query);
                
                setVisible(false);
                new SignUp2(form).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new signUpOne();
    }
}
