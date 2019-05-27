package AlgKruskal;

public class Node {
	int valor;
	Node pai;

	public Node(int valor) {
		this.valor = valor;
		this.pai = this;
	}
}