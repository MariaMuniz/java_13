package br.com.codenation.calculadora;


public class CalculadoraSalario {
	private static final double SALARIO_MINIMO = 1039.00;

	private static final double SALARIO_TETO_INSS_MINIMO = 1500.0;
	private static final double SALARIO__TETO_INSS_MEDIO = 4000.0;
	private static final double TAXA_INSS_MINIMA = 0.08;
	private static final double TAXA_INSS_MEDIA = 0.09;
	private static final double TAXA_INSS_MAXIMA = 0.11;

	private static final double SALARIO_BASE_ISENTO_IRRF = 3000.0;
	private static final double SALARIO_BASE_DESCONTO_IRRF_ = 6000.0;
	private static final double TAXA_IRRF_ISENTO = 0.0;
	private static final double TAXA_IRRF_MINIMA = 0.075;
	private static final double TAXA_IRRF_MAXIMA = 0.15;

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-

		if (salarioBase < SALARIO_MINIMO) {
			return 0;
		}

		final double inss = calcularInss(salarioBase);
		final double salarioComDescontoInss = salarioBase - inss;
		final double impostoDeRendaCalculado = calcularIrrf(salarioComDescontoInss);
		final double salarioLiquido = salarioBase - inss - impostoDeRendaCalculado;

		return Math.round(salarioLiquido);
	}


	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		if (salarioBase <= SALARIO_TETO_INSS_MINIMO) {
			return salarioBase * TAXA_INSS_MINIMA;
		}

		if (salarioBase <= SALARIO__TETO_INSS_MEDIO) {
			return salarioBase * TAXA_INSS_MEDIA;
		}

		return salarioBase * TAXA_INSS_MAXIMA;
	}

	private double calcularIrrf(double salarioBase) {

		if (salarioBase <= SALARIO_BASE_ISENTO_IRRF) {
			return salarioBase * TAXA_IRRF_ISENTO;
		}

		if (salarioBase <= SALARIO_BASE_DESCONTO_IRRF_) {
			return salarioBase * TAXA_IRRF_MINIMA;
		}

		return salarioBase * TAXA_IRRF_MAXIMA;
	}
}

		//return 0.0;



/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/