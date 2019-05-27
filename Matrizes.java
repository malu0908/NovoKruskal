package AlgKruskal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Matrizes {
	public static Matrizes matrizes;
	private static double matrizAdj[][];
	private static double matriz[][];

	public static double[][] getMatrizAdj() {
		return matrizAdj;
	}

	public static double[][] getMatriz() {
		return matriz;
	}

	public static void inicializa() throws IOException {
		if (matrizes == null) {
			LeArq();
			matrizes = new Matrizes();
		}
	}

	public static Matrizes getMatrizes() throws IOException {
		return matrizes;
	}

	public static void LeArq() throws IOException {

		FileReader arq = new FileReader("C:\\Users\\maluf\\Desktop\\Bagunça\\Kruskal\\src\\new.txt");

		BufferedReader lerArq = new BufferedReader(arq);

		String tamanho = lerArq.readLine();
		int tam = Integer.parseInt(tamanho);
		matrizAdj = new double[tam][tam];
		matriz = new double[tam][2];

		// lendo as coordenadas
		String linha = lerArq.readLine();
		String[] x = null;
		int i = 0;
		while (linha != null) {
			x = linha.split(",");
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = Double.parseDouble(x[j]);
			}
			linha = lerArq.readLine();
			i++;
		}

		// calcula as distancias para montar a matriz de adjcencia
		for (i = 0; i < matrizAdj.length; i++) {
			for (int j = 0; j < matrizAdj[0].length; j++) {
				double distanciaX = matriz[j][0] - matriz[i][0];
				double distanciaY = matriz[j][1] - matriz[i][1];

				double distancia = Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
				matrizAdj[i][j] = distancia;
				matrizAdj[j][i] = distancia;
			}
		}

		lerArq.close();
	}

	public static void buscaAresta(int vertice1, int vertice2, int operacao) {
		for (int i = 0; i < Kruskal.arestas.length; i++) {
			if (vertice1 == Kruskal.arestas[i].vertice1 && vertice2 == Kruskal.arestas[i].vertice2 && operacao == 0)
				Kruskal.arestas[i].naoEhAcessivel = true;
			else if (vertice1 == Kruskal.arestas[i].vertice1 && vertice2 == Kruskal.arestas[i].vertice2
					&& operacao == 1)
				Kruskal.arestas[i].naoEhAcessivel = false;
		}
	}

	public static void executaOperacoes() throws IOException {
		FileReader arq = new FileReader("C:\\Users\\maluf\\Desktop\\Bagunça\\Kruskal\\src\\operacoes.txt");

		BufferedReader lerArq = new BufferedReader(arq);

		// lendo as coordenadas
		String linha = lerArq.readLine();
		String[] x = null;
		int w = 0;
		while (linha != null) {
			x = linha.split(";");
			if (x[0].compareTo("rm") == 0) {
				buscaAresta(Integer.parseInt(x[1]), Integer.parseInt(x[2]), 0);

				DesenhaTela.getTela().getDesenhaGrafoAnterior().vertice1Add = -1;
				DesenhaTela.getTela().getDesenhaGrafoAnterior().vertice2Add = -1;
					
				DesenhaTela.getTela().getDesenhaGrafoAnterior().vertice1Rem = Integer.parseInt(x[1]);
				DesenhaTela.getTela().getDesenhaGrafoAnterior().vertice2Rem = Integer.parseInt(x[2]);
				
				DesenhaTela.getTela().getAreaBotoes().setLayout(new java.awt.GridBagLayout());
				JLabel texto = new JLabel("rm " + "(" + x[1] + "," + x[2] + ")");
				DesenhaTela.getTela().getAreaBotoes().add(texto);
				
				DesenhaTela.getTela().getAreaBotoes().add(texto);
				
			} else if (x[0].compareTo("add") == 0) {

				buscaAresta(Integer.parseInt(x[1]), Integer.parseInt(x[2]), 1);

				DesenhaTela.getTela().getDesenhaGrafoAnterior().vertice1Rem = -1;
				DesenhaTela.getTela().getDesenhaGrafoAnterior().vertice2Rem = -1;
				
				DesenhaTela.getTela().getDesenhaGrafoAnterior().vertice1Add = Integer.parseInt(x[1]);
				DesenhaTela.getTela().getDesenhaGrafoAnterior().vertice2Add = Integer.parseInt(x[2]);
					
					
			}
			Kruskal.getAgm().AlgKruskal();

			Vetor.setVetorAtual(Kruskal.resultado);
			DesenhaTela.getTela().getDesenhaGrafoAtual().aresta = Kruskal.resultado;

			Kruskal.getAgm().notifica();

			try {
				Thread.sleep(50);
			} catch (InterruptedException ex) {
			}

			linha = lerArq.readLine();

		}
		lerArq.close();
	}
}
