package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        new Main();
    }
    public Main(){
        JFrame frame = new JFrame();
        frame.setTitle("!!");
        frame.setSize(900, 600);
        frame.setLocation(100, 50);
        frame.addKeyListener(Contents.listener);
        frame.add(new Contents());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}