package AlgKruskal;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class DesenhaGrafo extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	public Aresta[] aresta = new Aresta[58 * 57 / 2];
	int escala = 4;
	int tamBol = 10;
	int soma;
	int vertice1Rem = -1;
	int vertice2Rem = -1;
	int vertice1Add = -1;
	int vertice2Add = -1;

	public DesenhaGrafo(Aresta[] aresta) {
		for (int i = 0; i < this.aresta.length; i++) {
			this.aresta[i] = aresta[i];
		}
		setSize(430, 450);
	}

	public void clean() {
		for (int i = 0; i < aresta.length; i++) {
			this.aresta[i] = null;
		}
	}

	public void paintComponent(Graphics grafo) {
		super.paintComponent(grafo);
		this.setBackground(Color.black);
		printaGrafo(grafo);
	}

	public void printaGrafo(Graphics grafo) {

		for (int i = 0; i < 430; i += 35) {
			grafo.setColor(Color.CYAN);
			grafo.drawLine(i, 0, i, 420);
		}

		for (int i = 0; i < 450; i += 35) {
			grafo.setColor(Color.CYAN);
			grafo.drawLine(0, i, 420, i);
		}

		if(vertice1Rem >= 0 && vertice2Rem >= 0)
			desenhaLinhaTracejada(grafo, vertice1Rem, vertice2Rem, 0);

		if(vertice1Add >= 0 && vertice2Add >= 0) 
			desenhaLinhaTracejada(grafo, vertice1Add, vertice2Add, 1);

		for (int i = 0; i < aresta.length; i++) {
			grafo.setColor(Color.white);
			if (aresta[i].vertice1 != vertice1Rem || aresta[i].vertice2 != vertice2Rem)
				grafo.drawLine((int) (Matrizes.getMatriz()[aresta[i].vertice1][0] * escala),
						(int) (Matrizes.getMatriz()[aresta[i].vertice1][1] * escala),
						(int) (Matrizes.getMatriz()[aresta[i].vertice2][0] * escala),
						(int) (Matrizes.getMatriz()[aresta[i].vertice2][1] * escala));
			
			grafo.setColor(Color.red);
			grafo.fillOval((int) (Matrizes.getMatriz()[aresta[i].vertice1][0] * escala - tamBol / 2),
					(int) (Matrizes.getMatriz()[aresta[i].vertice1][1] * escala - tamBol / 2), tamBol, tamBol);
			grafo.setColor(Color.white);

			grafo.setColor(Color.red);
			grafo.fillOval((int) (Matrizes.getMatriz()[aresta[i].vertice2][0] * escala - tamBol / 2),
					(int) (Matrizes.getMatriz()[aresta[i].vertice2][1] * escala - tamBol / 2), tamBol, tamBol);
		}
	}

	public void desenhaLinhaTracejada(Graphics grafo, int vertice1, int vertice2, int operacao) {
		Graphics2D g2d = (Graphics2D) grafo.create();
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 5 },
				(float) 0.5);
		g2d.setStroke(dashed);
		if(operacao == 0)
			g2d.setColor(Color.ORANGE);
		else if(operacao == 1)
			g2d.setColor(Color.MAGENTA);
		g2d.drawLine((int) (Matrizes.getMatriz()[vertice1][0] * escala),
				(int) (Matrizes.getMatriz()[vertice1][1] * escala), (int) (Matrizes.getMatriz()[vertice2][0] * escala),
				(int) (Matrizes.getMatriz()[vertice2][1] * escala));
		g2d.dispose();

	}

	public void update(Observable o, Object arg) {
		this.repaint();
	}

}