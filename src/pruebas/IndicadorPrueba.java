package pruebas;

import java.util.HashSet;
import java.util.Set;

import exceptions.NoSeEncontroLaCuentaException;
import modelo.Cuenta;
import modelo.Empresa;
import modelo.Indicador;

public class IndicadorPrueba {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Indicador> indicadores = new HashSet<Indicador>();
		 
		Empresa sony = new Empresa();
		sony.setAnioApertura(2000);
		sony.setNombre("Sony");
		
		Cuenta a = new Cuenta();
		a.setFecha("30/3/2017");
		a.setNombre("a");
		a.setValor(1);
		sony.agregarCuenta(a);
		
		Cuenta b = new Cuenta();
		b.setFecha("30/3/2017");
		b.setNombre("b");
		b.setValor(2);
		sony.agregarCuenta(b);
		
		Cuenta c = new Cuenta();
		c.setFecha("30/10/2017");
		c.setNombre("c");
		c.setValor(3);
		sony.agregarCuenta(c);
		
		Cuenta d = new Cuenta();
		d.setFecha("30/5/2017");
		d.setNombre("d");
		d.setValor(4);
		sony.agregarCuenta(d);
		
		Cuenta e = new Cuenta();
		e.setFecha("30/3/2017");
		e.setNombre("e");
		e.setValor(5);
		sony.agregarCuenta(e);
		
		Indicador indicador1 = new Indicador();
		indicador1.setNombre("indicador1");
		indicador1.setCalculo("(a+d)/(a-indicador3)");
		
		Indicador indicador2 = new Indicador();
		indicador2.setNombre("indicador2");
		indicador2.setCalculo("a+b");
		
		Indicador indicador3 = new Indicador();
		indicador3.setNombre("indicador3");
		indicador3.setCalculo("a/b");
		
		Indicador indicador4 = new Indicador();
		indicador4.setNombre("indicador4");
		indicador4.setCalculo("a/b");
		
		
		
		
		indicadores.add(indicador1);
		indicadores.add(indicador2);
		indicadores.add(indicador3);
		indicadores.add(indicador4);

		try {
			System.out.println("Resulado: " + indicador1.calcular(sony, indicadores));
		} catch (NoSeEncontroLaCuentaException e1) {
			// TODO Auto-generated catch block
			System.out.println("El indicador " 
					+ e1.getIndicador() 
					+ " no puede calcularse ya que la empresa "
					+ e1.getEmpresa() 
					+ " no tiene cargada la cuenta " 
					+ e1.getCuenta() 
					+".");
		}
		
		
	}
	

}
