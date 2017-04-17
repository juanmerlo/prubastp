package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import exceptions.NoSeEncontroLaCuentaException;

public class Indicador {

	private String nombre;
	
	private String calculo;

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalculo() {
		return calculo;
	}

	public void setCalculo(String calculo) {
		this.calculo = calculo;
	}
	
	public double calcular(Empresa empresa, Set<Indicador> indicadores) throws NoSeEncontroLaCuentaException{
		
		String ecuacion = this.calculo;
		
		StringTokenizer stringTokenizer = new StringTokenizer(ecuacion, "+*-/() ");
		
		ArrayList<String> variables = new ArrayList<String>();
		
		while(stringTokenizer.hasMoreTokens()){
			
			variables.add(stringTokenizer.nextToken());
			
		}
			
		for(int i = 0; i < variables.size();i++){
						
			boolean encontradoIndicador = false;
			boolean encontradoCuenta = false;
			
			Set<Indicador> indicadores2 = indicadores;
			Iterator<Indicador> itIndicadores = indicadores2.iterator();
			Indicador indicador = null;
			while(itIndicadores.hasNext() && !encontradoIndicador){
				indicador = itIndicadores.next();
				if(indicador.getNombre().equals(variables.get(i))){
					encontradoIndicador = true;
					System.out.println("Indicador " + indicador.getNombre());
					break;
				}else{
					System.out.println("No Indicador " + indicador.getNombre());
				}

			}
			
			
			Set<Cuenta> cuentas = empresa.getCuentas();
			Iterator<Cuenta> it = cuentas.iterator();
			Cuenta cuenta = null;
			while(it.hasNext() && !encontradoIndicador && !encontradoCuenta){
				cuenta = it.next();
				if(cuenta.getNombre().equals(variables.get(i))){
					encontradoCuenta = true;
					System.out.println("Cuenta " + cuenta.getNombre());
					break;

				}else{
					System.out.println("No cuenta " + cuenta.getNombre());
				}
			}
						
			if(encontradoIndicador){
				ecuacion = ecuacion.replace(variables.get(i), "(" + String.valueOf(indicador.calcular(empresa, indicadores) + ")"));
			}else if(encontradoCuenta){
				ecuacion = ecuacion.replace(variables.get(i), String.valueOf(cuenta.getValor()));

			}else{
			
				throw new NoSeEncontroLaCuentaException(this.getNombre(), empresa.getNombre(),variables.get(i));
			}

			
		}
				
		System.out.println(ecuacion);
				
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");

	    try {
		return (double) engine.eval(ecuacion);

		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return 0;
	}
	
	
}
