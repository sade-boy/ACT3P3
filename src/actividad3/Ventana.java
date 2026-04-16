package actividad3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame {

    public Ventana() {
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(300,300));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("Juego del gato");

        crearTablero();

        this.setVisible(true);
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
            b.setForeground(Color.WHITE);
            b.setBorder(new LineBorder(new Color(0,180,216),2));
            b.setFocusPainted(false);

            
            b.setText(""); 

            contenedor.add(b);
        }
    }

    public static void main(String[] args) {
        new Ventana();
    }
}