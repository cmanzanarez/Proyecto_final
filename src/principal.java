import javax.swing.*;
import java.awt.*;

public class principal extends JFrame {

    public principal() {

        setTitle("Principal");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel barraLat = new JPanel();
        barraLat.setBackground(new Color(10, 50, 90));
        barraLat.setBounds(0, 0, 120, 600);
        barraLat.setLayout(null);

        JLabel inicio = new JLabel("Inicio");
        inicio.setForeground(Color.WHITE);
        inicio.setBounds(30, 80, 100, 30);

        JLabel operacion = new JLabel("Operación");
        operacion.setForeground(Color.WHITE);
        operacion.setBounds(20, 150, 100, 30);

        JLabel clientes = new JLabel("Clientes");
        clientes.setForeground(Color.WHITE);
        clientes.setBounds(30, 220, 100, 30);

        JLabel videojuegos = new JLabel("Videojuegos");
        videojuegos.setForeground(Color.WHITE);
        videojuegos.setBounds(10, 290, 100, 30);

        JLabel peliculas = new JLabel("Películas");
        peliculas.setForeground(Color.WHITE);
        peliculas.setBounds(25, 360, 100, 30);

        barraLat.add(inicio);
        barraLat.add(operacion);
        barraLat.add(clientes);
        barraLat.add(videojuegos);
        barraLat.add(peliculas);

        // HEADER REDONDO
        JPanel header = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                g2.setColor(new Color(200, 200, 200));

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 45, 45);

            }

        };

        header.setOpaque(false);
        header.setBounds(130, 10, 850, 100);
        header.setLayout(null);

        // LOGO
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
        logoLabel.setBounds(10, 5, 160, 90);

        JLabel user = new JLabel("Bienvenido Usuario");
        user.setFont(new Font("Arial", Font.BOLD, 16));
        user.setBounds(600, 35, 200, 30);

        JButton logoutBtn = new JButton("Salir");
        logoutBtn.setBounds(730, 35, 90, 30);

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
        JPanel card1 = crearCard("Clientes", "1000");
        card1.setBounds(260, 160, 220, 140);

        JPanel card2 = crearCard("Rentas y Ventas", "1500");
        card2.setBounds(550, 160, 220, 140);

        JPanel card3 = crearCardDoble("Películas");
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

    // CARD SIMPLE
    private JPanel crearCard(String titulo, String numero) {

        JPanel panel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                g2.setColor(new Color(210, 210, 210));

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 35);

            }

        };

        panel.setOpaque(false);
        panel.setLayout(null);

        JLabel titulo1 = new JLabel(titulo, SwingConstants.CENTER);
        titulo1.setFont(new Font("Arial", Font.BOLD, 18));
        titulo1.setBounds(0, 15, 220, 25);

        JLabel numero1 = new JLabel(numero, SwingConstants.CENTER);
        numero1.setFont(new Font("Arial", Font.BOLD, 26));
        numero1.setForeground(new Color(20, 80, 200));
        numero1.setBounds(0, 45, 220, 35);

        JButton btn = new JButton("Ver");
        btn.setBounds(70, 95, 80, 30);

        panel.add(titulo1);
        panel.add(numero1);
        panel.add(btn);

        return panel;

    }

    // CARD DOBLE
    private JPanel crearCardDoble(String titulo) {

        JPanel panel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                g2.setColor(new Color(210, 210, 210));

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 35);

            }

        };

        panel.setOpaque(false);
        panel.setLayout(null);

        JLabel titulo2 = new JLabel(titulo, SwingConstants.CENTER);
        titulo2.setFont(new Font("Arial", Font.BOLD, 18));
        titulo2.setBounds(0, 10, 220, 25);

        JLabel mensaje1 = new JLabel("Más comprado");
        mensaje1.setBounds(20, 50, 100, 20);

        JLabel mensaje2 = new JLabel("Más rentado");
        mensaje2.setBounds(120, 50, 100, 20);

        JButton boton1 = new JButton("Ver");
        boton1.setBounds(20, 90, 80, 30);

        JButton boton2 = new JButton("Ver");
        boton2.setBounds(120, 90, 80, 30);

        // ABRIR NUEVA VENTANA
        boton2.addActionListener(e -> {

            dispose();

            SwingUtilities.invokeLater(() -> new juegomas_vendido());

        });

        panel.add(titulo2);
        panel.add(mensaje1);
        panel.add(mensaje2);
        panel.add(boton1);
        panel.add(boton2);

        return panel;

    }

}