package secao8;

import java.util.Locale;
import java.util.Scanner;

public class ExeAula73 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		double cotacaoDolar, qtdDolar, reais;
		System.out.print("What is the dollar price? ");
		cotacaoDolar = sc.nextDouble();
		System.out.print("How many dollars will be bought? ");
		qtdDolar = sc.nextDouble();
		reais = CurrencyConverter.reais(cotacaoDolar, qtdDolar);
		System.out.printf("Amount to be paid in reais = %.2f", reais);
		
		sc.close();
	}

}
