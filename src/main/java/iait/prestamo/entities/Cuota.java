package iait.prestamo.entities;

import java.math.BigDecimal;

public class Cuota {
	
	private Integer cuota;
	private BigDecimal valor;
	
	public Cuota(Integer cuota, BigDecimal valor) {
		super();
		this.cuota = cuota;
		this.valor = valor;
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

	@Override
	public String toString() {
		return "Cuota [cuota=" + cuota + ", valor=" + valor + "]";
	}

}
