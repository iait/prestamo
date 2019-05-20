package iait.prestamo.entities;

import java.math.BigDecimal;

public class Cuota {
	
	private Integer cuota;
	private BigDecimal valor;
	private BigDecimal interes;
	private BigDecimal capital;
	private BigDecimal saldo;
	
	public Cuota(Integer cuota, BigDecimal valor, BigDecimal interes, BigDecimal capital, BigDecimal saldo) {
		super();
		this.cuota = cuota;
		this.valor = valor;
		this.interes = interes;
		this.capital = capital;
		this.saldo = saldo;
	}

	public Integer getCuota() {
		return cuota;
	}

	public void setCuota(Integer cuota) {
		this.cuota = cuota;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getInteres() {
		return interes;
	}

	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}

	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return String.format(
				"Cuota: %3d, Valor: %7.3f, Interés: %7.3f, Capital: %7.3f, Saldo: %7.3f", 
				cuota, valor, interes, capital, saldo);
	}
	
}
