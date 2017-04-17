package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Empresa {
	


	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", cuentas=" + cuentas + ", anioApertura=" + anioApertura + "]";
	}

	
	private String nombre;
	
	private Set<Cuenta> cuentas = new HashSet<Cuenta>();

	
	private int anioApertura;

	public Empresa(){
		
	}
	
	public Empresa(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Set<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public int getAnioApertura() {
		return anioApertura;
	}

	public void setAnioApertura(int anioApertura) {
		this.anioApertura = anioApertura;
	}
	
	public void agregarCuenta(Cuenta cuenta){
		
		cuentas.add(cuenta);
		
		
	}
	
	 @Override
	    public boolean equals(Object o) {

	        if (o == this) return true;
	        if (!(o instanceof Empresa)) {
	            return false;
	        }
	        Empresa empresa = (Empresa) o;
	        return Objects.equals(nombre, empresa.getNombre());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(nombre);
	    }

}
