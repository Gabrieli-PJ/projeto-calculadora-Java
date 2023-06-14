package entidades;

public class Calculadora { // aqui é basicamente a mesma coisa da classe dos paineis
	
	public String AplicarDesconto(double num1, double num2){
		
		double v; 
		v = num1 - (num1 * (num2 / 100));
		String s=String.format("%.2f", v);
		return s;
	};
	public String CalcularAcrescimo(double num1, double num2) {
		double v; 
		v = num1 + (num1 * (num2 / 100));
		String s=String.format("%.2f", v);
		return s;
	};
	public String Amostragem1(double num1, double num2) {
		double v; 
		v = (num1 * num2) / 100;
		String s=String.format("%.2f", v);
		return s;
	};
	public String Amostragem2(double num1, double num2) {
		double v; 
		v = num1 * (num2 / 100);
		String s=String.format("%.2f", v);
		return s;
	};
	public String QualDesconto(double num1, double num2) {
		double v; 
		v = ((num1 - num2) / num1) * 100;
		String s=String.format("%.2f", v);
		return s;
	};
	public String VarDelta(double num1, double num2) {
		double v; 
		v = ((num2 - num1) / num2) * 100;
		String s=String.format("%.2f", v);
		return s;
	};
	public String ValorOriginal(double num1, double num2) {
		double v; 
		v = (num1 * 100 / (100 - num2));
		String s=String.format("%.2f", v);
		return s;
	};
	public String Regra3(double num1, double num2, double num3) {
		double v; 
		v = (num3 * num2) / num1;
		String s=String.format("%.2f", v);
		return s;
	};
}
