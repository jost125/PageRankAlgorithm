package page.rank.algorithm;

import java.util.List;
import Jama.Matrix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HMatrixTest {

	HMatrix hMatrix;

	@Before
	public void setUp() {
		double[][] values = {{0.0, 1.0}, {1.0, 0.0}};
		double[][] piValues = {{1.0, 0.0}};

		Matrix matrix = new Matrix(values);
		Matrix piVector = new Matrix(piValues);

		hMatrix = new HMatrix(matrix, piVector);
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

	private void assertEqualsCollections(Collection<Double> expected, Collection<Double> actual) {
		assertEquals(expected.size(), actual.size());

		Iterator<Double> expectedIterator = expected.iterator();
		Iterator<Double> actualIterator = actual.iterator();

		while (expectedIterator.hasNext()) {
			assertEquals(expectedIterator.next(), actualIterator.next(), 0.0001);
		}
	}
}
