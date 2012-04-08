package page.rank.algorithm;

import Jama.Matrix;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static page.rank.algorithm.Assert.*;

public class GoogleMatrixTest {

	private GoogleMatrix googleMatrix;
	@Before
	public void setUp() {
		double[][] values = {{0.0, 1.0}, {1.0, 0.0}};

		Matrix matrix = new Matrix(values);

		googleMatrix = new GoogleMatrix(matrix);
	}

	@Test
	public void testFirstIteration() {
		List<Double> expected = new ArrayList<Double>();
		expected.add(0.05);
		expected.add(0.95);

		googleMatrix.computeNextIteration();

		assertEqualsCollections(expected, googleMatrix.getRanks());
	}

	@Test
	public void testSecondIteration() {
		List<Double> expected = new ArrayList<Double>();
		expected.add(0.905);
		expected.add(0.095);

		googleMatrix.computeNextIteration();
		googleMatrix.computeNextIteration();

		assertEqualsCollections(expected, googleMatrix.getRanks());
	}

	@Test
	public void testHunderthIteration() {
		List<Double> expected = new ArrayList<Double>();
		expected.add(0.5);
		expected.add(0.5);

		for (int i = 0; i < 100; i++) {
			googleMatrix.computeNextIteration();
		}

		assertEqualsCollections(expected, googleMatrix.getRanks());
	}
}
