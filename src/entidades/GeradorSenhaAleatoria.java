package entidades;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeradorSenhaAleatoria extends JFrame {
    private JCheckBox chkMaiusculas;
    private JCheckBox chkMinusculas;
    private JCheckBox chkNumeros;
    private JCheckBox chkSimbolos;
    private JButton btnGerarSenha;
    private JTextField txtSenha;
    private JTextField txtComprimento;

    public GeradorSenhaAleatoria() {
        // Configurações da janela
        setTitle("Gerador de Senha Aleatória");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 250);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        // Componentes
        chkMaiusculas = new JCheckBox("Letras Maiúsculas");
        chkMinusculas = new JCheckBox("Letras Minúsculas");
        chkNumeros = new JCheckBox("Números");
        chkSimbolos = new JCheckBox("Símbolos");
        btnGerarSenha = new JButton("Gerar Senha");
        txtSenha = new JTextField();
        txtSenha.setEditable(false);
        txtComprimento = new JTextField();
        txtComprimento.setHorizontalAlignment(JTextField.CENTER);

        // Adiciona componentes ao painel
        panel.add(chkMaiusculas);
        panel.add(chkMinusculas);
        panel.add(chkNumeros);
        panel.add(chkSimbolos);
        panel.add(new JLabel("Comprimento da Senha:"));
        panel.add(txtComprimento);
        panel.add(btnGerarSenha);
        panel.add(txtSenha);

        // Evento do botão
        btnGerarSenha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gerarSenha();
            }
        });

        // Adiciona o painel à janela
        add(panel);

        // Exibe a janela
        setVisible(true);
    }

    private void gerarSenha() {
        StringBuilder caracteres = new StringBuilder();
        Random random = new Random();

        // Verifica quais elementos foram selecionados
        if (chkMaiusculas.isSelected()) {
            caracteres.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (chkMinusculas.isSelected()) {
            caracteres.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (chkNumeros.isSelected()) {
            caracteres.append("0123456789");
        }
        if (chkSimbolos.isSelected()) {
            caracteres.append("!@#$%^&*()-_=+[{]};:'\",<.>/?");
        }

        // Obtém o comprimento da senha
        int comprimento = Integer.parseInt(txtComprimento.getText());

        // Gera a senha aleatória
        char[] senha = new char[comprimento];
        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(caracteres.length());
            senha[i] = caracteres.charAt(index);
        }

        // Exibe a senha gerada
        txtSenha.setText(String.valueOf(senha));
    }

    public static void main(String[] args) {
        new GeradorSenhaAleatoria();
    }
}
