import javax.swing.*;
import java.awt.*;

public class principal extends JFrame {

    public principal() {
        setTitle("Principal");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(10, 50, 90));
        sidebar.setBounds(0, 0, 120, 600);
        sidebar.setLayout(null);

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

        sidebar.add(inicio);
        sidebar.add(operacion);
        sidebar.add(clientes);
        sidebar.add(videojuegos);
        sidebar.add(peliculas);

        JPanel header = new JPanel();
        header.setBackground(new Color(200, 200, 200));
        header.setBounds(120, 0, 880, 80);
        header.setLayout(null);

        JLabel logo = new JLabel("REWIND RENTALS");
        logo.setFont(new Font("Arial", Font.BOLD, 20));
        logo.setBounds(20, 20, 300, 30);

        JLabel user = new JLabel("Bienvenido Daniel");
        user.setBounds(600, 20, 200, 30);

        JButton logoutBtn = new JButton("Salir");
        logoutBtn.setBounds(780, 20, 80, 30);
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

        header.add(logo);
        header.add(user);
        header.add(logoutBtn);

        JPanel card1 = crearCard("Clientes", "1000");
        card1.setBounds(200, 120, 200, 120);

        JPanel card2 = crearCard("Rentas y Ventas", "1500");
        card2.setBounds(450, 120, 200, 120);

        JPanel card3 = crearCardDoble("Películas");
        card3.setBounds(200, 280, 200, 150);

        JPanel card4 = crearCardDoble("Videojuegos");
        card4.setBounds(450, 280, 200, 150);

        add(sidebar);
        add(header);
        add(card1);
        add(card2);
        add(card3);
        add(card4);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel crearCard(String titulo, String numero) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(210, 210, 210));

        JLabel t = new JLabel(titulo, SwingConstants.CENTER);
        t.setBounds(0, 10, 200, 20);

        JLabel n = new JLabel(numero, SwingConstants.CENTER);
        n.setForeground(Color.BLUE);
        n.setBounds(0, 40, 200, 30);

        JButton btn = new JButton("Ver");
        btn.setBounds(60, 80, 80, 25);

        panel.add(t);
        panel.add(n);
        panel.add(btn);

        return panel;
    }

    private JPanel crearCardDoble(String titulo) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(210, 210, 210));

        JLabel t = new JLabel(titulo, SwingConstants.CENTER);
        t.setBounds(0, 10, 200, 20);

        JLabel m1 = new JLabel("Más comprado");
        m1.setBounds(20, 40, 100, 20);

        JLabel m2 = new JLabel("Más rentado");
        m2.setBounds(110, 40, 100, 20);

        JButton b1 = new JButton("Ver");
        b1.setBounds(20, 70, 70, 25);

        JButton b2 = new JButton("Ver");
        b2.setBounds(110, 70, 70, 25);

        panel.add(t);
        panel.add(m1);
        panel.add(m2);
        panel.add(b1);
        panel.add(b2);

        return panel;
    }
}