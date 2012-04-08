package page.rank.algorithm;

import Jama.Matrix;

public class VectorFactory {
	public Matrix createEVector(Matrix matrix) {
		Integer length = matrix.getRowDimension();
		double[][] values = new double[length][1];

		for (int i = 0; i < length; i++) {
			values[i][0] = 1;
		}

		return new Matrix(values);
	}

	public Matrix createAVector(Matrix matrix) {
		Integer length = matrix.getRowDimension();
		double[][] values = new double[length][1];

		for (int i = 0; i < length; i++) {
			boolean haveOutlinks = false;

			for (int j = 0; j < length; j++) {
				if (matrix.get(i, j) > 0.00000001) {
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
