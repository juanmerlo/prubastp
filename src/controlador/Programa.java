package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import modelo.Cuenta;
import modelo.Empresa;

public class Programa {
	

	Set<Empresa> empresasSet;
	
	public Programa(){
	
		empresasSet = new HashSet<Empresa>();

	}
	
	public void cargarEmpresas(String rutaArchivoEmpresas){
		
		String file = rutaArchivoEmpresas;
		

		BufferedReader br = null;
		FileReader fr = null;
		
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String currentLine = null;
			

			br = new BufferedReader(new FileReader(file));
			
			while ((currentLine = br.readLine()) != null) {
				
				StringTokenizer stringTokenizer = new StringTokenizer(currentLine,",");

				Empresa empresa = new Empresa();
								
				empresa.setNombre(stringTokenizer.nextToken());
				empresa.setAnioApertura(Integer.parseInt(stringTokenizer.nextToken()));
				
				empresasSet.add(empresa);
				
			
			}
			
			
		
		} catch (FileNotFoundException e) { 
			// TODO Auto-generated catch block
			System.out.println("No existe el directorio");
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
	}
	
	public void mostrarEmpresas(){
			
		for(Iterator<Empresa> it = empresasSet.iterator(); it.hasNext();){
			
			Empresa empresa = it.next();
			
			System.out.println(empresa.getNombre() + " - " + empresa.getAnioApertura());
			
			//System.out.println(empresa);;
			
		}		
		
	}
	
	public void mostrarCuentasPorEmpresa(String nombreEmpresa){
		
		Empresa empresa = new Empresa(nombreEmpresa);
		
		for(Iterator<Empresa> it = empresasSet.iterator();it.hasNext();){
			
			Empresa empresa2 = it.next();
			if(empresa2.equals(empresa)){
				System.out.println(empresa2);
				
			}
						
			
		}
		
	}
	
	public void cargarCuentas(String rutaArchivoCuentas){
		
		String file = rutaArchivoCuentas;
		
		BufferedReader br = null;
		FileReader fr = null;
				
		try {
			
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String currentLine;
			
			br = new BufferedReader(new FileReader(file));
			
			while ((currentLine = br.readLine()) != null) {
												
				StringTokenizer stringTokenizer = new StringTokenizer(currentLine, ",");
					
				Cuenta cuenta = new Cuenta();

				
				Empresa empresa = new Empresa();
				empresa.setNombre(stringTokenizer.nextToken());
				cuenta.setNombre(stringTokenizer.nextToken());
				cuenta.setFecha(stringTokenizer.nextToken());
				cuenta.setValor(Double.parseDouble(stringTokenizer.nextToken()));
				
				for(Iterator<Empresa> it = empresasSet.iterator();it.hasNext();){
					
					Empresa empresa2 = it.next();
					if(empresa.equals(empresa2)){
						
						empresa2.agregarCuenta(cuenta);
						break;
					}
					
				}
				
			}			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("No existe el directorio");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
	
	public long sizeEmpresasSet(){
		
		return empresasSet.size();
	}

	

}
