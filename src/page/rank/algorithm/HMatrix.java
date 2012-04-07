package page.rank.algorithm;

import Jama.Matrix;
import java.util.ArrayList;
import java.util.List;

public class HMatrix {

	private Matrix matrix;
	private Integer iteration;
	private Matrix piVector;

	public HMatrix(Matrix matrix, Matrix piVector) {
		this.matrix = matrix;
		this.piVector = piVector;
		this.iteration = 0;
	}

	public void computeNextIteration() {
		piVector = piVector.times(matrix);
	}

	public List<Double> getRanks() {
		List<Double> ranks = new ArrayList<Double>();

		double[][] values = piVector.getArray();
		for (int i = 0; i < values[0].length; i++) {
			ranks.add(values[0][i]);
		}

		return ranks;
	}
}
