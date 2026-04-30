import javax.swing.*;
import java.awt.*;

public class registro {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.setBounds(0, 0, 900, 600); // 🔥 CLAVE

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 51, 102));
        topPanel.setBounds(0, 0, 900, 200);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(230, 230, 230));
        bottomPanel.setBounds(0, 200, 900, 400);

        JPanel card = new JPanel(null);
        card.setBackground(new Color(217, 217, 217));
        card.setBounds(100, 90, 700, 420);

        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(50, 70, 200, 20);

        JTextField userField = new JTextField();
        userField.setBounds(50, 100, 250, 30);

        JLabel phoneLabel = new JLabel("Teléfono:");
        phoneLabel.setBounds(380, 70, 200, 20);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(380, 100, 250, 30);

        JLabel emailLabel = new JLabel("Correo:");
        emailLabel.setBounds(50, 140, 200, 20);

        JTextField emailField = new JTextField();
        emailField.setBounds(50, 170, 250, 30);

        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setBounds(50, 210, 200, 20);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(50, 240, 250, 30);

        JLabel confirmLabel = new JLabel("Confirmar contraseña:");
        confirmLabel.setBounds(50, 260, 200, 20);

        JPasswordField confirmField = new JPasswordField();
        confirmField.setBounds(50, 290, 250, 30);

        JButton registerBtn = new JButton("Registrar");
        registerBtn.setBounds(250, 350, 200, 40);

        JButton backBtn = new JButton("← Atrás");
        backBtn.setBounds(20, 20, 100, 30);

        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(150, 320, 400, 25);
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        registerBtn.addActionListener(e -> {
            String user = userField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String pass = new String(passField.getPassword());
            String confirm = new String(confirmField.getPassword());

            if (user.isEmpty() || phone.isEmpty() || email.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                errorLabel.setText("Campos vacíos");
            } else if (!email.contains("@")) {
                errorLabel.setText("Correo no válido");
            } else if (!phone.matches("\\d{10}")) {
                errorLabel.setText("Teléfono inválido");
            } else if (!pass.equals(confirm)) {
                errorLabel.setText("Contraseñas no coinciden");
            } else {
                JOptionPane.showMessageDialog(frame, "Registro exitoso");
                frame.dispose();
                login.main(null);
            }
        });

        backBtn.addActionListener(e -> {
            frame.dispose();
            login.main(null);
        });
        ImageIcon logo2 = new ImageIcon(
                login.class.getResource("/img/logo2.png")
        );

        Image img = logo2.getImage().getScaledInstance(
                160,
                90,
                Image.SCALE_SMOOTH
        );

        JLabel logoLabel = new JLabel(new ImageIcon(img));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setBounds(525, 5, 160, 90);
        
        int offsetY = 10;
        JLabel sexoLabel = new JLabel("Sexo:");
        sexoLabel.setBounds(380, 150 + offsetY, 200, 20);

        JRadioButton masculino = new JRadioButton("Masculino");
        JRadioButton femenino = new JRadioButton("Femenino");
        JRadioButton otro = new JRadioButton("Otro");

        masculino.setBounds(380, 175 + offsetY, 100, 20);
        femenino.setBounds(480, 175 + offsetY, 100, 20);
        otro.setBounds(580, 175 + offsetY, 80, 20);

        masculino.setOpaque(false);
        femenino.setOpaque(false);
        otro.setOpaque(false);

        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(masculino);
        grupoSexo.add(femenino);
        grupoSexo.add(otro);
        


        userLabel.setBounds(50, 80 + offsetY, 200, 20);
        userField.setBounds(50, 105 + offsetY, 250, 30);

        phoneLabel.setBounds(380, 80 + offsetY, 200, 20);
        phoneField.setBounds(380, 105 + offsetY, 250, 30);

        emailLabel.setBounds(50, 150 + offsetY, 200, 20);
        emailField.setBounds(50, 175 + offsetY, 250, 30);

        passLabel.setBounds(50, 220 + offsetY, 200, 20);
        passField.setBounds(50, 245 + offsetY, 250, 30);

        confirmLabel.setBounds(50, 290 + offsetY, 200, 20);
        confirmField.setBounds(50, 315 + offsetY, 250, 30);

        registerBtn.setBounds(250, 370 + offsetY, 200, 40);
        
        card.add(userLabel);
        card.add(userField);
        card.add(phoneLabel);
        card.add(phoneField);
        card.add(emailLabel);
        card.add(emailField);
        card.add(passLabel);
        card.add(logoLabel);
        card.add(passField);
        card.add(confirmLabel);
        card.add(confirmField);
        card.add(registerBtn);
        card.add(backBtn);
        card.add(errorLabel);
        card.add(sexoLabel);
        card.add(masculino);
        card.add(femenino);
        card.add(otro);

        layeredPane.add(topPanel, Integer.valueOf(0));
        layeredPane.add(bottomPanel, Integer.valueOf(0));
        layeredPane.add(card, Integer.valueOf(1));

        frame.setContentPane(layeredPane); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}