package page.rank.algorithm;

import Jama.Matrix;

public class HMatrix extends PageRankMatrix {
	public HMatrix(Matrix matrix) {
		super(matrix);
	}

	@Override
	public void computeNextIteration() {
		setPiVector(getPiVector().times(getMatrix()));
	}
}
