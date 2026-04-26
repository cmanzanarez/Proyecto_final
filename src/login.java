import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Color;

public class login {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setSize(700, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 51, 102));
        topPanel.setBounds(0, 0, 700, 180);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(230, 230, 230));
        bottomPanel.setBounds(0, 180, 700, 270);

        Border flatBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY);

        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(new Color(217, 217, 217));
        card.setBorder(flatBorder);

        int cardWidth = 260;
        int cardHeight = 300;

        int x = (700 - cardWidth) / 2;
        int y = (450 - cardHeight) / 2;

        card.setBounds(x, y, cardWidth, cardHeight);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Inicio de sesión", SwingConstants.CENTER);
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        card.add(title, c);

        ImageIcon logo = new ImageIcon(login.class.getResource("/img/logo0.png"));
        Image img = logo.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(img));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridy = 1;
        card.add(logoLabel, c);

        JLabel userLabel = new JLabel("Usuario:");
        c.gridy = 2;
        card.add(userLabel, c);

        JTextField userField = new JTextField();
        userField.setPreferredSize(new Dimension(200, 25));
        userField.setBorder(flatBorder);
        c.gridy = 3;
        card.add(userField, c);

        JLabel passLabel = new JLabel("Contraseña:");
        c.gridy = 4;
        card.add(passLabel, c);

        JPasswordField passField = new JPasswordField();
        passField.setPreferredSize(new Dimension(200, 25));
        passField.setBorder(flatBorder);
        c.gridy = 5;
        card.add(passField, c);

        JButton loginButton = new JButton("Iniciar Sesion");
        loginButton.setBackground(new Color(4,180,255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        c.gridy = 6;
        card.add(loginButton, c);

        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridy = 7;
        card.add(errorLabel, c);

        JPanel registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        registerPanel.setOpaque(false);

        JLabel registerText = new JLabel("¿No tienes cuenta?");
        JLabel registerLink = new JLabel("<HTML><U>Regístrate</U></HTML>");
        registerLink.setForeground(Color.BLUE);
        registerLink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        registerPanel.add(registerText);
        registerPanel.add(registerLink);

        c.gridy = 8;
        card.add(registerPanel, c);

        loginButton.addActionListener(e -> {
            String usuario = userField.getText();
            String password = new String(passField.getPassword());

            if (usuario.isEmpty() || password.isEmpty()) {
                errorLabel.setText("Campos vacíos");
            } else if (!usuario.equals("admin") || !password.equals("1234")) {
                errorLabel.setText("Usuario o contraseña incorrectos");
            } else {
                errorLabel.setText("");
                frame.dispose();
                new principal();
            }
        });

        registerLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                registro.main(null);
                frame.dispose();
            }
        });

        layeredPane.add(topPanel, Integer.valueOf(0));
        layeredPane.add(bottomPanel, Integer.valueOf(0));
        layeredPane.add(card, Integer.valueOf(1));

        frame.add(layeredPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}