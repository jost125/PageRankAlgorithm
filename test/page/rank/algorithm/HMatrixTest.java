package page.rank.algorithm;

import java.util.List;
import Jama.Matrix;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static page.rank.algorithm.Assert.*;

public class HMatrixTest {

	HMatrix hMatrix;

	@Before
	public void setUp() {
		double[][] values = {{0.0, 1.0}, {1.0, 0.0}};

		Matrix matrix = new Matrix(values);

		hMatrix = new HMatrix(matrix);
	}

	@Test
	public void testGetInitialRankIteration() {
		List<Double> expected = new ArrayList<Double>();
		expected.add(1.0);
		expected.add(0.0);

		assertEqualsCollections(expected, hMatrix.getRanks());
	}

	@Test
	public void testFirstIteration() {
		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(1.0);

		hMatrix.computeNextIteration();

		assertEqualsCollections(expected, hMatrix.getRanks());
	}

	@Test
	public void testSecondIteration() {
		List<Double> expected = new ArrayList<Double>();
		expected.add(1.0);
		expected.add(0.0);

		hMatrix.computeNextIteration();
		hMatrix.computeNextIteration();

		assertEqualsCollections(expected, hMatrix.getRanks());
	}
}
