/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joset
 */
import javax.swing.*;
import java.awt.*;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.event.*;

public class BotonDegradadoAnimado extends JButton {
    private boolean mouseOver = false;
    private float scale = 1.0f;
    private Timer animador;

    
    float[] fractions = {0f, 0.33f, 0.66f, 1f}; // posiciones relativas de los colores (0.0 a 1.0)
  Color[] colors = {
        new Color(255, 40, 218),   // rojo claro
        new Color(255, 59, 121),   // naranja
        new Color(255, 189, 58),   // celeste
        new Color(255, 238, 197)    // morado
    };


    
     
    public BotonDegradadoAnimado(String text, Icon icon) {
        super(text,icon);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setOpaque(false);
        setFont(getFont().deriveFont(Font.BOLD));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                animar(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                animar(false);
            }
        });
    }

    private void animar(boolean crecer) {
        if (animador != null && animador.isRunning()) {
            animador.stop();
        }

        animador = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (crecer) {
                    scale += 0.02f;
                    if (scale >= 1.1f) {
                        scale = 1.1f;
                        animador.stop();
                    }
                } else {
                    scale -= 0.02f;
                    if (scale <= 1.0f) {
                        scale = 1.0f;
                        animador.stop();
                    }
                }
                repaint();
            }
        });
        animador.start();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int arc = 20;

        // Aplicar escala (centrado)
        g2.translate(width / 2, height / 2);
        g2.scale(scale, scale);
        g2.translate(-width / 2, -height / 2);

        // Fondo degradado si está el mouse encima
        if (mouseOver) {
            LinearGradientPaint gp = new LinearGradientPaint(
            0, 0, 0, height,  // coordenadas: inicio y fin (degradado vertical)
            fractions,        // posiciones de los colores
            colors,           // colores del degradado
            CycleMethod.NO_CYCLE
        );
            g2.setPaint(gp);
        } else {
            g2.setPaint(new Color(140, 140, 140));
        }

        g2.fillRoundRect(0, 0, width, height, arc, arc);
        super.paintComponent(g2);
        g2.dispose();
        //super.paintComponent(g);

    }

    @Override
    protected void paintBorder(Graphics g) {
        // sin borde
    }

    @Override
    public boolean isContentAreaFilled() {
        return false;
    }
}
