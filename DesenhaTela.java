package AlgKruskal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.*;

public class DesenhaTela extends JFrame {

	private static final long serialVersionUID = 1L;
	int tamanho = 58;
	private DesenhaGrafo grafoAnterior = new DesenhaGrafo(Vetor.getVetorIni());
	private DesenhaGrafo grafoAtual = new DesenhaGrafo(Vetor.getVetorIni());
	private JPanel AreaBotoes = new JPanel();
	public static DesenhaTela tela = new DesenhaTela();

	private DesenhaTela() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Árvore Geradora Mínima");

		JButton button = new JButton("Play >>>");
		this.AreaBotoes.setSize(450, 100);
		this.AreaBotoes.setLayout(new BorderLayout());

		this.AreaBotoes.setBackground(Color.GRAY);
		this.AreaBotoes.add(button, BorderLayout.SOUTH);
		AreaBotoes.setBounds(400, 510, 200, 200);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Runnable trab = Kruskal.getAgm();
				Thread t = new Thread(trab);

				t.start();
			}
		});
		
		AreaBotoes.setBorder(BorderFactory.createTitledBorder("Operações"));
		
		getContentPane().add(grafoAnterior);
		getContentPane().add(grafoAtual);
		getContentPane().add(AreaBotoes);

		this.setLayout(new GridLayout(1, 3));

		this.setVisible(true);
	}

	public static DesenhaTela getTela() {
		return tela;
	}

	public DesenhaGrafo getDesenhaGrafoAnterior() {
		return this.grafoAnterior;
	}
	
	public JPanel getAreaBotoes() {
		return this.grafoAnterior;
	}

	public DesenhaGrafo getDesenhaGrafoAtual() {
		return this.grafoAtual;
	}
}
