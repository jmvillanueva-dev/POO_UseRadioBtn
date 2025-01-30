import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm {
    public JPanel registerPanel;
    private JTextField txtName;
    private JTextField txtAdress;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JPasswordField pswContra;
    private JButton btnRegister;
    private JRadioButton btnTerminos;
    private JTextField txtGenero;
    private JRadioButton btnGenero;
    private JButton regresarButton;

    public RegisterForm(JFrame frame) {
        // Inicialmente, deshabilitamos el botón de registro
        btnRegister.setEnabled(false);

        // Agregamos un DocumentListener a los campos de texto para detectar cambios
        txtName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }

        });

        txtAdress.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }

        });

        txtTelefono.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }

        });

        txtGenero.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }
        });

        txtEmail.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }

        });

        pswContra.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }

        });

        // Verificar que el campo de termino sea seleccionado
        btnTerminos.addItemListener(e -> checkFields());

        //Deshabilitar el campo Genero si el botón está seleccionado.
        btnGenero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnGenero.isSelected()) {
                    txtGenero.setEnabled(false);
                    txtGenero.setText("");
                } else {
                    txtGenero.setEnabled(true);
                }
                checkFields(); // Verifica los campos después del cambio
            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(registerPanel);
                if (currentFrame != null) {
                    currentFrame.dispose();
                }

                JFrame frame = new JFrame("Login | Radio Button Use");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 600);
                frame.setPreferredSize(new Dimension(600, 600));
                frame.setContentPane(new LoginForm(frame).loginPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    // Metodo para verificar si todos los campos están completos
    private void checkFields() {
        String nombre = txtName.getText();
        String direccion = txtAdress.getText();
        String telefono = txtTelefono.getText();
        String correo = txtEmail.getText();
        String contrasena = new String(pswContra.getPassword());
        String genero = txtGenero.getText();

        // Verificar si el género es válido
        boolean generoValido = btnGenero.isSelected() || !genero.isEmpty();

        // Habilitar el botón solo si todos los campos están completos y cumple con las reglas
        btnRegister.setEnabled(
                !nombre.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty() && !correo.isEmpty() && !contrasena.isEmpty()
                        && btnTerminos.isSelected() && generoValido
        );
    }

}
