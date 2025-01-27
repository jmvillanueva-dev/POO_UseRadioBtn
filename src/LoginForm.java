import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LoginForm {
    public JPanel loginPanel;
    private JTextField txtEmail;
    private JPasswordField pswContra;
    private JButton btnLogin;
    private JButton btnRegister;

    public LoginForm(JFrame frame) {
        // Deshabilitar el botón de login al principio
        btnLogin.setEnabled(false);

        // Listener para habilitar el botón de login cuando ambos campos estén llenos
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


        // Ir al formulario de registro
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new RegisterForm(frame).registerPanel);
                frame.revalidate(); // Refrescar el JFrame
                frame.repaint();
            }
        });

        // Iniciar sesión

    }
    private void checkFields() {
        String correo = txtEmail.getText();
        String password = new String(pswContra.getPassword());

        // Habilitar el botón solo si todos los campos están llenos
        btnLogin.setEnabled(!correo.isEmpty() && !password.isEmpty());
    }
}
