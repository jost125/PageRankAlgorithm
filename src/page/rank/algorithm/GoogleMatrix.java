package page.rank.algorithm;

import Jama.Matrix;

public class GoogleMatrix extends PageRankMatrix {

	private VectorFactory vectorFactory;

	public GoogleMatrix(Matrix matrix) {
		super(matrix);
		vectorFactory = new VectorFactory();
	}

	@Override
	public void computeNextIteration() {
		double alpha = 0.9;
		Matrix matrix = getMatrix();
		Matrix pi = getPiVector();
		Matrix a = vectorFactory.createAVector(matrix);
		Matrix e = vectorFactory.createEVector(matrix);
		Matrix eT = e.transpose();
		double n = (double)matrix.getRowDimension();

		setPiVector(
			pi
			.times(alpha)
			.times(matrix)
			.plus(
				pi
				.times(1/n)
				.times(
					a
					.times(alpha)
					.plus(
						e
						.times(1 - alpha)
					)
				)
				.times(eT)
			)
		);
	}

}
