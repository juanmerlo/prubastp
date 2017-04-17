package controlador;

import java.util.Scanner;

public class Main {

	static Programa programa;
	static Scanner entrada;
	
	public static void main(String[] args) {
		
		programa = new Programa();
		
		menu();
	
	}
	
	public static void menu(){
		
		System.out.println("1 - Cargar empresa");
		System.out.println("2 - Mostrar lista de empresas");
		System.out.println("3 - Cargar cuentas");
		System.out.println("4 - Mostrar cuentas de una empresa");
		System.out.println("0 - Terminar");
		
		entrada = new Scanner(System.in);

		switch(entrada.nextLine()){
			case "1":
				cargarEmpresas();
				break;
			case "2":
				mostrarEmpresas();
				break;
			case "3":
				cargarCuentas();
				break;
			case "4":
				mostrarCuentasDeEmpresa();
				break;
			case "0":
				System.out.println("Adiós");
				break;
			default:
				System.out.println("Inválido");
				menu();
				break;
		}
		
	}
	
	public static void cargarEmpresas(){
		System.out.println("Ingrese ruta del archivo csv:");
		entrada = new Scanner(System.in);
		programa.cargarEmpresas(entrada.nextLine());				
		menu();
	}
	
	public static void mostrarEmpresas(){
		if(programa.sizeEmpresasSet() > 0 ){
			programa.mostrarEmpresas();
		}else{
			
			System.out.println("No hay empresas");
		}
		menu();
	}
	
	public static void cargarCuentas(){
		
		if(programa.sizeEmpresasSet() > 0 ){
			System.out.println("Ingrese ruta del archivo csv:");
			entrada = new Scanner(System.in);
			programa.cargarCuentas(entrada.nextLine());	
		}else{
			
			System.out.println("No hay empresas");
		}
		menu();
		
	}
	
	public static void mostrarCuentasDeEmpresa(){
		if(programa.sizeEmpresasSet() > 0 ){
			System.out.println("Escriba el nombre de la empresa");
			entrada = new Scanner(System.in);
			programa.mostrarCuentasPorEmpresa(entrada.nextLine());
		}else{
			System.out.println("No hay empresas");

		}
		
		menu();
	}
	
	
}
