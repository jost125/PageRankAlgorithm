package page.rank.algorithm;

import Jama.Matrix;
import java.util.Collection;
import java.util.Iterator;
import static org.junit.Assert.*;

public class Assert {
	
	static public void assertEqualsCollections(Collection<Double> expected, Collection<Double> actual) {
		assertEquals(expected.size(), actual.size());

		Iterator<Double> expectedIterator = expected.iterator();
		Iterator<Double> actualIterator = actual.iterator();

		while (expectedIterator.hasNext()) {
			assertEquals(expectedIterator.next(), actualIterator.next(), 0.0001);
		}
	}

	public static void assertEqualsMatrix(Matrix expected, Matrix actual) {
		double[][] expectedValues = expected.getArray();
		double[][] actualValues = actual.getArray();
		for (int x = 0; x < expectedValues.length; x++) {
			for (int y = 0; y < expectedValues[x].length; y++) {
				assertEquals(expectedValues[x][y], actualValues[x][y], 0.0001);
			}
		}
	}
}
