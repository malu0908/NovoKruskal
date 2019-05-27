package AlgKruskal;

public class Aresta implements Comparable <Aresta> {
	double peso;
	int vertice1;
	int vertice2;
	boolean naoEhAcessivel;

	public Aresta(int vertice1, int vertice2, double peso) {
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
		this.peso = peso;
	}

	public int compareTo(Aresta aresta) {
		if (this.peso < aresta.peso) 
			return -1;
		else if (this.peso > aresta.peso) 
			return 1;
		return 0;
	}
}
