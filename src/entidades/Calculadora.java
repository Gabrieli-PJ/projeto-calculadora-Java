package entidades;

public class Calculadora { // aqui é basicamente a mesma coisa da classe dos paineis
	public double AplicarDesconto(double num1, double num2){
		double v; 
		v = num1 - (num1 * (num2 / 100));
		return v;
	}; // você vai ter que fazer um desses pra cada painel q tiver, trocando a conta né
	//menos pro da senha q ja ta feito, boa sorte vc consegue <3
}
