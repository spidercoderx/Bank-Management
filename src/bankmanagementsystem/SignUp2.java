package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp2 extends JFrame implements ActionListener{
    long random;
    JTextField pan,adar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,Occupation,educational ,incomecatego;
    String form;

    SignUp2(String form){
        this.form=form;
        setLayout(null);
         
        setTitle("New Account Application Form - Page 2");

       

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);
        add(name);
        String listReligion[]= {"Enter Your Religion", "Hindu","Jain","Sikh","Muslim","Christian","Other"};
        religion = new JComboBox(listReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
       
       
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String valcategory[]={"Enter your Category","General","OBC","SC/ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
         
       
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 300, 30);
        add(dob);
        
        String incomeco[]={"Enter Your Income","Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 5,00,000"};
          incomecatego = new JComboBox(incomeco);
        incomecatego.setBounds(300, 240, 400, 30);
        incomecatego.setBackground(Color.WHITE);
        add(incomecatego);

     

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 320, 300, 30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 300, 30);
        add(email);

         String educationalvalue[]={"Enter Your Education","Non-Gradution","Undergradution","Post-Gradution","Doctrate","Other"};
          educational = new JComboBox(educationalvalue);
        educational.setBounds(300, 340, 400, 30);
        educational.setBackground(Color.WHITE);
        add(educational);

       
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 300, 30);
        add(marital);

        String Occupationvalue[]={"Enter Your Occupation","Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
          Occupation = new JComboBox(Occupationvalue);
        Occupation.setBounds(300, 390, 400, 30);
        Occupation.setBackground(Color.WHITE);
        add(Occupation);

        

        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 300, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel city = new JLabel("Adar Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 300, 30);
        add(city);

        adar = new JTextField();
        adar.setFont(new Font("Raleway", Font.BOLD, 14));
        adar.setBounds(300, 490, 400, 30);
        add(adar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 300, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(405, 540, 130, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

       

        ButtonGroup smarriedButton = new ButtonGroup();
        smarriedButton.add(syes);
        smarriedButton.add(sno);
        

        JLabel pinno = new JLabel("Existing Acoount:");
        pinno.setFont(new Font("Raleway", Font.BOLD, 20));
        pinno.setBounds(100, 590, 300, 30);
        add(pinno);

       
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(405, 590, 130, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

       

        ButtonGroup emarriedButton = new ButtonGroup();
        emarriedButton.add(eyes);
        emarriedButton.add(eno);

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
        String form = "" + random;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) incomecatego.getSelectedItem();
        String seducation = (String) educational.getSelectedItem();
        String soccupation = (String) Occupation.getSelectedItem();
        String seniorcitizien = null;
        if (syes.isSelected()) {
            seniorcitizien = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizien = "No";
        }
       
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Married";
        } else if (eno.isSelected()) {
            existingaccount = "Unmarried";
        } 
        String span = pan.getText();
        String sadar = adar.getText();
        

        try {
           
               // Connection con = Conn.createConnection();
               // Statement st = con.createStatement();
               Conn con = new Conn();
                String query = "INSERT INTO signup2 (form,sreligion, scategory, sincome, seducation, soccupation,span, sadar, seniorcitizien, existingaccount) VALUES ('" + form + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + sadar + "', '" + seniorcitizien + "', '" + existingaccount + "')";
                con.s.executeUpdate(query);
            
                //signup3 object;
                setVisible(false);
                new signup3(form).setVisible(true);
                
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUp2("");
    }
}
