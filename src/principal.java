import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class principal extends JFrame {

    public principal() {

        setTitle("Principal");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // BARRA AZUL
        JPanel barraLat = new JPanel();
        barraLat.setBackground(new Color(10, 50, 90));
        barraLat.setBounds(0, 0, 120, 600);
        barraLat.setLayout(null);

        // MENÚ 
        Menu(barraLat, "Inicio", 80);
        Menu(barraLat, "Operación", 150);
        Menu(barraLat, "Clientes", 220);
        Menu(barraLat, "Videojuegos", 290);
        Menu(barraLat, "Peliculas", 360);

        // HEADER
        JPanel header = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(200, 200, 200));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 45, 45);
            }
        };

        header.setOpaque(false);
        header.setBounds(130, 10, 850, 100);
        header.setLayout(null);

        // LOGO 
        ImageIcon logo = new ImageIcon(principal.class.getResource("/img/logo0.png"));
        Image img = logo.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(img));
        logoLabel.setBounds(20, 10, 80, 80);

        JLabel user = new JLabel("Bienvenido Usuario");
        user.setFont(new Font("Inter", Font.BOLD, 16));
        user.setBounds(420, 35, 200, 30);

        JButton logoutBtn = new JButton("Salir");
        logoutBtn.setFont(new Font("Inter", Font.PLAIN, 14));
        logoutBtn.setBounds(700, 35, 90, 30);
        logoutBtn.setBackground(new Color(220, 50, 50));
        logoutBtn.setForeground(Color.WHITE);

        logoutBtn.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Estás seguro que quieres cerrar sesión?",
                    "Cerrar sesión",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcion == JOptionPane.YES_OPTION) {
                dispose();
                login.main(null);
            }
        });

        header.add(logoLabel);
        header.add(user);
        header.add(logoutBtn);

        // CARDS
        JPanel card1 = Card("Clientes", "1000");
        card1.setBounds(260, 160, 220, 140);

        JPanel card2 = Card("Rentas y Ventas", "1500");
        card2.setBounds(550, 160, 220, 140);

        JPanel card3 = crearCardDoble("Peliculas");
        card3.setBounds(260, 340, 220, 150);

        JPanel card4 = crearCardDoble("Videojuegos");
        card4.setBounds(550, 340, 220, 150);

        add(barraLat);
        add(header);
        add(card1);
        add(card2);
        add(card3);
        add(card4);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // MENU
    public void Menu(JPanel panel, String texto, int y) {

        JLabel label = new JLabel(texto);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Inter", Font.PLAIN, 15));
        label.setBounds(25, y, 120, 30);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));

        label.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                JFrame ventana = null;

                switch (texto) {

                    case "Inicio":
                        ventana = new principal();
                        break;

                    case "Videojuegos":
                        ventana = new videojuegos();
                        break;

                    case "Clientes":
                        ventana = new clientes();
                        break;

                    case "Operación":
                        ventana = new operaciones();
                        break;

                    case "Peliculas":
                        ventana = new peliculas();
                        break;
                }

                if (ventana != null) {
                    ventana.setVisible(true);
                    dispose();
                }
            }
        });

        panel.add(label);
    }

    //CARD
    private JPanel Card(String titulo, String numero) {

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(210, 210, 210));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 35);
            }
        };

        panel.setOpaque(false);
        panel.setLayout(null);

        JLabel titulo1 = new JLabel(titulo, SwingConstants.CENTER);
        titulo1.setFont(new Font("Inter", Font.BOLD, 18));
        titulo1.setBounds(0, 15, 220, 25);

        JLabel numero1 = new JLabel(numero, SwingConstants.CENTER);
        numero1.setFont(new Font("Inter", Font.BOLD, 26));
        numero1.setBounds(0, 45, 220, 35);

        JButton btn = new JButton("Ver");
        btn.setFont(new Font("Inter", Font.PLAIN, 13));
        btn.setBounds(70, 95, 80, 30);

        panel.add(titulo1);
        panel.add(numero1);
        panel.add(btn);

        return panel;
    }

    // CARD DOBLE
    private JPanel crearCardDoble(String titulo) {

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(210, 210, 210));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 35);
            }
        };

        panel.setOpaque(false);
        panel.setLayout(null);

        JLabel titulo2 = new JLabel(titulo, SwingConstants.CENTER);
        titulo2.setBackground(new Color(4, 180, 255));
        titulo2.setFont(new Font("Inter", Font.BOLD, 18));
        titulo2.setBounds(0, 10, 220, 25);

        JLabel mensaje1 = new JLabel("Más comprado");
        mensaje1.setBackground(new Color(4, 180, 255));
        mensaje1.setFont(new Font("Inter", Font.PLAIN, 12));
        mensaje1.setBounds(20, 50, 100, 20);

        JLabel mensaje2 = new JLabel("Más rentado");
        mensaje1.setBackground(new Color(4, 180, 255));
        mensaje2.setFont(new Font("Inter", Font.PLAIN, 12));
        mensaje2.setBounds(120, 50, 100, 20);

        JButton boton1 = new JButton("Ver");
        boton1.setBackground(new Color(4, 180, 255));
        boton1.setFont(new Font("Inter", Font.PLAIN, 13));
        boton1.setBounds(20, 90, 80, 30);

        JButton boton2 = new JButton("Ver");
        boton2.setBackground(new Color(4, 180, 255));
        boton2.setFont(new Font("Inter", Font.PLAIN, 13));
        boton2.setBounds(120, 90, 80, 30);

        boton1.addActionListener(e -> {
            if (titulo.equals("Videojuegos")) {
                dispose();
                new juegomas_rentado();
            }
            if (titulo.equals("Peliculas")) {
                dispose();
                new peliculamas_rentada();
            }
        });

        boton2.addActionListener(e -> {
            if (titulo.equals("Videojuegos")) {
                dispose();
                new juegomas_rentado();
            }
            if (titulo.equals("Peliculas")) {
                dispose();
                new peliculamas_rentada();
            }
        });

        panel.add(titulo2);
        panel.add(mensaje1);
        panel.add(mensaje2);
        panel.add(boton1);
        panel.add(boton2);

        return panel;
    }
}