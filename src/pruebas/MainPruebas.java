package pruebas;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainPruebas {

	public static void main(String[] args) {

		System.out.println("Escribi la formula con el nombre las variables en mayusula. "
				+ "Sólo podés usar +,-,*,/,(,)");
		
		//returnResultado();
		returnResultadoConVariables();
		
		
	}
	
	public static void returnResultado(){
		
		
		Scanner entrada = new Scanner(System.in);
		
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    String foo = entrada.nextLine();
	    try {
			System.out.println(engine.eval(foo));
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void returnResultadoConVariables(){
		
		Scanner entrada = new Scanner(System.in);
		String stringEntrada = entrada.nextLine();
		
		StringTokenizer stringTokenizer = new StringTokenizer(stringEntrada, "+*-/()^ ");
		StringTokenizer finalTokenizer = stringTokenizer;
		
		String ecuacion = "";
		
		ArrayList<String> variables = new ArrayList<String>();
		ArrayList<Double> numeros = new ArrayList<Double>();
		
		while(stringTokenizer.hasMoreTokens()){
			
			variables.add(stringTokenizer.nextToken());
			
		}
		
		for(int i = 0; i < variables.size();i++){
			
			System.out.println("Ingrese " + variables.get(i));
			Scanner num = new Scanner(System.in);
			
			//numeros.add(Double.parseDouble(num.nextLine()));
			
			stringEntrada = stringEntrada.replace(variables.get(i), num.nextLine());
			
			
		}
		
		//String st = "4+3+Math.pow(3,2-1)";
		
		System.out.println(stringEntrada);
				
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    
	    try {
			System.out.println(engine.eval(stringEntrada));
			//System.out.println(engine.eval(st));

		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public static void returnResultadoManual(){
		
	}
	

}
