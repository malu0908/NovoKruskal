package AlgKruskal;

import java.io.IOException;
import java.util.Arrays;
import java.util.Observable;

public class Kruskal extends Observable implements Runnable {
	public static Aresta resultado[] = new Aresta[57];
	public static Aresta[] arestas = new Aresta[(58 * 57) / 2];
	UnionFind conjuntos = new UnionFind();
	boolean setaGrafo;
	public static Kruskal geraAgm = new Kruskal();

	private Kruskal() {
		// gera os conjuntos iniciais composto por conjuntos unitarios
		conjuntos.criaEstrutura();

		// cria uma vetor com as arestas em ordem crescente, considerando apenas a
		// matriz triangular superior
		int w = 0;
		for (int i = 0; i < 58; i++) {
			for (int j = i + 1; j < 58; j++) {
				if (i != j) {
					arestas[w] = new Aresta(i, j, Matrizes.getMatrizAdj()[i][j]);
					w++;
				}
			}
		}
	
		Vetor.setVetorIni(arestas);
		Arrays.sort(arestas);

	}

	public static Aresta[] getArestas() {
		return arestas;
	}

	public static Kruskal getAgm() {
		return geraAgm;
	}

	public void notifica() {
		setChanged();
		notifyObservers();
	}

	public void AlgKruskal() {
		int w = 0;
		conjuntos.criaEstrutura();
		for (int i = 0; i < arestas.length; i++) {
			if (!(conjuntos.teste(arestas[i].vertice1, arestas[i].vertice2)) && arestas[i].naoEhAcessivel == false) {
				conjuntos.juntar(arestas[i].vertice1, arestas[i].vertice2);
				resultado[w] = arestas[i];
				w++;
			}
		}
	}

	public void executa() throws IOException {
		AlgKruskal();
		Vetor.setVetorAtual(resultado);
		DesenhaTela.getTela().getDesenhaGrafoAtual().aresta = Vetor.getVetorAtual();
	}

	@Override
	public void run() {
		Vetor.setVetorAnterior(Vetor.getVetorAtual());
		DesenhaTela.getTela().getDesenhaGrafoAnterior().aresta = Vetor.getVetorAnterior();
		
		// TODO Auto-generated method stub
		try {
			Matrizes.executaOperacoes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
