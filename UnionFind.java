package AlgKruskal;

public class UnionFind {
	int tamanho = 58;
	Node conjunto[] = new Node[tamanho];
	
	public void criaEstrutura() {
	    //i eh uma variavel global iniciada com 0
	    //tamanho eh uma variavel global que define o tamanho do vetor
	    //conjunto eh um vetor em que cada elemento eh do tipo Node
	    //cada posicao do vetor conjunto eh um objeto do tipo Node, onde seu valor eh igual a i e seu pai eh ele mesmo
		for(int i = 0; i < tamanho; i++) {
			conjunto[i] = new Node(i);
		}
	}
	
	public Node encontraRaiz(int a) {	
		Node aux = conjunto[a];
		//se o aux tiver o mesmo valor que o seu pai
		//significa que ele eh a raiz da estrutura
		while(aux.valor != aux.pai.valor) {
			aux = aux.pai;
		}
		//retorna o aux que eh equivalente a raiz de a
		return aux;
	}
	
	public void juntar(int a, int b) {
	    //encontra a raiz de a
		Node RaizA = encontraRaiz(a);
		//encontra a raiz de b
		Node RaizB = encontraRaiz(b);
		//o pai de a recebe a raiz de b
		conjunto[a].pai = RaizB;
		//o pai da raiz de a recebe a raiz de b
		RaizA.pai = RaizB;
		//o pai de b recebe a raiz de b
		conjunto[b].pai = RaizB;
	}

	public boolean teste(int a, int b) {
		//verifica se a raiz de a eh igual a raiz de b, se verdade retorna true caso contrario retorna false
		return encontraRaiz(a) == encontraRaiz(b);
	}
	
}
