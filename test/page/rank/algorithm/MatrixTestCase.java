package page.rank.algorithm;

import java.util.Collection;
import java.util.Iterator;
import static org.junit.Assert.*;

public class MatrixTestCase {
	
	static public void assertEqualsCollections(Collection<Double> expected, Collection<Double> actual) {
		assertEquals(expected.size(), actual.size());

		Iterator<Double> expectedIterator = expected.iterator();
		Iterator<Double> actualIterator = actual.iterator();

		while (expectedIterator.hasNext()) {
			assertEquals(expectedIterator.next(), actualIterator.next(), 0.0001);
		}
	}
}
