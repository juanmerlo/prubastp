package exceptions;

public class NoSeEncontroLaCuentaException extends Throwable{

	private String indicador;
	private String empresa;
	private String cuenta;
	private static final long serialVersionUID = 1L;
	
	public NoSeEncontroLaCuentaException(String indicador, String empresa, String cuenta){
		
		this.indicador = indicador;
		this.empresa = empresa;
		this.cuenta = cuenta;
		
	}

	public String getIndicador() {
		return indicador;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getCuenta() {
		return cuenta;
	}
	
	

}
