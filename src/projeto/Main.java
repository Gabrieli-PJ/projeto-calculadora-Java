package projeto;

import java.awt.Color;

import javax.swing.JFrame;

import entidades.Paineis; // esse import aqui ta sendo usado porque eu coloquei o Paineis em outro pacote
//pacote é esses negocinho que parece um chocolate ali no Package explorer
//não sei por que fazer dois diferentes, mas no cursinho da Udemy lá o prof fez assim então acho que é pra ficar mais organizado


public class Main extends JFrame{	
		public Main() { // esse metodo é criado pra gente conseguir colocar as coisas no Main ali de baixo
			setSize(1300, 800);
			setTitle("Calculos Matemáticos");
			setLayout (null);
			getContentPane().setBackground(new Color(238, 243, 252));
			// Paineis // olha como fica organizado bonitinho quando a gente faz toda a bagunça em outro lugar
			Paineis p = new Paineis();
			//primeira fila//
			add(p.painel1A());
			add(p.painel2A());
			add(p.painel3A());
			add(p.painel4A());
			//segunda fila//
			add(p.painel1B());
			add(p.painel2B());
			add(p.painel3B());
			//terceira fila//
			add(p.painel1C());
			add(p.painel2C());
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		}
	
	public static void main(String[] args) {
		new Main(); // literalmente a unica coisa q a gente faz no main main é chamar essa bomba
	}

}
