package tests;

import static org.junit.Assert.*;

import org.junit.*;

import modelo.Cuenta;
import modelo.Empresa;

public class TestEmpresa {

	Empresa empresa1, empresa2;
	Cuenta cuenta;
	
	@Before
	public void setUp(){
		empresa1 = new Empresa("Sony");
		cuenta = new Cuenta();
	}
	
	@Test
	public void testCargarCuenta() {
		
		empresa1.agregarCuenta(cuenta);
		assertEquals("Cargar cuenta", 1, empresa1.getCuentas().size(), 0);
	}
	
	@Test
	public void testCompararEmpresas(){
		
		empresa2 = new Empresa("Sony");
		assertTrue("Comparar empresas", empresa1.equals(empresa2));
	}
	
	
	
	

}
