package page.rank.algorithm;

import Jama.Matrix;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static page.rank.algorithm.Assert.*;

public class StochasticMatrixTest {

	private StochasticMatrix stochasticMatrix;

	@Before
	public void setUp() {
		double[][] values = {{0.0, 0.5, 0.5}, {1.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};

		Matrix matrix = new Matrix(values);

		stochasticMatrix = new StochasticMatrix(matrix);
	}

	@Test
	public void testFirstIteration() {
		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(0.5);
		expected.add(0.5);

		stochasticMatrix.computeNextIteration();

		assertEqualsCollections(expected, stochasticMatrix.getRanks());
	}

	@Test
	public void testSecondIteration() {
		List<Double> expected = new ArrayList<Double>();
		expected.add(0.66666666);
		expected.add(0.16666666);
		expected.add(0.16666666);

		stochasticMatrix.computeNextIteration();
		stochasticMatrix.computeNextIteration();

		assertEqualsCollections(expected, stochasticMatrix.getRanks());
	}

	@Test
	public void testHundredIterations() {
		List<Double> expected = new ArrayList<Double>();
		expected.add(0.4);
		expected.add(0.3);
		expected.add(0.3);

		for (int i = 0; i < 100; i++) {
			stochasticMatrix.computeNextIteration();
		}

		assertEqualsCollections(expected, stochasticMatrix.getRanks());
	}
}
