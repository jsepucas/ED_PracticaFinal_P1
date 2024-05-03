package D_Autenticacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.add(panel, BorderLayout.CENTER);

        panel.add(new JLabel("Usuario:"));
        textFieldUsuario = new JTextField();
        panel.add(textFieldUsuario);

        panel.add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        botonIniciarSesion = new JButton("Iniciar Sesión");
        botonIniciarSesion.addActionListener(this);
        this.add(botonIniciarSesion, BorderLayout.SOUTH);
    }
    public void actionPerformed(ActionEvent e) {
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

