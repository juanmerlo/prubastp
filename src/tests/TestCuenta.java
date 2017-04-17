package tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.*;

import modelo.Cuenta;

public class TestCuenta {

	Cuenta cuenta1, cuenta2;
	
	@Before
	public void setUp(){
	
		cuenta1 = new Cuenta();
		cuenta2 = new Cuenta();
		
	}
	
	@Test
	public void setearFecha(){
		cuenta1.setFecha("10/10/10");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			assertEquals("Setear Fecha",cuenta1.getFecha(), format.parse("10/10/10"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void compararCuentas() {

		cuenta1.setNombre("abc");
		cuenta1.setFecha("10/10/10");
		
		cuenta2.setNombre("abc");
		cuenta2.setFecha("10/10/10");
		
		assertTrue("Comprar cuentas", cuenta1.equals(cuenta2));
	}

}
