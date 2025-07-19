/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joset
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class BotonBonito extends JButton {
    private Color colorNormal = new Color(100, 180, 255);   // color base
    private Color colorHover = new Color(120, 200, 255);    // al pasar el mouse
    private Color colorPressed = new Color(80, 150, 230);   // al presionar

    public BotonBonito(String text,Icon icon) {
        super(text,icon);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(getFont().deriveFont(Font.BOLD));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setBackground(colorNormal);
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setBackground(colorHover);
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                setBackground(colorNormal);
                repaint();
            }

            public void mousePressed(MouseEvent e) {
                setBackground(colorPressed);
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                setBackground(colorHover);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // esquinas redondeadas
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // sin borde
    }
}
