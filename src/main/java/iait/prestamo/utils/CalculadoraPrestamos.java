package iait.prestamo.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import iait.prestamo.entities.Cuota;
import iait.prestamo.entities.Prestamo;

public class CalculadoraPrestamos {
	
	private static BigDecimal calcularTasaPeriodo(BigDecimal porcentajeTasaAnual, Integer periodo) {
		BigDecimal tasaAnual = porcentajeTasaAnual.divide(BigDecimal.valueOf(100));
		Double tasaPeriodoDouble = Math.pow(1 + tasaAnual.doubleValue(), 1/periodo.doubleValue()) - 1;
		BigDecimal tasaPeriodo = BigDecimal.valueOf(tasaPeriodoDouble);
		return tasaPeriodo;
	}
	
	public static List<Cuota> calcularCuotas(Prestamo prestamo) {
		
		BigDecimal tasaMensual = calcularTasaPeriodo(prestamo.getTna(), 12);
		BigDecimal capital = prestamo.getCapital();
		Integer nroCuotas = prestamo.getNroCuotas();
		BigDecimal valorCuota = capital.multiply(
				tasaMensual.multiply(BigDecimal.ONE.add(tasaMensual).pow(nroCuotas)).divide(
				BigDecimal.ONE.add(tasaMensual).pow(nroCuotas).subtract(BigDecimal.ONE), 20, RoundingMode.HALF_EVEN));
		//
		List<Cuota> cuotas = new ArrayList<>();
		for (int i = 0; i < nroCuotas; i++) {
			Cuota cuota = new Cuota(i+1, valorCuota);
			cuotas.add(cuota);
		}
		return cuotas;
	}

}
