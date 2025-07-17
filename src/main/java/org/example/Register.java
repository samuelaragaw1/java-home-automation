package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Register implements ActionListener {
    JFrame frame;
    JPanel panel;
    JTextField name;
    JTextField password;
    JLabel d;
    JLabel d1;
    JLabel n;
    JButton back;
    Font custom = new Font("Arial", Font.BOLD, 20);
    Font custom1 = new Font("Arial", Font.BOLD, 15);
    JLabel p;
    JButton register1;
    ImageIcon backgroundImage1;

    public Register() {
        //frame
        frame = new JFrame("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);

        //panel
        backgroundImage1 = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/OIP.jpg");

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage1.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        //description
        d = new JLabel("PLEASE ENTER YOUR NAME AND PASSWORD");
        d.setBounds(70, 10,500, 50);
        d.setForeground(Color.WHITE);
        d.setFont(custom);

        //name label
        n = new JLabel("Name");
        n.setForeground(Color.WHITE);
        n.setFont(custom1);
        n.setBounds(200,150,50, 30);

        //password label
        p = new JLabel("Password");
        p.setForeground(Color.WHITE);
        p.setFont(custom1);
        p.setBounds(170,200,100, 30);

        //text password
        password = new JTextField();
        password.setForeground(Color.GRAY);
        password.setBounds(250,200,150,30);


        //text name
        name = new JTextField();
        name.setForeground(Color.GRAY);
        name.setBounds(250,150,150,30);

        //register button
        register1 = new JButton("Register");
        register1.setBounds(250,250,100, 30);

        //status
        d1 = new JLabel("");
        d1.setForeground(Color.GREEN);
        d1.setFont(custom);
        d1.setBounds(20, 300, 550, 50);

        //back
        back = new JButton("Back");
        back.setBounds(270, 500, 100, 30);

        //adding actionlistner
        back.addActionListener(this);
        register1.addActionListener(this);


        //adding
        frame.add(panel);
        panel.add(d);
        panel.add(name);
        panel.add(n);
        panel.add(p);
        panel.add(password);
        panel.add(register1);
        panel.add(d1);
        panel.add(back);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Register();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == register1 ) {

            try {
                the_database.insertUser(name.getText(), password.getText());
                d1.setText("YOUR NAME AND PASSWORD HAS BEEN REGISTERED");
                //Thread.sleep(5000);
                //frame.dispose();
                //new Login_page_final();

            }catch (SQLException E){
                d1.setForeground(Color.RED);
                d1.setBounds(220, 300, 300, 50);
                d1.setText("Registration Failed");
            }

        }
        else if(e.getSource() == back) {
            frame.dispose();
            new Login_page_final();
        }
    }
}
