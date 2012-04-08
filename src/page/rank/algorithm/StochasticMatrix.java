package page.rank.algorithm;

import Jama.Matrix;

public class SMatrix extends PageRankMatrix {
	public SMatrix(Matrix matrix, Matrix piVector) {
		super(matrix, piVector);
	}

	@Override
	public void computeNextIteration() {
		Integer n = getMatrix().getRowDimension();
		Matrix eTDividedN = createEVector().times(1.0/(double)n).transpose();
		Matrix a = createAVector();

		setPiVector(getPiVector().times(getMatrix().plus(a.times(eTDividedN))));
	}

	private Matrix createEVector() {
		Integer length = getMatrix().getRowDimension();
		double[][] values = new double[length][1];

		for (int i = 0; i < length; i++) {
			values[i][0] = 1;
		}

		return new Matrix(values);
	}

	private Matrix createAVector() {
		Integer length = getMatrix().getRowDimension();
		double[][] values = new double[length][1];

		for (int i = 0; i < length; i++) {
			boolean haveOutlinks = false;

			for (int j = 0; j < length; j++) {
				if (getMatrix().get(i, j) > 0.00000001) {
					values[i][0] = 0;
					haveOutlinks = true;
					break;
				}
			}

			if (!haveOutlinks) {
				values[i][0] = 1;
			}
		}

		return new Matrix(values);
	}
}
