package page.rank.algorithm;

import Jama.Matrix;

public class MatrixPrinter {
	public void print(Matrix matrix) {
		double[][] values = matrix.getArray();
		for (double[] line : values) {
			for (double cell : line) {
				System.out.print(" " + cell);
			}
			System.out.println("");
		}
	}
}
