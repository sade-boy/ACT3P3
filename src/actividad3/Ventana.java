package actividad3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    public Ventana() {

        this.setSize(600, 650);
        this.setLocationRelativeTo(null);
        this.setTitle("Calculadora");
        this.setMinimumSize(new Dimension(300,400));
        this.setMaximumSize(new Dimension(700,700));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());

        iniciarComponentes();

        this.setVisible(true);
    }

    public void iniciarComponentes() {

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10,10));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        this.add(mainPanel);

       
        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 48));
        display.setHorizontalAlignment(JTextField.RIGHT);
        mainPanel.add(display, BorderLayout.NORTH);

        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4,4,10,10));
        centerPanel.setBackground(Color.yellow);

     
        centerPanel.add(new JButton("7"));
        centerPanel.add(new JButton("8"));
        centerPanel.add(new JButton("9"));
        centerPanel.add(new JButton("/"));
        centerPanel.add(new JButton("4"));
        centerPanel.add(new JButton("5"));
        centerPanel.add(new JButton("6"));
        centerPanel.add(new JButton("*"));
        centerPanel.add(new JButton("1"));
        centerPanel.add(new JButton("2"));
        centerPanel.add(new JButton("3"));
        centerPanel.add(new JButton("-"));
        centerPanel.add(new JButton("+/-"));
        centerPanel.add(new JButton("0"));
        centerPanel.add(new JButton("."));
        centerPanel.add(new JButton("+"));

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // PANEL INFERIOR
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        southPanel.setBackground(Color.GREEN);

        southPanel.add(new JButton("AC"));
        southPanel.add(new JButton("%"));
        southPanel.add(new JButton("delete"));
        southPanel.add(new JButton("="));

        mainPanel.add(southPanel, BorderLayout.SOUTH);
    }
}

		
	