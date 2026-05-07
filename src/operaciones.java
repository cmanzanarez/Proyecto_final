	import javax.swing.*;
	import javax.swing.border.*;
	import javax.swing.table.*;
	import java.awt.*;
	import java.awt.event.*;
	
	public class operaciones extends JFrame {
	
	    public operaciones() {
	
	        setTitle("Operaciones");
	        setSize(1000, 650);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setLayout(null);
	
	        // PANEL LATERAL
	
	        JPanel sidebar = new JPanel();
	        sidebar.setBounds(0, 0, 160, 650);
	        sidebar.setBackground(new Color(0, 51, 102));
	        sidebar.setLayout(null);
	        add(sidebar);
	        
	    
	        Menu(sidebar, "Inicio", 80);
	        Menu(sidebar, "Operación", 150);
	        Menu(sidebar, "Clientes", 260);
	        Menu(sidebar, "Videojuegos", 370);
	        Menu(sidebar, "Peliculas", 480);
	
	        // PANEL PRINCIPAL
	
	        JPanel mainPanel = new JPanel();
	        mainPanel.setBounds(160, 0, 840, 650);
	        mainPanel.setBackground(new Color(245, 245, 245));
	        mainPanel.setLayout(null);
	        add(mainPanel);
	
	        JLabel titulo = new JLabel("Operaciones");
	        titulo.setFont(new Font("Arial", Font.BOLD, 24));
	        titulo.setBounds(340, 20, 200, 30);
	        mainPanel.add(titulo);
	
	        // BARRA DE BUSQUEDA
	
	        JPanel searchPanel = new JPanel();
	        searchPanel.setBounds(20, 80, 790, 60);
	        searchPanel.setLayout(null);
	        searchPanel.setBackground(new Color(220, 220, 220));
	        searchPanel.setBorder(new RoundedBorder(20));
	        mainPanel.add(searchPanel);
	
	        JLabel lupa = new JLabel("Buscar:");
	        lupa.setBounds(15, 15, 60, 30);
	        searchPanel.add(lupa);
	
	        JTextField buscador = new JTextField();
	        buscador.setBounds(80, 15, 470, 30);
	        buscador.setBackground(Color.WHITE);
	        buscador.setOpaque(true);
	
	        buscador.setBorder(
	                BorderFactory.createCompoundBorder(
	                        new RoundedBorder(15),
	                        BorderFactory.createEmptyBorder(5, 10, 5, 10)
	                )
	        );
	
	        buscador.addFocusListener(new FocusAdapter() {
	
	            public void focusGained(FocusEvent e) {
	                buscador.setBackground(new Color(235, 245, 255));
	                buscador.setBorder(
	                        BorderFactory.createCompoundBorder(
	                                new LineBorder(new Color(0, 170, 255), 2, true),
	                                BorderFactory.createEmptyBorder(5, 10, 5, 10)
	                        )
	                );
	            }
	
	            public void focusLost(FocusEvent e) {
	                buscador.setBackground(Color.WHITE);
	                buscador.setBorder(
	                        BorderFactory.createCompoundBorder(
	                                new RoundedBorder(15),
	                                BorderFactory.createEmptyBorder(5, 10, 5, 10)
	                        )
	                );
	            }
	        });
	
	        searchPanel.add(buscador);
	
	        JButton btnBuscar = new JButton("Buscar");
	        btnBuscar.setBounds(540, 15, 110, 30);
	        searchPanel.add(btnBuscar);
	
	        JButton btnFiltrar = new JButton("Filtrar");
	        btnFiltrar.setBounds(660, 15, 100, 30);
	        searchPanel.add(btnFiltrar);
	
	        // TABLA
	
	        String[] columnas = {
	                "Cliente",
	                "Tipo",
	                "Producto",
	                "Tipo producto",
	                "Plataforma",
	                "Info"
	        };
	
	        Object[][] datos = {
	                {"Mateo Valeriano Soler", "Renta", "Red Dead Redemption 2", "Videojuegos", "Xbox Series X", "Ver info"},
	                {"Lucía Fernanda Mondragón", "Venta", "Marvel's Spider-man 2", "Videojuegos", "PS5", "Ver info"},
	                {"Adrián Celis Olavarría", "Venta", "Chainsaw Man", "Películas", "Blu-Ray", "Ver info"},
	                {"Elena Beatriz Iturbide", "Venta", "Rocky 4", "Películas", "DVD", "Ver info"},
	                {"Javier Amador Vizcaíno", "Renta", "Dragon Ball Super Broly", "Películas", "Blu-Ray", "Ver info"}
	        };
	
	        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
	        JTable tabla = new JTable(modelo);
	
	        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
	        tabla.setRowSorter(sorter);
	
	        tabla.setShowHorizontalLines(true);
	        tabla.setShowVerticalLines(true);
	        tabla.setGridColor(new Color(180, 180, 180));
	        tabla.setIntercellSpacing(new Dimension(0, 0));
	
	        tabla.setRowHeight(55);
	        tabla.setFont(new Font("Arial", Font.PLAIN, 14));
	
	        JTableHeader header = tabla.getTableHeader();
	        header.setFont(new Font("Arial", Font.BOLD, 14));
	        header.setBackground(Color.WHITE);
	        header.setBorder(
	                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)
	        );
	
	        JScrollPane scroll = new JScrollPane(tabla);
	        scroll.setBounds(20, 170, 790, 350);
	        scroll.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
	        mainPanel.add(scroll);
	
	        btnBuscar.addActionListener(e -> {
	            String texto = buscador.getText().trim();
	
	            if (texto.isEmpty()) {
	                sorter.setRowFilter(null);
	            } else {
	                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
	            }
	        });
	
	        setVisible(true);
	    }
	
	    // MENU
	
	    public void Menu(JPanel panel, String texto, int y) {
	
	        JLabel label = new JLabel(texto);
	        label.setForeground(Color.WHITE);
	        label.setFont(new Font("Arial", Font.PLAIN, 15));
	        label.setBounds(35, y, 120, 30);
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
	
	    // BORDE
	
	    class RoundedBorder implements Border {
	
	        int r;
	
	        RoundedBorder(int r) {
	            this.r = r;
	        }
	
	        public Insets getBorderInsets(Component c) {
	            return new Insets(r, r, r, r);
	        }
	
	        public boolean isBorderOpaque() {
	            return false;
	        }
	
	        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
	            g.drawRoundRect(x, y, w - 1, h - 1, r, r);
	        }
	    }
	
	    public static void main(String[] args) {
	        new operaciones();
	    }
	}