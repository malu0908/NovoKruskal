package AlgKruskal;

import java.io.IOException;

public class Teste {
	public static void main(String[] args) throws IOException {
		Matrizes.inicializa();
		Kruskal.getAgm().addObserver(DesenhaTela.getTela().getDesenhaGrafoAnterior());
		Kruskal.getAgm().addObserver(DesenhaTela.getTela().getDesenhaGrafoAtual());
		Kruskal.getAgm().executa();
	}
}
