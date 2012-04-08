package page.rank.algorithm;

import Jama.Matrix;

public class MatrixPrinter {
	public void print(Matrix matrix) {
		double[][] values = matrix.getArray();
		for (int x = 0; x < values.length; x++) {
			for (int y = 0; y < values[x].length; y++) {
				System.out.print(" " + values[x][y]);
			}
			System.out.println("");
		}
	}
}
