package page.rank.algorithm;

import Jama.Matrix;
import java.util.ArrayList;
import java.util.List;

abstract public class PageRankMatrix {

	private Matrix piVector;
	private Matrix matrix;

	public PageRankMatrix(Matrix matrix, Matrix piVector) {
		this.matrix = matrix;
		this.piVector = piVector;
	}

	abstract public void computeNextIteration();

	public List<Double> getRanks() {
		List<Double> ranks = new ArrayList<Double>();

		double[][] values = piVector.getArray();
		for (int i = 0; i < values[0].length; i++) {
			ranks.add(values[0][i]);
		}

		return ranks;
	}

	protected void setPiVector(Matrix piVector) {
		this.piVector = piVector;
	}

	protected  void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

	protected Matrix getPiVector() {
		return piVector;
	}

	protected Matrix getMatrix() {
		return matrix;
	}
}
