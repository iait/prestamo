package iait.prestamo.entities;

import java.math.BigDecimal;

import iait.prestamo.enums.SistemaAmortizacion;

public class Prestamo {
	
	private BigDecimal capital;
	private Integer nroCuotas;
	private BigDecimal tna;
	private SistemaAmortizacion sistema;
	
	public Prestamo(BigDecimal capital, Integer nroCuotas, BigDecimal tna, SistemaAmortizacion sistema) {
		super();
		this.capital = capital;
		this.nroCuotas = nroCuotas;
		this.tna = tna;
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
		return tna;
	}

	public void setTna(BigDecimal tna) {
		this.tna = tna;
	}

	public SistemaAmortizacion getSistema() {
		return sistema;
	}

	public void setSistema(SistemaAmortizacion sistema) {
		this.sistema = sistema;
	}

	@Override
	public String toString() {
		return "Prestamo [capital=" + capital + ", nroCuotas=" + nroCuotas + ", tna=" + tna + ", sistema=" + sistema
				+ "]";
	}

}
