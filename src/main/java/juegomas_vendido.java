import javax.swing.*;
import java.awt.*;

public class juegomas_vendido extends JFrame {

    public juegomas_vendido() {

        setTitle("Información del producto");
        setSize(820, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // BARRA LATERAL
        JPanel barra = new JPanel();
        barra.setBackground(new Color(0, 51, 102));
        barra.setBounds(0, 0, 130, 620);
        barra.setLayout(null);

        JLabel inicio = crearMenu("Inicio", 70);
        JLabel operacion = crearMenu("Operación", 150);
        JLabel clientes = crearMenu("Clientes", 230);
        JLabel videojuegos = crearMenu("Videojuegos", 310);
        JLabel peliculas = crearMenu("Películas", 390);

        barra.add(inicio);
        barra.add(operacion);
        barra.add(clientes);
        barra.add(videojuegos);
        barra.add(peliculas);

        // PANEL PRINCIPAL
        JPanel panel = new JPanel();
        panel.setBackground(new Color(230, 230, 230));
        panel.setBounds(150, 20, 620, 540);
        panel.setLayout(null);

        // TITULO
        JLabel titulo = new JLabel("Información del producto");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(220, 15, 300, 30);

        // BOTON ATRAS
        JButton atras = new JButton("←  Atrás");
        atras.setBounds(20, 15, 115, 28);

        atras.addActionListener(e -> {

            dispose();

            SwingUtilities.invokeLater(() -> new principal());

        });

        // LABELS IZQUIERDA
        JLabel nombre = new JLabel("Nombre del producto:");
        nombre.setFont(new Font("Arial", Font.BOLD, 14));
        nombre.setBounds(30, 70, 180, 20);

        JTextField nombreTxt = new JTextField("Resident Evil Requiem");
        nombreTxt.setBounds(30, 95, 180, 28);

        JLabel id = new JLabel("ID del producto:");
        id.setFont(new Font("Arial", Font.BOLD, 14));
        id.setBounds(30, 135, 180, 20);

        JTextField idTxt = new JTextField("JUE-00087");
        idTxt.setBounds(30, 160, 180, 28);

        JLabel tipo = new JLabel("Tipo de producto:");
        tipo.setFont(new Font("Arial", Font.BOLD, 14));
        tipo.setBounds(30, 200, 180, 20);

        JTextField tipoTxt = new JTextField("Videojuego");
        tipoTxt.setBounds(30, 225, 180, 28);

        JLabel plataforma = new JLabel("Plataforma:");
        plataforma.setFont(new Font("Arial", Font.BOLD, 14));
        plataforma.setBounds(30, 265, 180, 20);

        JTextField plataformaTxt = new JTextField("Playstation 5");
        plataformaTxt.setBounds(30, 290, 180, 28);

        JLabel venta = new JLabel("Precio de venta:");
        venta.setFont(new Font("Arial", Font.BOLD, 14));
        venta.setBounds(30, 330, 180, 20);

        JTextField ventaTxt = new JTextField("$ 1200.00");
        ventaTxt.setBounds(30, 355, 180, 28);

        JLabel renta = new JLabel("Precio de renta:");
        renta.setFont(new Font("Arial", Font.BOLD, 14));
        renta.setBounds(250, 330, 180, 20);

        JTextField rentaTxt = new JTextField("$ 250.00");
        rentaTxt.setBounds(250, 355, 180, 28);

        JLabel descuento = new JLabel("Descuento:");
        descuento.setFont(new Font("Arial", Font.BOLD, 14));
        descuento.setBounds(30, 395, 180, 20);

        JTextField descuentoTxt = new JTextField("0%");
        descuentoTxt.setBounds(30, 420, 180, 28);

        // STOCK
        JLabel stock = new JLabel("Stock");
        stock.setFont(new Font("Arial", Font.BOLD, 14));
        stock.setBounds(250, 395, 180, 20);

        JTextField ventaStock = new JTextField("Venta: 20");
        ventaStock.setBounds(250, 420, 80, 28);

        JTextField rentaStock = new JTextField("Renta: 10");
        rentaStock.setBounds(350, 420, 80, 28);

        // IMAGEN PRODUCTO
        JLabel producto = new JLabel("Producto:");
        producto.setFont(new Font("Arial", Font.BOLD, 14));
        producto.setBounds(430, 70, 100, 20);

        ImageIcon portada = new ImageIcon(
                juegomas_vendido.class.getResource("/img/resident.jpg")
        );

        Image img = portada.getImage().getScaledInstance(
                150,
                210,
                Image.SCALE_SMOOTH
        );

        JLabel imagen = new JLabel(new ImageIcon(img));
        imagen.setBounds(420, 95, 150, 210);

        // INFORMACION DERECHA
        JLabel clasificacion = new JLabel("Clasificación:");
        clasificacion.setFont(new Font("Arial", Font.BOLD, 14));
        clasificacion.setBounds(430, 320, 120, 20);

        JTextField clasificacionTxt = new JTextField("M");
        clasificacionTxt.setHorizontalAlignment(SwingConstants.CENTER);
        clasificacionTxt.setBounds(430, 345, 140, 28);

        JLabel anio = new JLabel("Lanzamiento:");
        anio.setFont(new Font("Arial", Font.BOLD, 14));
        anio.setBounds(430, 385, 140, 20);

        JTextField anioTxt = new JTextField("2026");
        anioTxt.setHorizontalAlignment(SwingConstants.CENTER);
        anioTxt.setBounds(430, 410, 140, 28);

        JLabel genero = new JLabel("Género:");
        genero.setFont(new Font("Arial", Font.BOLD, 14));
        genero.setBounds(430, 450, 120, 20);

        JTextField generoTxt = new JTextField("Survival horror");
        generoTxt.setHorizontalAlignment(SwingConstants.CENTER);
        generoTxt.setBounds(430, 475, 140, 28);

        // BOTONES ABAJO
        JButton editar = new JButton("Editar videojuego");
        editar.setBackground(new Color(52, 73, 94));
        editar.setForeground(Color.WHITE);
        editar.setBounds(30, 485, 180, 35);

        JButton descargar = new JButton("Descargar PDF");
        descargar.setBackground(new Color(0, 170, 255));
        descargar.setForeground(Color.WHITE);
        descargar.setBounds(240, 485, 180, 35);

        // AGREGAR COMPONENTES
        add(barra);
        add(panel);

        panel.add(titulo);
        panel.add(atras);

        panel.add(nombre);
        panel.add(nombreTxt);

        panel.add(id);
        panel.add(idTxt);

        panel.add(tipo);
        panel.add(tipoTxt);

        panel.add(plataforma);
        panel.add(plataformaTxt);

        panel.add(venta);
        panel.add(ventaTxt);

        panel.add(renta);
        panel.add(rentaTxt);

        panel.add(descuento);
        panel.add(descuentoTxt);

        panel.add(stock);
        panel.add(ventaStock);
        panel.add(rentaStock);

        panel.add(producto);
        panel.add(imagen);

        panel.add(clasificacion);
        panel.add(clasificacionTxt);

        panel.add(anio);
        panel.add(anioTxt);

        panel.add(genero);
        panel.add(generoTxt);

        panel.add(editar);
        panel.add(descargar);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    private JLabel crearMenu(String texto, int y) {

        JLabel label = new JLabel(texto);

        label.setForeground(Color.CYAN);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setBounds(25, y, 150, 30);

        return label;

    }

}