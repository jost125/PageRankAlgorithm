package page.rank.algorithm;

import Jama.Matrix;
import java.io.BufferedReader;
import java.io.StringReader;
import org.junit.Before;
import org.junit.Test;
import static page.rank.algorithm.Assert.*;

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
		
		double[][] values = {{0.0, 1.0}, {1.0, 0.0}};
		assertEqualsMatrix(new Matrix(values), matrix);
	}
}
