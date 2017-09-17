package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Juego;
import logica.Validaciones;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.Canvas;
import java.awt.Panel;
import javax.swing.ImageIcon;
import java.awt.Font;


public class PantallaPrincipal extends JFrame {
	

	private JPanel contentPane;
	private JLabel lbl_nombre;
	
	private Juego j;
	private JTextField level1_n1;
	private JTextField level1_n2;
	private JLabel level1_op;
	private JTextField level2_n1;
	private JTextField level2_n2;
	private JTextField level2_n3;
	private JLabel lbl_correcto;
	private JLabel lbl2_correcto;
	private JLabel level2_op2; 
	private JLabel level2_op;
	private JTextField level4_n1;
	private JTextField level3_n1;
	private JTextField level3_n2;
	private JTextField level3_n3;
	private JTextField level3_n4;
	private JPanel panel_n4;
	private JTextField level4_n2;
	private JTextField level4_n3;
	private JTextField level4_n4;
	private JTextField level4_n5;
	private JLabel level4_op;
	private JLabel level4_op2;
	private JLabel level4_op3;
	private JLabel level4_op4;
	private JLabel level4_correcto;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {
				
		j = new Juego();  							 //Creo la instancia nueva para las reglas del juego.
		Validaciones validar = new Validaciones();
		int a, b;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		Mostrar bienvenida con Nombre
		lbl_nombre = new JLabel(" ");
		lbl_nombre.setBounds(10, 40, 217, 14);
		contentPane.add(lbl_nombre);
		
		
		JPanel panel_n2 = new JPanel();
		panel_n2.setBounds(189, 308, 321, 63);
		contentPane.add(panel_n2);
		panel_n2.setOpaque(false);
		panel_n2.setVisible(false);
		
		JPanel panel_n3 = new JPanel();
		panel_n3.setBounds(142, 387, 413, 76);
		contentPane.add(panel_n3);
		panel_n3.setOpaque(false);
		panel_n3.setVisible(false);
		panel_n3.setLayout(null);
		
		panel_n4 = new JPanel();
		panel_n4.setBounds(98, 476, 504, 62);
		contentPane.add(panel_n4);
		panel_n4.setVisible(false);
		panel_n4.setOpaque(false);
		panel_n4.setLayout(null);
		
		
		level3_n2 = new JTextField();
		level3_n2.setColumns(10);
		level3_n2.setBounds(118, 15, 45, 45);
		panel_n3.add(level3_n2);
		
		level3_n1 = new JTextField();
		level3_n1.setBounds(10, 15, 45, 45);
		panel_n3.add(level3_n1);
		level3_n1.setColumns(10);
		
		level3_n3 = new JTextField();
		level3_n3.setColumns(10);
		level3_n3.setBounds(235, 15, 45, 45);
		panel_n3.add(level3_n3);
		
		level3_n4 = new JTextField();
		level3_n4.setColumns(10);
		level3_n4.setBounds(350, 15, 45, 45);
		panel_n3.add(level3_n4);
		
		JLabel level3_op = new JLabel("l2_op");
		level3_op.setFont(new Font("Tahoma", Font.BOLD, 14));
		level3_op.setBounds(70, 22, 36, 29);
		panel_n3.add(level3_op);
		
		JLabel level3_op2 = new JLabel("l2_op");
		level3_op2.setFont(new Font("Tahoma", Font.BOLD, 14));
		level3_op2.setBounds(173, 22, 36, 29);
		panel_n3.add(level3_op2);
		
		JLabel level3_op3 = new JLabel("l2_op");
		level3_op3.setFont(new Font("Tahoma", Font.BOLD, 14));
		level3_op3.setBounds(305, 22, 36, 29);
		panel_n3.add(level3_op3);
		
		JLabel level3_correcto = new JLabel("");
		level3_correcto.setBounds(565, 396, 99, 50);
		contentPane.add(level3_correcto);
		
		
		//Boton para verificar la cuenta-
		JButton btnNewButton = new JButton("Verificar");
		btnNewButton.setBounds(458, 152, 121, 29);
		btnNewButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
			
			switch (j.getNivel()){ 	
			case 1:
//				if(j.getNivel()==1 && validar.noEsTextoVacio(l1_n1) && validar.noEsTextoVacio(l1_n2)){
			   if(validar.noEsTextoVacio(level1_n1) && validar.noEsTextoVacio(level1_n2)){
					//Guardo los numeros del usuario para usar en VerificarCuenta
					j.agregarNum(Integer.parseInt(level1_n1.getText()));
					j.agregarNum(Integer.parseInt(level1_n2.getText()));
					// Si la cuenta es correcta, sube de nivel, muestra el proximo nivel y vacia los array
					if(j.verificarCuenta()){
						j.subirNivel();
						lbl_correcto.setText("Correcto");
						level1_n1.setEnabled(false);
						level1_n2.setEnabled(false);
						panel_n2.setVisible(true); 
						j.vaciarArray();
						
						int a = j.genOperador();
						j.agregarOp(a);
						level2_op.setText(j.mostrarOperador(a));
						int b = j.genOperador();
						j.agregarOp(b);
						level2_op2.setText(j.mostrarOperador(b));
						
						
					}
				}
			   break;
			case 2:
//				if(j.getNivel() == 2 ){

					if (validar.noEsTextoVacio(level2_n1) && validar.noEsTextoVacio(level2_n2) && validar.noEsTextoVacio(level2_n3)){
						j.agregarNum(Integer.parseInt(level2_n1.getText()));
						j.agregarNum(Integer.parseInt(level2_n2.getText()));
						j.agregarNum(Integer.parseInt(level2_n3.getText()));
					
					if(j.verificarCuenta()){
						j.subirNivel();
						panel_n2.setEnabled(false);
						panel_n3.setVisible(true); 
						lbl2_correcto.setText("Correcto");
						
						j.vaciarArray();
						
						int a = j.genOperador();
						j.agregarOp(a);
						level3_op.setText(j.mostrarOperador(a));
						int b = j.genOperador();
						j.agregarOp(b);
						level3_op2.setText(j.mostrarOperador(b));
						int c = j.genOperador();
						j.agregarOp(c);
						level3_op3.setText(j.mostrarOperador(c));
					}
					}
//				}
			break;
			case 3:
				if (validar.noEsTextoVacio(level3_n1) && validar.noEsTextoVacio(level3_n2) && validar.noEsTextoVacio(level3_n3) && validar.noEsTextoVacio(level3_n4) ){
					j.agregarNum(Integer.parseInt(level3_n1.getText()));
					j.agregarNum(Integer.parseInt(level3_n2.getText()));
					j.agregarNum(Integer.parseInt(level3_n3.getText()));
					j.agregarNum(Integer.parseInt(level3_n4.getText()));
				
				if(j.verificarCuenta()){
					j.subirNivel();
					level3_correcto.setText("Correcto");
					panel_n3.setEnabled(false);
					panel_n4.setVisible(true); 
					j.vaciarArray();
					
					int a = j.genOperador();
					j.agregarOp(a);
					level4_op.setText(j.mostrarOperador(a));
					int b = j.genOperador();
					j.agregarOp(b);
					level4_op2.setText(j.mostrarOperador(b));
					int c = j.genOperador();
					j.agregarOp(c);
					level4_op3.setText(j.mostrarOperador(c));
					int d = j.genOperador();
					j.agregarOp(d);
					level4_op4.setText(j.mostrarOperador(d));
					
				}
				}
				break;
			case 4:
				if (validar.noEsTextoVacio(level4_n1) && validar.noEsTextoVacio(level4_n2) && validar.noEsTextoVacio(level4_n3) && validar.noEsTextoVacio(level4_n4) && validar.noEsTextoVacio(level4_n5)){
					j.agregarNum(Integer.parseInt(level4_n1.getText()));
					j.agregarNum(Integer.parseInt(level4_n2.getText()));
					j.agregarNum(Integer.parseInt(level4_n3.getText()));
					j.agregarNum(Integer.parseInt(level4_n4.getText()));
					j.agregarNum(Integer.parseInt(level4_n5.getText()));
				
				if(j.verificarCuenta()){
					j.subirNivel();
					level4_correcto.setText("Correcto");
					j.vaciarArray();
					JOptionPane.showMessageDialog(null, "Gano", "Gano",JOptionPane.INFORMATION_MESSAGE);
				}
				}
				break;
			}
			}
		});
		
		contentPane.add(btnNewButton);
		
		level1_n1 = new JTextField();
		level1_n1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				validar.validarNumeros(arg0);
			}
		});
		
		level1_n2 = new JTextField();
		level1_n1.setBounds(256, 228, 45, 45);
		contentPane.add(level1_n1);
		level1_n1.setColumns(10);
		
		
		level1_n2.setBounds(406, 228, 45, 45);
		level1_n2.setColumns(10);
		contentPane.add(level1_n2);
		
		JLabel lbl_r1 = new JLabel("l1_res");
		lbl_r1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_r1.setBounds(324, 154, 46, 20);
		contentPane.add(lbl_r1);
		if(j.getNivel() == 1)
			lbl_r1.setText("= " + j.getresultado());
		
		level1_op = new JLabel("l1_op2");
		level1_op.setFont(new Font("Tahoma", Font.BOLD, 14));
		level1_op.setBounds(324, 241, 46, 28);
		if(j.getNivel()==1){
			a = j.genOperador();
			j.agregarOp(a);
			level1_op.setText(j.mostrarOperador(a));
		}
		contentPane.add(level1_op);
		panel_n2.setLayout(null);
		
		//Nivel 2
		
				
		level2_n1 = new JTextField();
		level2_n1.setColumns(4);
		level2_n1.setBounds(10, 8, 45, 45);
		panel_n2.add(level2_n1);

		
		level2_op = new JLabel("l2_op");
		level2_op.setFont(new Font("Tahoma", Font.BOLD, 14));
		level2_op.setBounds(65, 20, 45, 29);
		panel_n2.add(level2_op);
		
		level2_n2 = new JTextField();
		level2_n2.setBounds(131, 8, 45, 45);
		panel_n2.add(level2_n2);
		level2_n2.setColumns(4);
		
		level2_op2 = new JLabel("l2_op2");
		level2_op2.setFont(new Font("Tahoma", Font.BOLD, 14));
		level2_op2.setBounds(199, 20, 45, 29);
		panel_n2.add(level2_op2);
		
		level2_n3 = new JTextField();
		level2_n3.setBounds(254, 8, 45, 45);
		panel_n2.add(level2_n3);
		level2_n3.setColumns(4);
				
		
		lbl_correcto = new JLabel("");
		lbl_correcto.setEnabled(false);
		lbl_correcto.setBounds(484, 249, 133, 20);
		contentPane.add(lbl_correcto);
		
		lbl2_correcto = new JLabel("");
		lbl2_correcto.setBounds(520, 318, 99, 50);
		contentPane.add(lbl2_correcto);
		
	
		
		level4_n1 = new JTextField();
		level4_n1.setBounds(15, 11, 45, 45);
		panel_n4.add(level4_n1);
		level4_n1.setColumns(10);
		
		level4_n2 = new JTextField();
		level4_n2.setColumns(10);
		level4_n2.setBounds(118, 11, 45, 45);
		panel_n4.add(level4_n2);
		
		level4_n3 = new JTextField();
		level4_n3.setColumns(10);
		level4_n3.setBounds(229, 11, 45, 45);
		panel_n4.add(level4_n3);
		
		level4_n4 = new JTextField();
		level4_n4.setColumns(10);
		level4_n4.setBounds(337, 11, 45, 45);
		panel_n4.add(level4_n4);
		
		level4_n5 = new JTextField();
		level4_n5.setColumns(10);
		level4_n5.setBounds(443, 11, 45, 45);
		panel_n4.add(level4_n5);
		
		level4_op = new JLabel("l2_op");
		level4_op.setFont(new Font("Tahoma", Font.BOLD, 14));
		level4_op.setBounds(70, 18, 36, 29);
		panel_n4.add(level4_op);
		
		level4_op2 = new JLabel("l2_op");
		level4_op2.setFont(new Font("Tahoma", Font.BOLD, 14));
		level4_op2.setBounds(181, 18, 36, 29);
		panel_n4.add(level4_op2);
		
		level4_op3 = new JLabel("l2_op");
		level4_op3.setFont(new Font("Tahoma", Font.BOLD, 14));
		level4_op3.setBounds(289, 18, 36, 29);
		panel_n4.add(level4_op3);
		
		level4_op4 = new JLabel("l2_op");
		level4_op4.setFont(new Font("Tahoma", Font.BOLD, 14));
		level4_op4.setBounds(392, 18, 36, 29);
		panel_n4.add(level4_op4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\IBM_ADMIN\\workspace\\TP1_Pr3\\src\\anticalculadora.png"));
		lblNewLabel.setBounds(49, 11, 700, 567);
		contentPane.add(lblNewLabel);
		
		level4_correcto = new JLabel("");
		level4_correcto.setBounds(607, 470, 99, 50);
		contentPane.add(level4_correcto);
		
	
	}

	public void setNombre (String Nombre){
		lbl_nombre.setText("Bienvenido " +Nombre.toString());
	}
}
