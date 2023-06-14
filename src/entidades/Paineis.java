package entidades;

import java.awt.Color; // pra bota corzinha nas coisas
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent; // pra adicionar eventos nos botões
import java.awt.event.ActionListener; // pra "ouvir" os eventos que você coloca nos botões
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.Border;
import java.util.Random; // pra fazer o gerador de senha embaralhar os caracteres selecionados pelo usuario


import javax.swing.JCheckBox; // pra adicionar checkbox
import javax.swing.JButton; // adiciona botão
import javax.swing.AbstractAction; // pra fazer uma ação (ta usando la no gerador de senha)
import javax.swing.BorderFactory; // coloca bordas bonitinhas
import javax.swing.JFrame; // adiciona o frame (a tela maiorzona) 
import javax.swing.JLabel; // adiciona label (os textos que tem nos paineis)
import javax.swing.JOptionPane; // aqui ele faz aparecer o pop-up com a senha gerada, mas da de fazer mais coisa
import javax.swing.JPanel; // adiciona os paineis (as telas menorzinhas)
import javax.swing.JSpinner; // adiciona o negocinho que te deixa selecionar o tamanho da senha aleatoria
import javax.swing.JSpinner.NumberEditor;
import javax.swing.JTextField; // caixinha de texto que vc coloca os numeros pra calculadora (o ultimo textField de cada caixinha do lado do resultado tem um codigo especial pra não ser possivel digitar nele)
import javax.swing.SpinnerNumberModel; // bota uma opção do spinner no qual vc pode colocar o menor numero das opções, o primeiro numero que vai aparecer, o maior numero das opções e de quantos em quantos o spinner vai contar, nessa ordem

public class Paineis extends JFrame { // esse extends eh pra dizer que o Paineis ta recebendo os atributos do JFrame
	private static final long serialVersionUID = 1L;
	

				public JPanel painel1A() { // precisa criar cada painel em seu proprio metodo pra conseguir chamar ele direitinho no main
					JLabel labDesc, labValorIn, labPor, labConta;
					JTextField texValorIn, texDesc, labShowResult;
					JPanel painel1A = new JPanel();
					painel1A.setLayout(null);
					painel1A.setBackground(new Color(238, 243, 252));
					painel1A.setBounds(10, 10, 250, 150);
					painel1A.setBorder(BorderFactory.createTitledBorder("Aplicar desconto % num valor"));
					//JLabel/////////////////////////////////////////////
					labValorIn = new JLabel("Valor inicial R$: ");
					labValorIn.setBounds(35, 20, 100, 20);
					labValorIn.setForeground( new Color(139, 30, 63));
					painel1A.add(labValorIn); // adiciona o label no painel
					texValorIn = new JTextField();
					texValorIn.setBounds(127, 20, 100, 20);
					texValorIn.setBackground(new Color(251, 238, 242));
					texValorIn.setBorder(BorderFactory.createLineBorder(new Color(244, 205, 215)));
					texValorIn.setHorizontalAlignment(JTextField.CENTER);
					texValorIn.addMouseListener(new MouseAdapter(){ //limpa o textfield se tu clicar denovo nele
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texValorIn.setText("");
			            }
			        });
					painel1A.add(texValorIn); // adiciona o TextField no painel
							
					labDesc = new JLabel("Desconto aplicado: ");
					labDesc.setBounds(15, 50, 140, 20);
					labDesc.setForeground( new Color(28, 68, 142));
					painel1A.add(labDesc);
					texDesc = new JTextField();
					texDesc.setBounds(127, 50, 100, 20);
					texDesc.setBackground(new Color(220, 230, 249));
			        texDesc.setBorder(BorderFactory.createLineBorder(new Color(186, 206, 243)));
			        texDesc.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texDesc.setText("");
			            }
			        });
			        texDesc.setHorizontalAlignment(JTextField.CENTER);
					painel1A.add(texDesc);
							
					labPor = new JLabel("%");
					labPor.setBounds(230, 50, 175, 20);
					labPor.setForeground( new Color(28, 68, 142));
					painel1A.add(labPor);
					

					labShowResult = new JTextField();
					labShowResult.setBounds(127, 80, 100, 20);
					labShowResult.setEditable(false); // esse aqui é o comando que deixa o TextField não-editavel
					labShowResult.setBackground(new Color(194, 255, 222));
					labShowResult.setBorder(BorderFactory.createLineBorder(new Color(173, 255, 211)));
					labShowResult.setHorizontalAlignment(JTextField.CENTER);
					painel1A.add(labShowResult);
					
					JButton calculaBotao = new JButton("Resultado");
					calculaBotao.setBounds(20, 80, 100, 20);
					calculaBotao.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 48)));
					calculaBotao.setBorder(new RoundedBorder(10));
					calculaBotao.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        String valorInText = texValorIn.getText();
					        String descText = texDesc.getText();
					        
					        if (valorInText.isEmpty() || descText.isEmpty()) {
					            JOptionPane.showMessageDialog(null, "Por favor, preencha ambos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
					        } else {
					            double num1 = Double.parseDouble(valorInText);
					            double num2 = Double.parseDouble(descText);
					            Calculadora c = new Calculadora();
					            String v = c.AplicarDesconto(num1, num2);
					            labShowResult.setText(v);
					        }
					    }
					});
				       
				        painel1A.add(calculaBotao);
					
					labConta = new JLabel("v = num1 - (num1 * (num2 / 100))");
					labConta.setBounds(25, 110, 200, 30 );
					labConta.setForeground( new Color(97, 66, 88));
					labConta.setBorder(BorderFactory.createLoweredSoftBevelBorder());
					labConta.setHorizontalAlignment(JTextField.CENTER);
					painel1A.add(labConta);
					return painel1A;
				};
				
				// todos os outros paineis exceto o ultimo vão ter o mesmo estilo desse primeiro, então só vou voltar a escrever lá no ultimo :D
				public JPanel painel2A(){
					JLabel labAcre, labValorIn, labPor, labConta;
					JTextField texValorIn, texAcre, texShowResult;
					JPanel painel2A = new JPanel();
					painel2A.setBackground(new Color(238, 243, 252));
					painel2A.setLayout(null);
					painel2A.setBounds(270, 10, 250, 150);
					painel2A.setBorder(BorderFactory.createTitledBorder("Incrementar % num valor"));
					//JLabel/////////////////////////////////////////////
					labValorIn = new JLabel("Valor inicial R$: ");
					labValorIn.setBounds(35, 20, 100, 20);
					labValorIn.setForeground( new Color(139, 30, 63));
					painel2A.add(labValorIn);
					texValorIn = new JTextField();
					texValorIn.setBounds(127, 20, 100, 20);
					texValorIn.setBackground(new Color(251, 238, 242));
					texValorIn.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texValorIn.setText("");
			            }
			        });
			        texValorIn.setHorizontalAlignment(JTextField.CENTER);
					texValorIn.setBorder(BorderFactory.createLineBorder(new Color(244, 205, 215)));
					painel2A.add(texValorIn);
							
					labAcre = new JLabel("Acréscimo aplicado: ");
					labAcre.setBounds(8, 50, 140, 20);
					labAcre.setForeground( new Color(28, 68, 142));
					painel2A.add(labAcre);
					texAcre = new JTextField();
					texAcre.setBounds(127, 50, 100, 20);
					texAcre.setBackground(new Color(220, 230, 249));
					texAcre.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texAcre.setText("");
			            }
			        });
			        texAcre.setHorizontalAlignment(JTextField.CENTER); 
			        texAcre.setBorder(BorderFactory.createLineBorder(new Color(186, 206, 243)));
					painel2A.add(texAcre);
							
					labPor = new JLabel("%");
					labPor.setBounds(230, 50, 175, 20);
					labPor.setForeground( new Color(28, 68, 142));
					painel2A.add(labPor);
					
					texShowResult = new JTextField();
					texShowResult.setBounds(127, 80, 100, 20);
					texShowResult.setEditable(false); // esse aqui é o comando que deixa o TextField não-editavel
					texShowResult.setBackground(new Color(194, 255, 222));
					texShowResult.setBorder(BorderFactory.createLineBorder(new Color(173, 255, 211)));
					texShowResult.setHorizontalAlignment(JTextField.CENTER);
					painel2A.add(texShowResult);
					
					JButton calculaBotao = new JButton("Resultado"); // botão bem lindo pra calcular porque sem ele eu achei literalmente I M P O S S I V E L	
			        calculaBotao.setBounds(20, 80, 100, 20);
			        calculaBotao.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 48)));
			        calculaBotao.setBorder(new RoundedBorder(10));
			        calculaBotao.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        String valorInText = texValorIn.getText();
					        String descText = texAcre.getText();
					        
					        if (valorInText.isEmpty() || descText.isEmpty()) {
					            JOptionPane.showMessageDialog(null, "Por favor, preencha ambos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
					        } else {
					            double num1 = Double.parseDouble(valorInText);
					            double num2 = Double.parseDouble(descText);
					            Calculadora c = new Calculadora();
					            String v = c.CalcularAcrescimo(num1, num2);
					            texShowResult.setText(v);
					        }
					    }
					});
			        painel2A.add(calculaBotao);
					
					labConta = new JLabel("v = num1 + (num1 * (num2 / 100))");
					labConta.setBounds(25, 110, 200, 30);
					labConta.setForeground( new Color(97, 66, 88));
					labConta.setHorizontalAlignment(JTextField.CENTER);
					labConta.setBorder(BorderFactory.createLoweredSoftBevelBorder());
					painel2A.add(labConta);
					return painel2A;
				};
				public JPanel painel3A() {
					JLabel labDesc, labValorIn, labPor, labConta;
					JTextField texValorIn, texDesc, texShowResult;
					JPanel painel3A = new JPanel();
					painel3A.setLayout(null);
					painel3A.setBackground(new Color(238, 243, 252));
					painel3A.setBounds(530, 10, 250, 150);
					painel3A.setBorder(BorderFactory.createTitledBorder("Amostragem: quanto X% representa de Y"));
					//JLabel/////////////////////////////////////////////
					labValorIn = new JLabel("Total (Y): ");
					labValorIn.setBounds(75, 20, 100, 20);
					labValorIn.setForeground( new Color(139, 30, 63));
					painel3A.add(labValorIn);
					texValorIn = new JTextField();
					texValorIn.setBounds(127, 20, 100, 20);
					texValorIn.setBackground(new Color(251, 238, 242));
					texValorIn.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texValorIn.setText("");
			            }
			        });
			        texValorIn.setHorizontalAlignment(JTextField.CENTER);
					texValorIn.setBorder(BorderFactory.createLineBorder(new Color(244, 205, 215)));
					painel3A.add(texValorIn);
							
					labDesc = new JLabel("Porcentagem (X): ");
					labDesc.setBounds(25, 50, 140, 20);
					labDesc.setForeground( new Color(28, 68, 142));
					painel3A.add(labDesc);
					texDesc = new JTextField();
					texDesc.setBounds(127, 50, 100, 20);
					texDesc.setBackground(new Color(220, 230, 249));
					texDesc.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texDesc.setText("");
			            }
			        });
			        texDesc.setHorizontalAlignment(JTextField.CENTER);
			        texDesc.setBorder(BorderFactory.createLineBorder(new Color(186, 206, 243)));
					painel3A.add(texDesc);
							
					labPor = new JLabel("%");
					labPor.setBounds(230, 50, 175, 20);
					labPor.setForeground( new Color(28, 68, 142));
					painel3A.add(labPor);
					
					texShowResult = new JTextField();
					texShowResult.setBounds(127, 80, 100, 20);
					texShowResult.setEditable(false); // esse aqui é o comando que deixa o TextField não-editavel
					texShowResult.setBackground(new Color(194, 255, 222));
					texShowResult.setBorder(BorderFactory.createLineBorder(new Color(173, 255, 211)));
					texShowResult.setHorizontalAlignment(JTextField.CENTER);
					painel3A.add(texShowResult);

					JButton calculaBotao = new JButton("Corresponde a"); // botão bem lindo pra calcular porque sem ele eu achei literalmente I M P O S S I V E L	
			        calculaBotao.setBounds(12, 80, 110, 20);
			        calculaBotao.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 48)));
			        calculaBotao.setBorder(new RoundedBorder(10));
			        calculaBotao.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        String valorInText = texValorIn.getText();
					        String descText = texDesc.getText();
					        
					        if (valorInText.isEmpty() || descText.isEmpty()) {
					            JOptionPane.showMessageDialog(null, "Por favor, preencha ambos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
					        } else {
					            double num1 = Double.parseDouble(valorInText);
					            double num2 = Double.parseDouble(descText);
					            Calculadora c = new Calculadora();
					            String v = c.Amostragem1(num1, num2);
					            texShowResult.setText(v);
					        }
					    }
					});
			        painel3A.add(calculaBotao);
			        
					
					labConta = new JLabel(" v = (num1 * num2) / 100");
					labConta.setBounds(25, 110, 200, 30 );
					labConta.setForeground( new Color(97, 66, 88));
					labConta.setHorizontalAlignment(JTextField.CENTER);
					labConta.setBorder(BorderFactory.createLoweredSoftBevelBorder());
					painel3A.add(labConta);
					return painel3A;
				};
				public JPanel painel4A() {
					JLabel labDesc, labValorIn, labPor, labConta;
					JTextField texValorIn, texDesc, texShowResult;
					JPanel painel4A = new JPanel();
					painel4A.setLayout(null);
					painel4A.setBackground(new Color(238, 243, 252));
					painel4A.setBounds(790, 10, 250, 150);
					painel4A.setBorder(BorderFactory.createTitledBorder("Amostragem 2: quanto X representa de Y"));
					//JLabel/////////////////////////////////////////////
					labValorIn = new JLabel("Total (Y): ");
					labValorIn.setBounds(75, 20, 100, 20);
					labValorIn.setForeground( new Color(139, 30, 63));
					painel4A.add(labValorIn);
					texValorIn = new JTextField();
					texValorIn.setBounds(127, 20, 100, 20);
					texValorIn.setBackground(new Color(251, 238, 242));
					texValorIn.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texValorIn.setText("");
			            }
			        });
			        texValorIn.setHorizontalAlignment(JTextField.CENTER);
					texValorIn.setBorder(BorderFactory.createLineBorder(new Color(244, 205, 215)));
					painel4A.add(texValorIn);
							
					labDesc = new JLabel("Parte (X): ");
					labDesc.setBounds(70, 50, 140, 20);
					labDesc.setForeground( new Color(28, 68, 142));
					painel4A.add(labDesc);
					texDesc = new JTextField();
					texDesc.setBounds(127, 50, 100, 20);
					texDesc.setBackground(new Color(220, 230, 249));
					texDesc.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texDesc.setText("");
			            }
			        });
			        texDesc.setHorizontalAlignment(JTextField.CENTER);texDesc.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texDesc.setText("");
			            }
			        });
			        texDesc.setHorizontalAlignment(JTextField.CENTER);
			        texDesc.setBorder(BorderFactory.createLineBorder(new Color(186, 206, 243)));
					painel4A.add(texDesc);
		
					texShowResult = new JTextField();
					texShowResult.setBounds(127, 80, 100, 20);
					texShowResult.setEditable(false); // esse aqui é o comando que deixa o TextField não-editavel
					texShowResult.setBackground(new Color(194, 255, 222));
					texShowResult.setBorder(BorderFactory.createLineBorder(new Color(173, 255, 211)));
					texShowResult.setHorizontalAlignment(JTextField.CENTER);
					painel4A.add(texShowResult);

					JButton calculaBotao = new JButton("Corresponde a"); // botão bem lindo pra calcular porque sem ele eu achei literalmente I M P O S S I V E L	
			        calculaBotao.setBounds(12, 80, 110, 20);
			        calculaBotao.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 48)));
			        calculaBotao.setBorder(new RoundedBorder(10));
			        calculaBotao.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        String valorInText = texValorIn.getText();
					        String descText = texDesc.getText();
					        
					        if (valorInText.isEmpty() || descText.isEmpty()) {
					            JOptionPane.showMessageDialog(null, "Por favor, preencha ambos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
					        } else {
					            double num1 = Double.parseDouble(valorInText);
					            double num2 = Double.parseDouble(descText);
					            Calculadora c = new Calculadora();
					            String v = c.Amostragem2(num1, num2);
					            texShowResult.setText(v);
					        }
					    }
					});
			        painel4A.add(calculaBotao);

					labPor = new JLabel("%");
					labPor.setBounds(230, 80, 175, 20);
					labPor.setForeground( new Color(0, 102, 48));
					painel4A.add(labPor);
					
					labConta = new JLabel("v = num1 * (num2 / 100)");
					labConta.setBounds(25, 110, 200, 30);
					labConta.setForeground( new Color(97, 66, 88));
					labConta.setHorizontalAlignment(JTextField.CENTER);
					labConta.setBorder(BorderFactory.createLoweredSoftBevelBorder());
					painel4A.add(labConta);
					return painel4A;
				};
				
				
				public JPanel painel1B(){
					JLabel labDesc, labValorIn, labPor, labConta;
					JTextField texValorIn, texDesc, texShowResult;
					JPanel painel1B = new JPanel();
					painel1B.setLayout(null);
					painel1B.setBackground(new Color(238, 243, 252));
					painel1B.setBounds(110, 170, 280, 150);
					painel1B.setBorder(BorderFactory.createTitledBorder("Valor era X e paguei Y, qual foi o desconto(%)"));
					//JLabel/////////////////////////////////////////////
					labValorIn = new JLabel("Valor original (X): ");
					labValorIn.setBounds(40, 20, 100, 20);
					labValorIn.setForeground( new Color(139, 30, 63));
					painel1B.add(labValorIn);
					texValorIn = new JTextField();
					texValorIn.setBounds(142, 20, 100, 20);
					texValorIn.setBackground(new Color(251, 238, 242));
					texValorIn.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texValorIn.setText("");
			            }
			        });
			        texValorIn.setHorizontalAlignment(JTextField.CENTER);
					texValorIn.setBorder(BorderFactory.createLineBorder(new Color(244, 205, 215)));
					painel1B.add(texValorIn);
							
					labDesc = new JLabel("Valor c/ desconto (Y): ");
					labDesc.setBounds(18, 50, 140, 20);
					labDesc.setForeground( new Color(28, 68, 142));
					painel1B.add(labDesc);
					texDesc = new JTextField();
					texDesc.setBounds(142, 50, 100, 20);
					texDesc.setBackground(new Color(220, 230, 249));
					texDesc.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texDesc.setText("");
			            }
			        });
			        texDesc.setHorizontalAlignment(JTextField.CENTER);
			        texDesc.setBorder(BorderFactory.createLineBorder(new Color(186, 206, 243)));
					painel1B.add(texDesc);
					
					texShowResult = new JTextField();
					texShowResult.setBounds(142, 80, 100, 20);
					texShowResult.setEditable(false);
					texShowResult.setBackground(new Color(194, 255, 222));
					texShowResult.setBorder(BorderFactory.createLineBorder(new Color(173, 255, 211)));
					texShowResult.setHorizontalAlignment(JTextField.CENTER);
					painel1B.add(texShowResult);

					JButton calculaBotao = new JButton("Desconto");
			        calculaBotao.setBounds(35, 80, 100, 20);
			        calculaBotao.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 48)));
			        calculaBotao.setBorder(new RoundedBorder(10));
			        calculaBotao.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        String valorInText = texValorIn.getText();
					        String descText = texDesc.getText();
					        
					        if (valorInText.isEmpty() || descText.isEmpty()) {
					            JOptionPane.showMessageDialog(null, "Por favor, preencha ambos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
					        } else {
					            double num1 = Double.parseDouble(valorInText);
					            double num2 = Double.parseDouble(descText);
					            Calculadora c = new Calculadora();
					            String v = c.QualDesconto(num1, num2);
					            texShowResult.setText(v);
					        }
					    }
					});
			        painel1B.add(calculaBotao);
					
					labPor = new JLabel("%");
					labPor.setBounds(245, 80, 175, 20);
					labPor.setForeground( new Color(0, 102, 48));
					painel1B.add(labPor);
					
					labConta = new JLabel(" v = ((num1 - num2) / num1) * 100");
					labConta.setBounds(25, 110, 220, 30);
					labConta.setForeground( new Color(97, 66, 88));
					labConta.setHorizontalAlignment(JTextField.CENTER);
					labConta.setBorder(BorderFactory.createLoweredSoftBevelBorder());
					painel1B.add(labConta);
					return painel1B;
				};
				public JPanel painel2B(){
					JLabel labDesc, labValorIn, labPor, labConta;
					JTextField texValorIn, texDesc, texShowResult;
					JPanel painel2B = new JPanel();
					painel2B.setLayout(null);
					painel2B.setBackground(new Color(238, 243, 252));
					painel2B.setBounds(400, 170, 280, 150);
					painel2B.setBorder(BorderFactory.createTitledBorder("Variação Delta(%) - diferença % entre valores"));
					//JLabel/////////////////////////////////////////////
					labValorIn = new JLabel("Valor inicial: ");
					labValorIn.setBounds(68, 20, 100, 20);
					labValorIn.setForeground( new Color(139, 30, 63));
					painel2B.add(labValorIn);
					texValorIn = new JTextField();
					texValorIn.setBounds(142, 20, 100, 20);
					texValorIn.setBackground(new Color(251, 238, 242));
					texValorIn.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texValorIn.setText("");
			            }
			        });
			        texValorIn.setHorizontalAlignment(JTextField.CENTER);
					texValorIn.setBorder(BorderFactory.createLineBorder(new Color(244, 205, 215)));
					painel2B.add(texValorIn);
							
					labDesc = new JLabel("Valor final: ");
					labDesc.setBounds(77, 50, 140, 20);
					labDesc.setForeground( new Color(28, 68, 142));
					painel2B.add(labDesc);
					texDesc = new JTextField();
					texDesc.setBounds(142, 50, 100, 20);
					texDesc.setBackground(new Color(220, 230, 249));
					texDesc.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texDesc.setText("");
			            }
			        });
			        texDesc.setHorizontalAlignment(JTextField.CENTER);
			        texDesc.setBorder(BorderFactory.createLineBorder(new Color(186, 206, 243)));
					painel2B.add(texDesc);
					
					texShowResult = new JTextField();
					texShowResult.setBounds(142, 80, 100, 20);
					texShowResult.setEditable(false);
					texShowResult.setBackground(new Color(194, 255, 222));
					texShowResult.setBorder(BorderFactory.createLineBorder(new Color(173, 255, 211)));
					texShowResult.setHorizontalAlignment(JTextField.CENTER);
					painel2B.add(texShowResult);
					
					JButton calculaBotao = new JButton("Diferença");
			        calculaBotao.setBounds(35, 80, 100, 20);
			        calculaBotao.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 48)));
			        calculaBotao.setBorder(new RoundedBorder(10));
			        calculaBotao.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        String valorInText = texValorIn.getText();
					        String descText = texDesc.getText();
					        
					        if (valorInText.isEmpty() || descText.isEmpty()) {
					            JOptionPane.showMessageDialog(null, "Por favor, preencha ambos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
					        } else {
					            double num1 = Double.parseDouble(valorInText);
					            double num2 = Double.parseDouble(descText);
					            Calculadora c = new Calculadora();
					            String v = c.VarDelta(num1, num2);
					            texShowResult.setText(v);
					        }
					    }
					});
			        painel2B.add(calculaBotao);

					labPor = new JLabel("%");
					labPor.setBounds(245, 80, 175, 20);
					labPor.setForeground( new Color(0, 102, 48));
					painel2B.add(labPor);

					
					labConta = new JLabel(" v = ((num2 - num1) / num2) * 100");
					labConta.setBounds(25, 110, 220, 30);
					labConta.setForeground( new Color(97, 66, 88));
					labConta.setHorizontalAlignment(JTextField.CENTER);
					labConta.setBorder(BorderFactory.createLoweredSoftBevelBorder());
					painel2B.add(labConta);
					return painel2B;
				};
				public JPanel painel3B() {
						JLabel labDesc, labValorFi, labPor, labConta;
						JTextField texValorFi, texDesc, texShowResult;
						JPanel painel3B = new JPanel();
						painel3B.setLayout(null);
						painel3B.setBackground(new Color(238, 243, 252));
						painel3B.setBounds(690, 170, 280, 150);
						painel3B.setBorder(BorderFactory.createTitledBorder("Qual era o valor original?"));
						//JLabel/////////////////////////////////////////////
						labValorFi = new JLabel("Valor final R$: ");
						labValorFi.setBounds(60, 20, 100, 20);
						labValorFi.setForeground( new Color(139, 30, 63));
						painel3B.add(labValorFi);
						texValorFi = new JTextField();
						texValorFi.setBounds(142, 20, 100, 20);
						texValorFi.setBackground(new Color(251, 238, 242));
						texValorFi.addMouseListener(new MouseAdapter(){
				            @Override
				            public void mouseClicked(MouseEvent e){
				                texValorFi.setText("");
				            }
				        });
				        texValorFi.setHorizontalAlignment(JTextField.CENTER);
						texValorFi.setBorder(BorderFactory.createLineBorder(new Color(244, 205, 215)));
						painel3B.add(texValorFi);
								
						labDesc = new JLabel("% desconto: ");
						labDesc.setBounds(70, 50, 140, 20);
						labDesc.setForeground( new Color(28, 68, 142));
						painel3B.add(labDesc);
						texDesc = new JTextField();
						texDesc.setBounds(142, 50, 100, 20);
						texDesc.setBackground(new Color(220, 230, 249));
						texDesc.addMouseListener(new MouseAdapter(){
				            @Override
				            public void mouseClicked(MouseEvent e){
				                texDesc.setText("");
				            }
				        });
				        texDesc.setHorizontalAlignment(JTextField.CENTER);
				        texDesc.setBorder(BorderFactory.createLineBorder(new Color(186, 206, 243)));
						painel3B.add(texDesc);
								
						labPor = new JLabel("%");
						labPor.setBounds(245, 50, 175, 20);
						labPor.setForeground( new Color(28, 68, 142));
						painel3B.add(labPor);
						
						texShowResult = new JTextField();
						texShowResult.setBounds(142, 80, 100, 20);
						texShowResult.setEditable(false);
						texShowResult.setBackground(new Color(194, 255, 222));
						texShowResult.setBorder(BorderFactory.createLineBorder(new Color(173, 255, 211)));
						texShowResult.setHorizontalAlignment(JTextField.CENTER);
						painel3B.add(texShowResult);
						
						JButton calculaBotao = new JButton("Valor Inicial");
				        calculaBotao.setBounds(35, 80, 100, 20);
				        calculaBotao.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 48)));
				        calculaBotao.setBorder(new RoundedBorder(10));
				        calculaBotao.addActionListener(new ActionListener() {
						    public void actionPerformed(ActionEvent e) {
						        String valorInText = texValorFi.getText();
						        String descText = texDesc.getText();
						        
						        if (valorInText.isEmpty() || descText.isEmpty()) {
						            JOptionPane.showMessageDialog(null, "Por favor, preencha ambos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
						        } else {
						            double num1 = Double.parseDouble(valorInText);
						            double num2 = Double.parseDouble(descText);
						            Calculadora c = new Calculadora();
						            String v = c.ValorOriginal(num1, num2);
						            texShowResult.setText(v);
						        }
						    }
						});
				        painel3B.add(calculaBotao);
						
						labConta = new JLabel(" v = (a * 100 / (100 - b))");
						labConta.setBounds(25, 110, 220, 30);
						labConta.setForeground( new Color(97, 66, 88));
						labConta.setHorizontalAlignment(JTextField.CENTER);
						labConta.setBorder(BorderFactory.createLoweredSoftBevelBorder());
						painel3B.add(labConta);
						return painel3B;
				};
				
				public JPanel painel1C(){
					JLabel labB, labA, labR1, labConta;
					JTextField texA, texB, texR1, texR2;
					JPanel painel1C = new JPanel();
					painel1C.setLayout(null);
					painel1C.setBackground(new Color(238, 243, 252));
					painel1C.setBounds(195, 330, 300, 150);
					painel1C.setBorder(BorderFactory.createTitledBorder("Regra de Três"));
					//JLabel/////////////////////////////////////////////
					labA = new JLabel("a: ");
					labA.setBounds(20, 40, 100, 20);
					labA.setForeground( new Color(139, 30, 63));
					painel1C.add(labA);
					texA = new JTextField();
					texA.setBounds(35, 40, 100, 20);
					texA.setBackground(new Color(251, 238, 242));
					texA.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texA.setText("");
			            }
			        });
			        texA.setHorizontalAlignment(JTextField.CENTER);
					texA.setBorder(BorderFactory.createLineBorder(new Color(244, 205, 215)));
					painel1C.add(texA);
							
					labB = new JLabel("b: ");
					labB.setBounds(20, 77, 140, 20);
					labB.setForeground( new Color(28, 68, 142));
					painel1C.add(labB);
					texB = new JTextField();
					texB.setBounds(35, 77, 100, 20);
					texB.setBackground(new Color(220, 230, 249));
					texB.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texB.setText("");
			            }
			        });
			        texB.setHorizontalAlignment(JTextField.CENTER);
			        texB.setBorder(BorderFactory.createLineBorder(new Color(186, 206, 243)));
					painel1C.add(texB);
							
					labR1 = new JLabel(" =   r1: ");
					labR1.setBounds(145, 40, 175, 20);
					labR1.setForeground( new Color(75, 61, 82));
					painel1C.add(labR1);
					texR1 = new JTextField();
					texR1.setBounds(182, 40, 100, 20);
					texR1.setBackground(new Color(198, 185, 203));
					texR1.addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			                texB.setText("");
			            }
			        });
			        texR1.setHorizontalAlignment(JTextField.CENTER);
			        texR1.setBorder(BorderFactory.createLineBorder(new Color(138, 114, 151)));
					painel1C.add(texR1);
					
					texR2 = new JTextField();
					texR2.setBounds(182, 77, 100, 20);
					texR2.setEditable(false);
					texR2.setBackground(new Color(194, 255, 222));
					texR2.setBorder(BorderFactory.createLineBorder(new Color(173, 255, 211)));
					texR2.setHorizontalAlignment(JTextField.CENTER);
					painel1C.add(texR2);

					JButton calculaBotao = new JButton("R2");
			        calculaBotao.setBounds(140, 77, 40, 20);
			        calculaBotao.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 48)));
			        calculaBotao.setBorder(new RoundedBorder(10));
			        calculaBotao.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        String AText = texA.getText();
					        String BText = texB.getText();
					        String R1Text = texR1.getText();
					        
					        if (AText.isEmpty() || BText.isEmpty() || R1Text.isEmpty()) {
					            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
					        } else {
					            double num1 = Double.parseDouble(AText);
					            double num2 = Double.parseDouble(BText);
					            double num3 = Double.parseDouble(R1Text);
					            Calculadora c = new Calculadora();
					            String v = c.Regra3(num1, num2, num3);
					            texR2.setText(v);
					        }
					    }
					});
			        painel1C.add(calculaBotao);
					
					labConta = new JLabel(" r2 = (r1 * b) / a");
					labConta.setBounds(25, 110, 240, 30);
					labConta.setForeground( new Color(97, 66, 88));
					labConta.setHorizontalAlignment(JTextField.CENTER);
					labConta.setBorder(BorderFactory.createLoweredSoftBevelBorder());
					painel1C.add(labConta);
					return painel1C;
				};
				public JPanel painel2C(){ // gerador de senha dificil muito chato de fazer
					JPanel painel2C = new JPanel();
					painel2C.setLayout(null);
					painel2C.setBackground(new Color(238, 243, 252));
					painel2C.setBounds(505, 330, 300, 150);
					painel2C.setBorder(BorderFactory.createTitledBorder("Gerador de senha"));
					//aqui são as mesmas coisas dos outros paineis só que ao inves de usar JLabel e JTextField a gente usa JCheckBox
					JCheckBox chkMaiuscula, chkMinuscula, chkNumero, chkSimbolo;
					chkMaiuscula = new JCheckBox("Maiúsculas");
					chkMaiuscula.setBounds(25, 25, 100, 25);
					chkMaiuscula.setForeground( new Color(28, 68, 142));
					painel2C.add(chkMaiuscula);
					chkMinuscula = new JCheckBox("Minúsculas");
					chkMinuscula.setBounds(25, 55, 100, 25);
					chkMinuscula.setForeground( new Color(28, 68, 142));
					painel2C.add(chkMinuscula);
					chkNumero = new JCheckBox("Números");
					chkNumero.setBounds(175, 25, 100, 25);
					chkNumero.setForeground( new Color(28, 68, 142));
					painel2C.add(chkNumero);
					chkSimbolo = new JCheckBox("Símbolos");
					chkSimbolo.setBounds(175, 55, 100, 25);
					chkSimbolo.setForeground( new Color(28, 68, 142));
					painel2C.add(chkSimbolo);
					//spinner - esse aqui foi chato de fazer meu deus
			        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 20, 1);
			        JSpinner spnComprimento = new JSpinner(model);
			        spnComprimento.setBounds(88, 100, 45, 30);
			        NumberEditor editor = new JSpinner.NumberEditor(spnComprimento);
			        spnComprimento.setEditor(editor);
			        painel2C.add(spnComprimento);
					//botao
					JButton btnGerarSenha = new JButton(new AbstractAction("Gerar Senha") { // abstractAction é bem parecido com ActionListener, mas no ActionListener vc não pode colocar mais subclasses, tipo esses private void q tem aqui  
						private static final long serialVersionUID = 1L;

						public void actionPerformed(ActionEvent e) {
							gerarSenha();
							
						}

						private void gerarSenha() {
							StringBuilder caracteres = new StringBuilder(); // isso aqui vai contruir a nossa senha soq não embaralhada
						    Random random = new Random(); 
						    
						    // Verifica quais elementos foram selecionados, deixando eles separadinhos bonitinhos para cada checkbox
						    if (chkMaiuscula.isSelected()) {
						        caracteres.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
						    }
						    if (chkMinuscula.isSelected()) {
						        caracteres.append("abcdefghijklmnopqrstuvwxyz");
						    }
						    if (chkNumero.isSelected()) {
						        caracteres.append("0123456789");
						    }
						    if (chkSimbolo.isSelected()) {
						        caracteres.append("!@#$%^&*()-_=+[{]};:'\",<.>/?");
						    }
						
						    if (caracteres.length() == 0) {
					            JOptionPane.showMessageDialog(null, "Selecione pelo menos uma opção.", "Erro", JOptionPane.ERROR_MESSAGE);
					        } else {
					            // Obtém o comprimento da senha pegando o número que vai estar no spinner
					            int comprimento = (int) spnComprimento.getValue();
					            char[] senha = new char[comprimento];

					            // Gera a senha aleatória
					            for (int i = 0; i < comprimento; i++) {
					                int index = random.nextInt(caracteres.length());
					                senha[i] = caracteres.charAt(index);
					                
					            }
					         // Exibe a senha gerada num pop-up
								JOptionPane.showMessageDialog(null, "Senha gerada: \n" + String.valueOf(senha), "Gerador de senha", JOptionPane.INFORMATION_MESSAGE);
					        }
						   
							
						};
					});
					btnGerarSenha.setBounds(155, 100, 120, 25);
					painel2C.add(btnGerarSenha);
						
				return painel2C;
				};

				private static class RoundedBorder implements Border {
				    private int radius;
				    RoundedBorder(int radius) {
				        this.radius = radius;
				    }
				    public Insets getBorderInsets(Component c) {
				        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
				    }
				    public boolean isBorderOpaque() {
				        return true;
				    }
				    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
				        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
				    }
				};
}