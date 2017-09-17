package logica;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class Validaciones {

	int a;
	
	public void validarNumeros(KeyEvent e){
		a = e.getKeyChar();
		if(!Character.isDigit(a)){
			e.consume();
		}
	}
	
	public boolean noEsTextoVacio(JTextField txt){
		return txt.getText().length()!= 0;
	}

}
