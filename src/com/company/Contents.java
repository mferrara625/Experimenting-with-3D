package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Contents extends JPanel implements ActionListener {


    private static int x = 350, y = 205, a = 0, b = 0;

    private Timer t;

    public Contents(){
        super.setDoubleBuffered(true);
        t = new Timer(7, this);
        t.start();
    }

    static KeyListener listener = new KeyListener() {
        @Override
        public void keyPressed(KeyEvent event) {
            if(event.getKeyChar()==KeyEvent.VK_W || event.getKeyChar()=='w'){
                a++;
                b++;
                event.consume();
            }
            if(event.getKeyChar()==KeyEvent.VK_S || event.getKeyChar()=='s'){
                a--;
                b--;
                event.consume();
            }

            if(event.getKeyChar()==KeyEvent.VK_A || event.getKeyChar()=='a'){
                b--;
                x += 10;
                event.consume();
            }
            if(event.getKeyChar()==KeyEvent.VK_D || event.getKeyChar()=='d'){
                b++;
                x -= 10;
                event.consume();
            }

            if(event.getKeyChar()==KeyEvent.VK_SPACE){

                event.consume();
            }
            if(event.getKeyChar()==KeyEvent.VK_ENTER){

                event.consume();
            }


        }

        @Override
        public void keyReleased(KeyEvent event) {
            if(event.getKeyChar()==KeyEvent.VK_A || event.getKeyChar()=='a'){
                event.consume();
            }
            if(event.getKeyChar()==KeyEvent.VK_D || event.getKeyChar()=='d'){
                event.consume();
            }

        }

        @Override
        public void keyTyped(KeyEvent event) {
        }

    };

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("a: " + a + " b: " + b,10, 10);
        g2d.drawString("CONTROLS",10, 20);
        g2d.drawString("A: MOVE LEFT",10, 35);
        g2d.drawString("D: MOVE RIGHT",10, 50);
        g2d.drawString("W: ZOOM IN",10, 65);
        g2d.drawString("S: ZOOM OUT",10, 80);


//        g2d.drawRect(x, y, a, b);
        if(b >= a){
//            g2d.setColor(Color.cyan);
            g2d.drawLine(x, y + (a - b), x + a, y + (a - b)); // top
            g2d.drawLine(x, y + (a - b), x, y + b); // left
            g2d.drawLine(x + a, y + b, x, y + b); // bottom
            g2d.drawLine(x + a, y, x + a, y + a); // right

//            g2d.setColor(Color.orange);
            g2d.drawLine(x + (a), y + (a - b), x + a+ (a), y); // top
            g2d.drawLine(x+ (a), y + b, x+ (a), y + (a - b)); // left
            g2d.drawLine(x + a+ (a), y + a, x+ (a), y + b); // bottom
            g2d.drawLine(x + a+ (a), y + a, x + a+ (a), y); // right
        } else {
            g2d.drawLine(x, y, x + a, y - (a - b)); // top
            g2d.drawLine(x + a, y - (a - b), x + a, y + b + ((a - b) * 2)); // right
            g2d.drawLine(x, y + a, x + a, y + b + ((a - b) * 2)); // bottom
            g2d.drawLine(x, y + a, x, y); // left

            g2d.drawLine(x + (a), y - (a - b), x + a + (a), y - (a - b)); // top
            g2d.drawLine(x + a + (a), y - (a - b), x + a + (a), y + b + ((a - b) * 2)); // right
            g2d.drawLine(x + (a), y + b + ((a - b) * 2), x + a + (a), y + b + ((a - b) * 2)); // bottom
            g2d.drawLine(x + (a), y + a, x + (a), y); // left
        }


        g2d.drawOval(x + a/2, y + a/2, a/10, a/10);

        g2d.drawOval(x + a + a/2 + a/4, y + a/2 + a/4, a/10, a/10);
        g2d.drawOval(x + a + a/2, y + a/2, a/10, a/10);
        g2d.drawOval(x + a + a/4, y + a/4, a/10, a/10);







    }


    private static int zV = 3;
    private static int zV2 = 8;
    private static int yV = 0;
    private static int xV = 0;




    public void move(){
        y = y + yV;
        x = x + xV;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();


        repaint();
    }
}
