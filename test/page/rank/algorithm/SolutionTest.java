package page.rank.algorithm;

import Jama.Matrix;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static page.rank.algorithm.Assert.*;

public class SolutionTest {
	private File firstTestFile;
	private File secondTestFile;
	private File thirdTestFile;

	private MatrixFactory matrixFactory;

	@Before
	public void setUp() {
		firstTestFile = getFile("test1.txt");
		secondTestFile = getFile("test2.txt");
		thirdTestFile = getFile("test3.txt");

		matrixFactory = new MatrixFactory(new PageFactory());
	}

	private File getFile(String path) {
		return new File(getClass().getResource(path).getFile());
	}

	@Test
	public void hMatrixFirstTestAfterZeroIteration() {
		HMatrix hMatrix = loadFirstHMatrix();

		List<Double> ranks = hMatrix.getRanks();
		
		List<Double> expected = new ArrayList<Double>();
		expected.add(1.0);
		expected.add(0.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void hMatrixFirstTestAfterOneIteration() {
		HMatrix hMatrix = loadFirstHMatrix();
		hMatrix.computeNextIteration();

		List<Double> ranks = hMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(1.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void hMatrixFirstTestAfterSecondIteration() {
		HMatrix hMatrix = loadFirstHMatrix();
		hMatrix.computeNextIteration();
		hMatrix.computeNextIteration();

		List<Double> ranks = hMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(1.0);
		expected.add(0.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void hMatrixSecondTestAfterZeroIteration() {
		HMatrix hMatrix = loadSecondHMatrix();

		List<Double> ranks = hMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(1.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void hMatrixSecondTestAfterFirstIteration() {
		HMatrix hMatrix = loadSecondHMatrix();
		hMatrix.computeNextIteration();

		List<Double> ranks = hMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(0.333333333333);
		expected.add(0.333333333333);
		expected.add(0.333333333333);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void hMatrixSecondTestAfterSecondIteration() {
		HMatrix hMatrix = loadSecondHMatrix();
		hMatrix.computeNextIteration();
		hMatrix.computeNextIteration();

		List<Double> ranks = hMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.6666666666666);
		expected.add(0.3333333333333);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void stochasticMatrixFirstTestAfterZeroIteration() {
		StochasticMatrix stochasticMatrix = loadFirstStochasticMatrix();

		List<Double> ranks = stochasticMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(1.0);
		expected.add(0.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void stochasticMatrixFirstTestAfterFirstIteration() {
		StochasticMatrix stochasticMatrix = loadFirstStochasticMatrix();
		stochasticMatrix.computeNextIteration();

		List<Double> ranks = stochasticMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(1.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void stochasticMatrixFirstTestAfterSecondIteration() {
		StochasticMatrix stochasticMatrix = loadFirstStochasticMatrix();
		stochasticMatrix.computeNextIteration();
		stochasticMatrix.computeNextIteration();

		List<Double> ranks = stochasticMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(1.0);
		expected.add(0.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void stochasticMatrixSecondTestAfterZeroIteration() {
		StochasticMatrix stochasticMatrix = loadSecondStochasticMatrix();

		List<Double> ranks = stochasticMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(1.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void stochasticMatrixSecondTestAfterFirstIteration() {
		StochasticMatrix stochasticMatrix = loadSecondStochasticMatrix();
		stochasticMatrix.computeNextIteration();

		List<Double> ranks = stochasticMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(0.333333333333);
		expected.add(0.333333333333);
		expected.add(0.333333333333);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void stochasticMatrixSecondTestAfterSecondIteration() {
		StochasticMatrix stochasticMatrix = loadSecondStochasticMatrix();
		stochasticMatrix.computeNextIteration();
		stochasticMatrix.computeNextIteration();

		List<Double> ranks = stochasticMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.666666666666);
		expected.add(0.333333333333);

		assertEqualsCollections(expected, ranks);
	}

	private HMatrix loadFirstHMatrix() {
		Matrix matrix = loadMatrix(firstTestFile);
		return new HMatrix(matrix);
	}

	private HMatrix loadSecondHMatrix() {
		Matrix matrix = loadMatrix(secondTestFile);
		return new HMatrix(matrix);
	}

	private StochasticMatrix loadFirstStochasticMatrix() {
		Matrix matrix = loadMatrix(firstTestFile);
		return new StochasticMatrix(matrix);
	}

	private StochasticMatrix loadSecondStochasticMatrix() {
		Matrix matrix = loadMatrix(secondTestFile);

		return new StochasticMatrix(matrix);
	}

	private Matrix loadMatrix(File file) {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException ex) {
			fail(ex.getMessage());
		}

		Matrix matrix = matrixFactory.createMatrixFromReader(bufferedReader);
		
		try {
			bufferedReader.close();
		} catch (IOException ex) {
			fail(ex.getMessage());
		}

		return matrix;
	}
}
