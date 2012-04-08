package page.rank.algorithm;

import Jama.Matrix;

public class HMatrix extends PageRankMatrix {
	public HMatrix(Matrix matrix, Matrix piVector) {
		super(matrix, piVector);
	}

	@Override
	public void computeNextIteration() {
		setPiVector(getPiVector().times(getMatrix()));
	}
}
