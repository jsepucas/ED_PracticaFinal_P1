package D_Autenticacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaInicioSesion extends JFrame implements ActionListener {
    private JTextField textFieldUsuario;
    private JPasswordField passwordField;
    private JButton botonIniciarSesion;

    public VentanaInicioSesion() {
        super("Inicio de Sesión");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 120);
        this.setLocationRelativeTo(null); // Centrar en pantalla

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.setBackground(Color.LIGHT_GRAY); // Cambia el color de fondo del panel
        this.add(panel, BorderLayout.CENTER);

        JLabel labelUsuario = new JLabel("Usuario:");
        labelUsuario.setFont(new Font("Arial", Font.BOLD, 14)); // Cambia el tipo de letra y el tamaño
        panel.add(labelUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    iniciarSesion();
                }
            }
        });
        panel.add(textFieldUsuario);

        JLabel labelContraseña = new JLabel("Contraseña:");
        labelContraseña.setFont(new Font("Arial", Font.BOLD, 14)); // Cambia el tipo de letra y el tamaño
        panel.add(labelContraseña);

        passwordField = new JPasswordField();
        passwordField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    iniciarSesion();
                }
            }
        });
        panel.add(passwordField);

        botonIniciarSesion = new JButton("Iniciar Sesión");
        botonIniciarSesion.addActionListener(this);
        this.add(botonIniciarSesion, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        iniciarSesion();
    }

    private void iniciarSesion() {
        String usuario = textFieldUsuario.getText();
        char[] contraseña = passwordField.getPassword();
        if (GestorAutenticacion.autenticar(usuario, new String(contraseña))) {
            this.dispose(); // Cierra la ventana de inicio de sesión

            // Abre la ventana principal
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}