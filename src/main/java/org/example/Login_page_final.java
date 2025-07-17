package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Login_page_final implements ActionListener {
    JFrame j;
    JButton b1;
    JTextField t1;
    JTextField t2; // Using JPasswordField for password
    JLabel l;
    Font customfont = new Font("Arial", Font.BOLD, 20);
    Font customfont1 = new Font("Arial", Font.BOLD, 15);
    JLabel l1;
    JLabel l2;
    JLabel l3;
    ImageIcon backgroundImage;
    JButton register;

    Login_page_final() {
        j = new JFrame("LOGIN PAGE");
        j.setSize(650, 700);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);

        // Load the background image
        backgroundImage = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/OIP.jpg");

        // Create a custom JPanel to paint the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        j.setContentPane(backgroundPanel);

        l = new JLabel("WELCOME");

        l.setBounds(280,25,200,100);
        l.setFont(customfont);
        l.setForeground(Color.WHITE);
        //l.setFont(Font.);
        j.add(l);

        l1 = new JLabel("UserName:");
        l1.setBounds(175, 125, 100, 30);
        l1.setFont(customfont1);
        l1.setForeground(Color.WHITE);
        j.add(l1);

        l2 = new JLabel("Password:");
        l2.setBounds(180, 175, 75, 30);
        l2.setFont(customfont1);
        l2.setForeground(Color.WHITE);
        j.add(l2);

        l3 = new JLabel("");
        l3.setBounds(140, 290, 400, 30);
        l3.setFont(customfont1);// Adjusted width
        l3.setForeground(Color.red);
        j.add(l3);

        t1 = new JTextField(20);
        t1.setBounds(260, 125, 150, 30);
        t1.setBackground(Color.lightGray);
        j.add(t1);

        t2 = new JTextField(20);// Using JPasswordField for password
        t2.setBounds(260, 175, 150, 30);
        t2.setBackground(Color.lightGray);
        j.add(t2);

        register = new JButton("register");
        register.setBounds(350, 250, 100, 30);
        j.add(register);


        b1 = new JButton("Login");
        b1.setBounds(230, 250, 100, 30);
        j.add(b1);

        // Add action listener
        b1.addActionListener(this);
        register.addActionListener(this);

        j.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String username = t1.getText();
            String password = t2.getText();


            if (the_database.isRegisteredUser(username, password)) {
                j.dispose();
                new MainPage(username);
            } else {
                l3.setText("PLEASE ENTER CORRECT USERNAME AND PASSWORD");
            }
        }
        else if (e.getSource() == register) {
            j.dispose();
            new Register();
        }
    }
    public static void main(String[] args) {
        new Login_page_final();
    }
}
