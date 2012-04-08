package page.rank.algorithm;

import Jama.Matrix;

public class StochasticMatrix extends PageRankMatrix {

	private VectorFactory vectorFactory;

	public StochasticMatrix(Matrix matrix) {
		super(matrix);
		vectorFactory = new VectorFactory();
	}

	@Override
	public void computeNextIteration() {
		Integer n = getMatrix().getRowDimension();
		Matrix eTDividedN = vectorFactory.createEVector(getMatrix()).times(1.0/(double)n).transpose();
		Matrix a = vectorFactory.createAVector(getMatrix());

		setPiVector(getPiVector().times(getMatrix().plus(a.times(eTDividedN))));
	}
}
