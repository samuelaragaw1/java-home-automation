package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


class MainPage implements ActionListener {

    //MAIN PAGE CONTENTS
    String moded;
    JPanel backgroundPanel;
    JLabel wc;
    Font custom = new Font("Arial", Font.BOLD, 20);
    JFrame j1;
    JButton b1;
    JButton b2;
    JButton b3;
    JPanel p1;
    JPanel p2;
    JPanel p3;
    JPanel p4;
    ImageIcon backgroundImage;


    //Other PAGE
    JPanel acm;
    JLabel dac;
    JLabel dac1;
    JButton acm_b1;
    JButton acm_b2;
    JButton acm_b3;
    JButton acm_b4;


    MainPage(String name) {

        j1 = new JFrame();
        j1.setTitle("MainPage");
        j1.setSize(600, 700);
        j1.setLocationRelativeTo(null);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        backgroundImage = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/photo2.jpg");

        //background
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridLayout(4,1,10,10));
        j1.add(backgroundPanel);


        //for text
        wc = new JLabel("WELCOME " + name.toUpperCase());
        wc.setFont(custom);
        wc.setForeground(Color.white);

        //for bulb
        ImageIcon icon = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/bulb1.jpg");
        b1 = new JButton(icon);
        b1.setBounds(200, 10,200, 120 );


        //ac
        ImageIcon icon1 = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/temp.jpg");
        b2 = new JButton(icon1);
        b2.setBounds(200, 10,200, 120 );

        //window
        ImageIcon icon2 = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/window.PNG");
        b3 = new JButton(icon2);
        b3.setBounds(200, 10,200, 120 );

        //panel 1
        ImageIcon background1 = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/photo2_1.PNG");
        p1 = new JPanel();
        p1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background1.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        p1.setLayout(new FlowLayout());
        p1.add(wc);

        //panel 2
        ImageIcon background2 = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/photo2_2.PNG");
        p2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background2.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        p2.setLayout(null);
        p2.add(b1);

        //panel 3
        p3 = new JPanel();
        ImageIcon background3 = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/photo2_3.PNG");
        p3 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background3.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        p3.setLayout(null);
        p3.add(b2);

        //panel 4
        ImageIcon background4 = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/photo2_4.PNG");
        p4 = new JPanel();
        p4 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background4.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        p4.setLayout(null);
        p4.add(b3);




        backgroundPanel.add(p1, 0);
        backgroundPanel.add(p2, 1);
        backgroundPanel.add(p3, 2);
        backgroundPanel.add(p4, 3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        j1.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            moded = "AC";
            EXpage("AC");
        }
        else if (e.getSource() == b1) {
            moded = "BULB";
            EXpage("BULB");
        }
        else if (e.getSource() == b3) {
            moded = "WINDOW";
            EXpage("WINDOW");
        }



        else if (e.getSource() == acm_b4) {
            acm.setVisible(false);
            backgroundPanel.setVisible(true);
        }

        //auto button
        else if (e.getSource() == acm_b1) {
            if (moded == "AC"){
                try {
                    dac1.setText("AC AUTO");
                    new AC().auto();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (moded == "WINDOW"){
                try {
                    dac1.setText("WINDOW AUTO");
                    new WINDOW().auto();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (moded == "BULB"){
                try {
                    dac1.setText("BULB AUTO");
                    new BULB().auto();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        //on
        else if (e.getSource() == acm_b2) {
            if (moded == "AC"){
                try {
                    dac1.setText("AC HEAT ON");
                    new AC().on();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (moded == "WINDOW"){
                try {
                    dac1.setText("WINDOW UP");
                    new WINDOW().on();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (moded == "BULB"){
                try {
                    dac1.setText("BULB ON");
                    new BULB().on();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        //off
        else if (e.getSource() == acm_b3) {
            if (moded == "AC"){
                try {
                    dac1.setText("AC HEAT OFF");
                    new AC().off();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (moded == "WINDOW"){
                try {
                    dac1.setText("WINDOW DOWN");
                    new WINDOW().off();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (moded == "BULB"){
                try {
                    dac1.setText("BULB OFF");
                    new BULB().off();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }


    //this is for other pages
    public void EXpage(String mode){
        backgroundPanel.setVisible(false);

        //AC main panel
        acm = new JPanel();
        ImageIcon background5 = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/AC.jpg");
        acm = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background5.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        acm.setLayout(null);

        //LABEL MAIN DESCRIPTION
        dac = new JLabel("SELECT THE MODES FOR " + mode.toUpperCase());
        dac.setFont(custom);
        dac.setForeground(Color.white);
        dac.setBounds(145, 20, 400, 50);

        //LABEL
        dac1 = new JLabel("");
        dac1.setFont(custom);
        dac1.setForeground(Color.white);
        dac1.setBounds(255, 80, 200, 50);

        //AUTO BUTTON
        ImageIcon icon3 = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/AUTO.PNG");
        acm_b1 = new JButton(icon3);
        acm_b1.setBounds(185, 130,200, 120 );

        //ON BUTTON
        ImageIcon icon4 = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/ON.PNG");
        acm_b2 = new JButton(icon4);
        acm_b2.setBounds(185, 270,200, 120 );

        //OFF BUTTON
        ImageIcon icon5 = new ImageIcon("C:/Users/user/Desktop/practice/practice_java/login_page/login_page/OFF.PNG");
        acm_b3 = new JButton(icon5);
        acm_b3.setBounds(185, 410,200, 120 );

        //BACK BUTTON
        acm_b4 = new JButton("Back");
        acm_b4.setBounds(250, 550,75, 50 );
        //adding
        j1.add(acm);
        acm.add(dac);
        acm.add(dac1);
        acm.add(acm_b1);
        acm.add(acm_b2);
        acm.add(acm_b3);
        acm.add(acm_b4);

        //actionLister
        acm_b4.addActionListener(this);
        acm_b1.addActionListener(this);
        acm_b2.addActionListener(this);
        acm_b3.addActionListener(this);


    }
    public static void main(String[] args) {
        new MainPage("admin");
    }
}


