package page.rank.algorithm;

import Jama.Matrix;
import java.util.ArrayList;
import java.util.List;

abstract public class PageRankMatrix {

	private Matrix piVector;
	private Matrix matrix;

	public PageRankMatrix(Matrix matrix) {
		if (matrix.getColumnDimension() != matrix.getRowDimension()) {
			throw new IllegalArgumentException("Matrix should have row dimension same as column dimension");
		}

		this.matrix = matrix;
		createPiVector();
	}

	private void createPiVector() {
		int length = matrix.getRowDimension();

		double[][] values = new double[1][length];
		values[0][0] = 1.0;

		for (int i = 1; i < length; i++) {
			values[0][i] = 0.0;
		}

		this.piVector = new Matrix(values);
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
