/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


/**
 *
 * @author joset*/
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginEstetico extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoPassword;
    private JButton botonLogin;
    private JLabel etiquetaCarga;
    private JLabel etiquetaLicencia;

    public LoginEstetico() {
        setTitle("Inicio de sesión");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true); // sin barra de título
        setLayout(null);

        getContentPane().setBackground(new Color(245, 245, 250)); // fondo general

        initComponentes();
    }

    private void initComponentes() {
        // Panel de borde
        JPanel panel = new JPanel();
        panel.setBounds(20, 20, 360, 460);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 255), 1, true));
        add(panel);

        JLabel titulo = new JLabel("Bienvenido", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titulo.setBounds(0, 30, 360, 30);
        panel.add(titulo);

        campoUsuario = new JTextField();
        campoUsuario.setBounds(50, 100, 260, 35);
        campoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campoUsuario.setBorder(BorderFactory.createTitledBorder("Usuario"));
        panel.add(campoUsuario);

        campoPassword = new JPasswordField();
        campoPassword.setBounds(50, 160, 260, 35);
        campoPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campoPassword.setBorder(BorderFactory.createTitledBorder("Contraseña"));
        panel.add(campoPassword);

        botonLogin = new JButton("Iniciar sesión");
        botonLogin.setBounds(100, 220, 160, 40);
        botonLogin.setBackground(new Color(66, 135, 245));
        botonLogin.setForeground(Color.WHITE);
        botonLogin.setFocusPainted(false);
        botonLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botonLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonLogin.setBorder(BorderFactory.createEmptyBorder());
        panel.add(botonLogin);

        etiquetaCarga = new JLabel("Validando...", SwingConstants.CENTER);
        etiquetaCarga.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        etiquetaCarga.setBounds(100, 270, 160, 30);
        etiquetaCarga.setVisible(false);
        panel.add(etiquetaCarga);

        etiquetaLicencia = new JLabel("Licencia válida ✔", SwingConstants.CENTER);
        etiquetaLicencia.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        etiquetaLicencia.setForeground(new Color(0, 170, 0));
        etiquetaLicencia.setBounds(80, 310, 200, 20);
        etiquetaLicencia.setVisible(false);
        panel.add(etiquetaLicencia);

        // Acción del botón
        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarLogin();
            }
        });
    }

    private void validarLogin() {
    botonLogin.setEnabled(false);
    etiquetaCarga.setVisible(true);
    etiquetaLicencia.setVisible(false);

    String usuario = campoUsuario.getText();
    String password = new String(campoPassword.getPassword());

    // Crear un trabajador en segundo plano
    SwingWorker<Boolean, Void> worker = new SwingWorkerImpl(usuario, password);

    worker.execute();
}


    private void abrirVentanaPrincipal() {
        JOptionPane.showMessageDialog(this, "¡Bienvenido!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // cerrar login
        home h=new home();
        h.setVisible(rootPaneCheckingEnabled);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginEstetico().setVisible(true));
    }

    private class SwingWorkerImpl extends SwingWorker<Boolean, Void> {

        private final String usuario;
        private final String password;

        public SwingWorkerImpl(String usuario, String password) {
            this.usuario = usuario;
            this.password = password;
        }

        @Override
        protected Boolean doInBackground() throws Exception {
            Thread.sleep(2000); // Simula validación o carga
            return usuario.equals("admin") && password.equals("1234");
        }

        @Override
        protected void done() {
            etiquetaCarga.setVisible(false);
            try {
                boolean exito = get();
                if (exito) {
                    etiquetaLicencia.setVisible(true);
                    abrirVentanaPrincipal();
                } else {
                    etiquetaLicencia.setVisible(false);
                    JOptionPane.showMessageDialog(LoginEstetico.this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                    botonLogin.setEnabled(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
