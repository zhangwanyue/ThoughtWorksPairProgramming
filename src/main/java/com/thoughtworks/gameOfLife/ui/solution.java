package com.thoughtworks.gameOfLife.ui;

// java Program to create a JPanel with a Border layout and add components to it .
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class solution extends JFrame {

    // JFrame
    static JFrame f;

    // JButton
    static JButton b, b1, b2, b3;

    // label to diaplay text
    static JLabel l;

    // main class
    public static void main(String[] args)
    {
        // create a new frame to stor text field and button
        f = new JFrame("panel");

        // create a label to display text
        l = new JLabel("panel label");

        // create a new buttons
        b = new JButton("button1");
        b1 = new JButton("button2");
        b2 = new JButton("button3");
        b3 = new JButton("button4");

        // create a panel to add buttons and  a specific layout
        JPanel p = new JPanel(new BorderLayout());

        // add buttons and textfield to panel
        p.add(b, BorderLayout.NORTH);
        p.add(b1, BorderLayout.SOUTH);
        p.add(b2, BorderLayout.EAST);
        p.add(b3, BorderLayout.WEST);
        p.add(l, BorderLayout.CENTER);

        // setbackground of panel
        p.setBackground(Color.red);

        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(300, 300);

        f.show();
    }
}