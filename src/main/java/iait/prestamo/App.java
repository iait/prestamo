package iait.prestamo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import iait.prestamo.entities.Cuota;
import iait.prestamo.entities.Prestamo;
import iait.prestamo.enums.SistemaAmortizacion;
import iait.prestamo.utils.CalculadoraPrestamos;

public class App {

	public static void main(String[] args) {

		System.out.println("Bienvenido a la calculadora de préstamos");
		Scanner scanner = new Scanner(System.in);
		
		BigDecimal capital = null;
		while (capital == null) {
			System.out.println("Ingrese capital solicitado:");
			String capitalStr = scanner.nextLine();
			try {
				capital = new BigDecimal(capitalStr);
			} catch (NumberFormatException e) {
				System.out.println("¡Valor inválido! Debe ingresarse un número decimal.");
			}
		}
		
		Integer nroCuotas = null;
		while (nroCuotas == null) {
			System.out.println("Ingrese número de cuotas:");
			String nroCuotasStr = scanner.nextLine();
			try {
				nroCuotas = Integer.valueOf(nroCuotasStr);
			} catch (NumberFormatException e) {
				System.out.println("¡Valor inválido! Debe ingresarse un número entero (sin decimales).");
			}
		}
		
		SistemaAmortizacion sistema = null;
		while (sistema == null) {
			System.out.println("Ingrese el sistema de amortización:");
			String sistemaStr = scanner.nextLine();
			try {
				sistema = SistemaAmortizacion.valueOf(sistemaStr.toUpperCase());
			} catch (IllegalArgumentException e) {
				System.out.println(String.format("¡Valor inválido! Debe ingresarse un valor entre: %s", 
						Arrays.asList(SistemaAmortizacion.values()).stream()
							.map(sist -> sist.name())
							.collect(Collectors.joining(", "))));
			}
		}
		
		BigDecimal tasa = null;
		while (tasa == null) {
			System.out.println("Ingrese la tasa de interés:");
			String tasaStr = scanner.nextLine();
			try {
				tasa = new BigDecimal(tasaStr);
			} catch (NumberFormatException e) {
				System.out.println("¡Valor inválido! Debe ingresarse un número decimal.");
			}
		}

		scanner.close();
		Prestamo prestamo = new Prestamo(capital, nroCuotas, tasa, sistema);
		List<Cuota> cuotas;
		try {
			cuotas = CalculadoraPrestamos.calcularCuotas(prestamo);
		} catch (UnsupportedOperationException e) {
			System.out.println(String.format("¡Sistema de amortización %s todavía no soportado!", sistema.name()));
			return;
		}
		
		System.out.println(prestamo);
		cuotas.stream().forEach(c -> System.out.println(c));
	}

}
