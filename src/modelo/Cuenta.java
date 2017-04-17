package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Cuenta {
	
	private String nombre;
	
	private double valor;
	
	private Date fecha;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");	
		
		try{
			Date date = format.parse(fecha);
			this.fecha = date;
		}catch(ParseException e){
			e.printStackTrace();
			System.out.println("Fecha erronea");
		}
	
	}
	
	 @Override
	    public boolean equals(Object o) {

	        if (o == this) return true;
	        if (!(o instanceof Cuenta)) {
	            return false;
	        }
	        Cuenta cuenta = (Cuenta) o;
	        return Objects.equals(nombre, cuenta.getNombre()) &&
	                Objects.equals(fecha, cuenta.getFecha());
	    }

    @Override
	public String toString() {
		return "Cuenta [nombre=" + nombre + ", valor=" + valor + ", fecha=" + fecha + "]";
	}

	@Override
    public int hashCode() {
        return Objects.hash(nombre, fecha);
    }
	
	
}
