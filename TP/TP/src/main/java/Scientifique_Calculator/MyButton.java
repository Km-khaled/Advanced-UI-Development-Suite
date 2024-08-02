package Scientifique_Calculator;

import javax.swing.*;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyButton extends JButton {
    private int isMouseEntered = 1;// Whether the mouse enters the button
    Color color0;
    Color color1 = new Color(200, 200, 200);

    public MyButton(String buttonText, Color color) {
        super(buttonText);
        color0 = color;
        //Add mouse monitor
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //When the mouse enters, the mouse enter state is changed to TRUE, and the button is redrawn
                isMouseEntered = 0;
                repaint();
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseEntered = 1;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                isMouseEntered = 2;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isMouseEntered = 0;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw gradient background color
        switch (isMouseEntered) {
            case 0:
                this.setBackground(color1);
                break;
            case 1:
                this.setBackground(color0);
                break;
            case 2:
            default:
                break;
        }
        super.paintComponent(g);

    }

}
