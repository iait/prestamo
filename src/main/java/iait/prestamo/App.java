package iait.prestamo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import iait.prestamo.entities.Cuota;
import iait.prestamo.entities.Prestamo;
import iait.prestamo.enums.SistemaAmortizacion;
import iait.prestamo.utils.CalculadoraPrestamos;

public class App {

	public static void main(String[] args) {

		System.out.println("Bienvenido a la calculadora de préstamos");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese capital solicitado:");
		String capitalStr = scanner.nextLine();
		BigDecimal capital = new BigDecimal(capitalStr);
		
		System.out.println("Ingrese número de cuotas:");
		String nroCuotasStr = scanner.nextLine();
		Integer nroCuotas = Integer.valueOf(nroCuotasStr);
		
		System.out.println("Ingrese el sistema de amortización:");
		String sistema = scanner.nextLine();
		
		System.out.println("Ingrese la tasa de interés (TNA):");
		String tasaStr = scanner.nextLine();
		BigDecimal tasa = new BigDecimal(tasaStr);

		Prestamo prestamo = new Prestamo(capital, nroCuotas, tasa, SistemaAmortizacion.FRANCES);
		List<Cuota> cuotas = CalculadoraPrestamos.calcularCuotas(prestamo);
		
		System.out.println(String.format(
				"Prestamo para un capital de %s en %d cuotas, con el sistema %s y una tasa de %s%%:", 
				capital, nroCuotas, sistema, tasa));
		cuotas.stream().forEach(c -> System.out.println(c));
		
		scanner.close();
	}

}
