package page.rank.algorithm;

import Jama.Matrix;
import java.io.BufferedReader;
import java.io.StringReader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixFactoryTest {

	private MatrixFactory factory;

	public MatrixFactoryTest() {
	}

	@Before
	public void setUp() {
		factory = new MatrixFactory(new PageFactory());
	}

	@Test
	public void testCreateMatrixFromReader() {
		Matrix matrix = factory.createMatrixFromReader(new BufferedReader(new StringReader("2\n1:1\n0:1")));
		
		double[][] values = {{0.0, 0.5}, {0.5, 0.0}};
		assertEqualsMatrix(new Matrix(values), matrix);
	}

	private void assertEqualsMatrix(Matrix expected, Matrix actual) {
		double[][] expectedValues = expected.getArray();
		double[][] actualValues = actual.getArray();
		for (int x = 0; x < expectedValues.length; x++) {
			for (int y = 0; y < expectedValues[x].length; y++) {
				assertEquals(expectedValues[x][y], actualValues[x][y], 0.1);
			}
		}

		MatrixPrinter printer = new MatrixPrinter();
		printer.print(actual);
	}
}
