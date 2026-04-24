package actividad3;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame {

    JButton[] botones = new JButton[9];
    String[][] tablero = new String[3][3];

    String turno = "X";

    int victoriasX = 0;
    int victoriasO = 0;

    JLabel lblX;
    JLabel lblO;

    public Ventana() {
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(300,300));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("Juego del gato");

        crearPanelSuperior();
        inicializarTablero();
        crearTablero();

        this.setVisible(true);
    }

    public void crearPanelSuperior() {
        JPanel superior = new JPanel();

        lblX = new JLabel("X: 0");
        lblO = new JLabel("O: 0");

        lblX.setFont(new Font("Arial", Font.BOLD, 18));
        lblO.setFont(new Font("Arial", Font.BOLD, 18));

        JButton btnReiniciar = new JButton("🔄");

        btnReiniciar.addActionListener(e -> reiniciarJuego());

        superior.add(lblX);
        superior.add(lblO);
        superior.add(btnReiniciar);

        this.add(superior, BorderLayout.NORTH);
    }

    public void inicializarTablero() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                tablero[i][j] = "";
            }
        }
    }

    public void crearTablero() {
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new GridLayout(3,3,10,10)); 
        contenedor.setBackground(Color.WHITE);

        this.add(contenedor, BorderLayout.CENTER);

        Font fuente = new Font("Inter", Font.BOLD, 60);

        for(int i = 0; i < 9; i++){
            JButton b = new JButton();

            b.setFont(fuente);
            b.setBackground(new Color(218, 230, 225));
            b.setForeground(Color.BLACK);
            b.setBorder(new LineBorder(new Color(0,180,216),2));
            b.setFocusPainted(false);

            int indice = i;

            b.addActionListener(e -> procesarMovimiento(indice));

            botones[i] = b;
            contenedor.add(b);
        }
    }

    public void procesarMovimiento(int indice) {

        JButton boton = botones[indice];

        if(!boton.getText().equals("")) return;

        int fila = indice / 3;
        int col = indice % 3;

        tablero[fila][col] = turno;
        boton.setText(turno);

        int[] linea = verificarGanador();

        if(linea != null) {

            resaltarLinea(linea);

            if(turno.equals("X")) {
                victoriasX++;
                lblX.setText("X: " + victoriasX);
            } else {
                victoriasO++;
                lblO.setText("O: " + victoriasO);
            }

            JOptionPane.showMessageDialog(this, "Ganó " + turno);

            reiniciarJuego();
            return;
        }

        if(estaTableroLleno()) {
            JOptionPane.showMessageDialog(this, "Empate");
            reiniciarJuego();
            return;
        }

        turno = turno.equals("X") ? "O" : "X";
    }

    public int[] verificarGanador() {

        for(int i = 0; i < 3; i++){
            if(!tablero[i][0].equals("") &&
               tablero[i][0].equals(tablero[i][1]) &&
               tablero[i][1].equals(tablero[i][2])) {
                return new int[]{i*3, i*3+1, i*3+2};
            }
        }

        for(int i = 0; i < 3; i++){
            if(!tablero[0][i].equals("") &&
               tablero[0][i].equals(tablero[1][i]) &&
               tablero[1][i].equals(tablero[2][i])) {
                return new int[]{i, i+3, i+6};
            }
        }

        if(!tablero[0][0].equals("") &&
           tablero[0][0].equals(tablero[1][1]) &&
           tablero[1][1].equals(tablero[2][2])) {
            return new int[]{0,4,8};
        }

        if(!tablero[0][2].equals("") &&
           tablero[0][2].equals(tablero[1][1]) &&
           tablero[1][1].equals(tablero[2][0])) {
            return new int[]{2,4,6};
        }

        return null;
    }

    public void resaltarLinea(int[] linea) {
        for(int i : linea) {
            botones[i].setBackground(Color.GREEN);
        }
    }

    public boolean estaTableroLleno() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(tablero[i][j].equals("")) return false;
            }
        }
        return true;
    }

    public void reiniciarJuego() {

        inicializarTablero();

        for(int i = 0; i < 9; i++){
            botones[i].setText("");
            botones[i].setEnabled(true);
            botones[i].setBackground(new Color(218, 230, 225));
        }

        turno = "X";
    }

    public static void main(String[] args) {
        new Ventana();
    }
}