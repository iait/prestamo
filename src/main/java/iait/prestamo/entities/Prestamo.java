package iait.prestamo.entities;

import java.math.BigDecimal;

import iait.prestamo.enums.SistemaAmortizacion;

public class Prestamo {
	
	private BigDecimal capital;
	private Integer nroCuotas;
	private BigDecimal tasa;
	private SistemaAmortizacion sistema;
	
	public Prestamo(BigDecimal capital, Integer nroCuotas, BigDecimal tasa, SistemaAmortizacion sistema) {
		super();
		this.capital = capital;
		this.nroCuotas = nroCuotas;
		this.tasa = tasa;
		this.sistema = sistema;
	}

	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	public Integer getNroCuotas() {
		return nroCuotas;
	}

	public void setNroCuotas(Integer nroCuotas) {
		this.nroCuotas = nroCuotas;
	}

	public BigDecimal getTna() {
		return tasa;
	}

	public void setTna(BigDecimal tna) {
		this.tasa = tna;
	}

	public SistemaAmortizacion getSistema() {
		return sistema;
	}

	public void setSistema(SistemaAmortizacion sistema) {
		this.sistema = sistema;
	}

	@Override
	public String toString() {
		return String.format(
				"Prestamo para un capital de $%s en %d cuotas, con el sistema %s y una tasa de %s%%:", 
				capital, nroCuotas, sistema, tasa);
	}

}
