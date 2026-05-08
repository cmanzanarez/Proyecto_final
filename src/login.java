import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class login {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(700, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // FUENTE DE LOS TEXTOS
        Font inter = new Font("Inter", Font.PLAIN, 14);
        Font interBold = new Font("Inter", Font.BOLD, 14);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.setBounds(0, 0, 700, 450);

        // PANEL SUPERIOR
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 51, 102));
        topPanel.setBounds(0, 0, 700, 180);

        // PANEL INFERIOR
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(230, 230, 230));
        bottomPanel.setBounds(0, 180, 700, 270);

        Border flatBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY);

        // CARD
        JPanel card = new JPanel(new GridBagLayout()) {

            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(217, 217, 217));

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);

                super.paintComponent(g);
            }
        };

        card.setOpaque(false);

        int cardWidth = 260;
        int cardHeight = 300;

        card.setBounds((700 - cardWidth) / 2, (450 - cardHeight) / 2, cardWidth, cardHeight);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // TITULO
        JLabel title = new JLabel("Inicio de sesión", SwingConstants.CENTER);
        title.setFont(new Font("Inter", Font.BOLD, 18));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        card.add(title, c);

        // LOGO RENTALS
        ImageIcon logo = new ImageIcon(login.class.getResource("/img/logo0.png"));
        Image img = logo.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(img));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        c.gridy = 1;
        card.add(logoLabel, c);

        //USUARIO
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setFont(inter);

        c.gridy = 2;
        card.add(userLabel, c);

        JTextField userField = new JTextField();
        userField.setPreferredSize(new Dimension(200, 25));
        userField.setBorder(flatBorder);
        userField.setFont(inter);

        c.gridy = 3;
        card.add(userField, c);

        // CONTRASEÑA
        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setFont(inter);

        c.gridy = 4;
        card.add(passLabel, c);

        JPasswordField passField = new JPasswordField();
        passField.setPreferredSize(new Dimension(200, 25));
        passField.setBorder(flatBorder);
        passField.setFont(inter);

        c.gridy = 5;
        card.add(passField, c);

        // BOTON LOGGIN
        JButton loginButton = new JButton("Iniciar Sesion");
        loginButton.setBackground(new Color(4, 180, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.setFont(interBold);

        c.gridy = 6;
        card.add(loginButton, c);

        //POPUP ERROR
        JPanel popup = new JPanel() {

            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(210, 210, 210));

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }
        };

        popup.setLayout(null);
        popup.setOpaque(false);
        popup.setBounds(170, 80, 360, 180);
        popup.setVisible(false);

        JLabel error = new JLabel("ERROR", SwingConstants.CENTER);
        error.setFont(new Font("Inter", Font.BOLD, 28));
        error.setBounds(0, 15, 360, 30);
        popup.add(error);

        JPanel circulo = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(255, 80, 40));

                g2.fillOval(0, 0, 50, 50);
            }
        };

        circulo.setOpaque(false);
        circulo.setBounds(155, 60, 50, 50);
        popup.add(circulo);

        JLabel xLabel = new JLabel("×", SwingConstants.CENTER);
        xLabel.setForeground(Color.WHITE);
        xLabel.setFont(new Font("Inter", Font.BOLD, 34));
        xLabel.setBounds(155, 55, 50, 50);
        popup.add(xLabel);

        JLabel mensaje = new JLabel("El usuario o la contraseña son incorrectos.", SwingConstants.CENTER);
        mensaje.setFont(inter);
        mensaje.setBounds(20, 120, 320, 20);
        popup.add(mensaje);

        JButton ok = new JButton("OK");
        ok.setBounds(105, 145, 150, 25);
        ok.setBackground(new Color(30, 170, 240));
        ok.setForeground(Color.WHITE);
        ok.setBorderPainted(false);
        ok.setFont(interBold);
        popup.add(ok);

        ok.addActionListener(e -> popup.setVisible(false));

        // REGISTRO
        JPanel registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        registerPanel.setOpaque(false);

        JLabel registerText = new JLabel("¿No tienes cuenta?");
        registerText.setFont(inter);

        JLabel registerLink = new JLabel("<HTML><U>Regístrate</U></HTML>");
        registerLink.setForeground(Color.BLUE);
        registerLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerLink.setFont(inter);

        registerPanel.add(registerText);
        registerPanel.add(registerLink);

        c.gridy = 8;
        card.add(registerPanel, c);

       //login
        loginButton.addActionListener(e -> {

            String usuario = userField.getText();
            String password = new String(passField.getPassword());

            if (usuario.isEmpty() || password.isEmpty()) {
                popup.setVisible(true);
            } else if (!usuario.equals("admin") || !password.equals("1234")) {
                popup.setVisible(true);
            } else {
                frame.dispose();
                new principal();
            }
        });

        
        registerLink.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                registro.main(null);
                frame.dispose();
            }
        });

        //CAPAS 
        layeredPane.add(topPanel, Integer.valueOf(0));
        layeredPane.add(bottomPanel, Integer.valueOf(0));
        layeredPane.add(card, Integer.valueOf(1));
        layeredPane.add(popup, Integer.valueOf(2));

        frame.add(layeredPane);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}