package AlgKruskal;

public class Vetor {
	public static Aresta vetorInicial[] = new Aresta[58 * 57 / 2];
	public static Aresta vetorAnterior[] = new Aresta[57];
	public static Aresta vetorAtual[] = new Aresta[57];

	public static Aresta[] getVetorAtual() {
		return vetorAtual;
	}

	public static Aresta[] getVetorAnterior() {
		return vetorAnterior;
	}
		
	public static void setVetorAnterior(Aresta v[]) {
		for (int i = 0; i < v.length; i++) {
			vetorAnterior[i] = v[i];
		}
	}

	public static void setVetorAtual(Aresta v[]) {
		for (int i = 0; i < v.length; i++) {
			vetorAtual[i] = v[i];
		}
	}

	public static Aresta[] getVetorIni() {
		return vetorInicial;
	}

	public static void setVetorIni(Aresta v[]) {
		vetorInicial = v;
	}

}
