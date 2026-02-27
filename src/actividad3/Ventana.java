package actividad3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Ventana extends JFrame{
	public Ventana(){
		this.setVisible(true);
		this.setSize(600, 650);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(200,200));
		this.setMaximumSize(new Dimension(700,700));
		this.setTitle("calculadora");
		this.setBackground(Color.BLACK);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.crearInterfaz();
		this.getContentPane().setBackground(Color.BLACK);
	}

	public void crearInterfaz() {

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0,0,600,650);
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(new Color(15, 32, 60));
		this.add(panelPrincipal);

		// Pantalla
		JLabel pantalla = new JLabel("0");
		pantalla.setBounds(40,30,500,90);
		pantalla.setOpaque(true);
		pantalla.setBackground(new Color(25, 50, 90));
		pantalla.setForeground(Color.WHITE);
		pantalla.setHorizontalAlignment(JLabel.RIGHT);
		pantalla.setFont(new Font("Segoe UI", Font.BOLD, 36));
		pantalla.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		panelPrincipal.add(pantalla);

		
		Color colorNumeros = new Color(40, 80, 140);
		Color colorOperadores = new Color(0, 153, 255);

		Font fuenteBotones = new Font("Segoe UI", Font.BOLD, 22);
		Border borde = BorderFactory.createLineBorder(Color.WHITE, 2);

		// Fila 1
		JButton btn7 = crearBoton("7", 40,150,colorNumeros,fuenteBotones,borde);
		JButton btn8 = crearBoton("8", 180,150,colorNumeros,fuenteBotones,borde);
		JButton btn9 = crearBoton("9", 320,150,colorNumeros,fuenteBotones,borde);
		JButton btnClear = crearBoton("C", 460,150,colorOperadores,fuenteBotones,borde);

		// Fila 2
		JButton btn4 = crearBoton("4", 40,260,colorNumeros,fuenteBotones,borde);
		JButton btn5 = crearBoton("5", 180,260,colorNumeros,fuenteBotones,borde);
		JButton btn6 = crearBoton("6", 320,260,colorNumeros,fuenteBotones,borde);
		JButton btnSuma = crearBoton("+", 460,260,colorOperadores,fuenteBotones,borde);

		// Fila 3
		JButton btn1 = crearBoton("1", 40,370,colorNumeros,fuenteBotones,borde);
		JButton btn2 = crearBoton("2", 180,370,colorNumeros,fuenteBotones,borde);
		JButton btn3 = crearBoton("3", 320,370,colorNumeros,fuenteBotones,borde);
		JButton btnResta = crearBoton("-", 460,370,colorOperadores,fuenteBotones,borde);

		// Fila 4
		JButton btn0 = crearBoton("0", 40,480,colorNumeros,fuenteBotones,borde);
		JButton btnMulti = crearBoton("x", 180,480,colorOperadores,fuenteBotones,borde);
		JButton btnDiv = crearBoton("/", 320,480,colorOperadores,fuenteBotones,borde);
		JButton btnIgual = crearBoton("=", 460,480,colorOperadores,fuenteBotones,borde);

		panelPrincipal.add(btn7); panelPrincipal.add(btn8); panelPrincipal.add(btn9); panelPrincipal.add(btnClear);
		panelPrincipal.add(btn4); panelPrincipal.add(btn5); panelPrincipal.add(btn6); panelPrincipal.add(btnSuma);
		panelPrincipal.add(btn1); panelPrincipal.add(btn2); panelPrincipal.add(btn3); panelPrincipal.add(btnResta);
		panelPrincipal.add(btn0); panelPrincipal.add(btnMulti); panelPrincipal.add(btnDiv); panelPrincipal.add(btnIgual);

		panelPrincipal.repaint();
		panelPrincipal.revalidate();
	}

	
	public JButton crearBoton(String texto, int x, int y, Color fondo, Font fuente, Border borde) {

		JButton boton = new JButton(texto);
		boton.setBounds(x,y,120,90);
		boton.setFont(fuente);
		boton.setForeground(Color.WHITE);
		boton.setBackground(fondo);
		boton.setFocusPainted(false);
		boton.setBorder(borde);

		return boton;
	}

	public static void main(String[] args) {
		new Ventana();
	}
}
		
	