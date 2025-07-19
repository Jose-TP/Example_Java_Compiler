/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joset
 */
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConfiguracionEditor extends JFrame {

    private RSyntaxTextArea textArea;

    private JComboBox<String> fuentes;
    private JComboBox<Integer> tamanios;
    private JCheckBox modoOscuro;
    private JButton aplicar;
    private JButton colorFondoBtn;
    private JButton colorTextoBtn;

    private Color fondoActual = Color.WHITE;
    private Color textoActual = Color.BLACK;

    public ConfiguracionEditor(RSyntaxTextArea textArea) {
        this.textArea = textArea;
        setTitle("Configuración del Editor");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Fuente
        fuentes = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        fuentes.setSelectedItem(textArea.getFont().getFamily());

        // Tamaños
        Integer[] tamaniosArray = {10, 12, 14, 16, 18, 20, 24, 28, 32};
        tamanios = new JComboBox<>(tamaniosArray);
        tamanios.setSelectedItem(textArea.getFont().getSize());

        // Modo oscuro
        modoOscuro = new JCheckBox("Modo oscuro");

        // Botones de color
        colorFondoBtn = new JButton("Color de fondo");
        colorTextoBtn = new JButton("Color del texto");

        colorFondoBtn.addActionListener(e -> {
            Color nuevoColor = JColorChooser.showDialog(this, "Elige el color de fondo", fondoActual);
            if (nuevoColor != null) {
                fondoActual = nuevoColor;
            }
        });

        colorTextoBtn.addActionListener(e -> {
            Color nuevoColor = JColorChooser.showDialog(this, "Elige el color del texto", textoActual);
            if (nuevoColor != null) {
                textoActual = nuevoColor;
            }
        });

        // Botón aplicar
        aplicar = new JButton("Aplicar cambios");
        aplicar.addActionListener(e -> aplicarCambios());

        // Agregar componentes
        panel.add(new JLabel("Fuente:"));
        panel.add(fuentes);

        panel.add(new JLabel("Tamaño:"));
        panel.add(tamanios);

        panel.add(colorFondoBtn);
        panel.add(colorTextoBtn);

        panel.add(new JLabel("Tema:"));
        panel.add(modoOscuro);

        panel.add(new JLabel()); // vacío
        panel.add(aplicar);

        add(panel, BorderLayout.CENTER);
    }

    private void aplicarCambios() {
        String fuente = (String) fuentes.getSelectedItem();
        int tamaño = (Integer) tamanios.getSelectedItem();
        textArea.setFont(new Font(fuente, Font.PLAIN, tamaño));
        textArea.setBackground(fondoActual);
        textArea.setForeground(textoActual);
        textArea.setCaretColor(textoActual);

        if (modoOscuro.isSelected()) {
            textArea.setBackground(new Color(30, 30, 30));
            textArea.setForeground(Color.WHITE);
            textArea.setCaretColor(Color.WHITE);
        }

        JOptionPane.showMessageDialog(this, "¡Cambios aplicados!");
    }
    
     public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ConfiguracionEditor().setVisible(true);
            }
        });
    }
}
