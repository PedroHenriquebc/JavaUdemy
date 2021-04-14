package secao8;

public class CurrencyConverter {
	public static final double IOF = 0.06;
	
	public static final double reais(double cotacaoDolar, double qtdDolar) {
		double impostoTotal = cotacaoDolar * qtdDolar * IOF;
		return (cotacaoDolar * qtdDolar) + impostoTotal;
	}
}
