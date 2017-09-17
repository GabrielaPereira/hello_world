package logica;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Juego {
	String signos_operadores[];
	int resultado;
	private ArrayList<Integer> numeros;
	private ArrayList<Integer> operadores;
	private int nivel;
	
	public Juego(){
		signos_operadores = new String[4]; 
		signos_operadores [0] = "+";
		signos_operadores [1] = "-";
		signos_operadores [2] = "*";
		signos_operadores [3] = "/";
		numeros = new ArrayList<Integer>();
		operadores = new ArrayList<Integer>();
		nivel =1;
	}
	
	public int genOperador (){
		Random aleatorio = new Random();
		int pos  = aleatorio.nextInt(4);
		return pos;
	}
	public String mostrarOperador(int p){
		return signos_operadores [p];
	}
	public int getresultado() {
		Random aleatorio = new Random(System.currentTimeMillis());
		return resultado = aleatorio.nextInt(1233);
	}
	
	public void agregarOp(int a){
		operadores.add(a);
	}
	public void agregarNum (int b){
		numeros.add(b);
	}
	public int getNivel(){
		return nivel;
	}
	public void vaciarArray(){
		operadores.clear();
		numeros.clear();
		
	}
	public void subirNivel(){
		nivel++;
	}
	public boolean verificarCuenta(){
		if(operadores.contains(2) || operadores.contains(3)){
			for (int i=0;i<operadores.size();i++){
				if(operadores.get(i)==2){
					numeros.set(i, multiplicar(numeros.get(i), numeros.get(i+1)));
					numeros.remove(i+1);
					if(operadores.size()!=1)
					operadores.remove(i);
				}
				if(operadores.get(i)==3){
					if (numeros.get(i+1) == 0)
						JOptionPane.showMessageDialog(null, "No se puede dividir por cero", "Error",JOptionPane.ERROR_MESSAGE);
					else{
					numeros.set(i, dividir(numeros.get(i), numeros.get(i+1)));
					numeros.remove(i+1);
					if(operadores.size()!=1)
					operadores.remove(i);
					}
				}
			}
		}
		if(operadores.size()>0){
			for(int i=0;i<operadores.size();i++){
				if(operadores.get(i)==0){
					numeros.set(i, sumar(numeros.get(i), numeros.get(i+1)));
					numeros.remove(i+1);
					if(operadores.size()!=1)
					operadores.remove(i);
				}
				if(operadores.get(i)==1){
					numeros.set(i, restar(numeros.get(i), numeros.get(i+1)));
					numeros.remove(i+1);
					if(operadores.size()!=1)
					operadores.remove(i);
				}
			}
		}
		
		if(numeros.get(0)== resultado)
			return true;
		else
			return false;
	}
	
	public int  multiplicar(int n1, int n2){
		return n1*n2;
	}
	public int  dividir(int n1, int n2){
		return n1/n2;
	}
	public int  sumar(int n1, int n2){
		return n1+n2;
	}
	public int  restar(int n1, int n2){
		return n1-n2;
	}
	public void setearNivel1(int nivel){
		
	}
	public boolean verOperadoresVacio(){
		return this.operadores.size()==0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
