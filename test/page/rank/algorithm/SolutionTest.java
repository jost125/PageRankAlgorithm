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
	public void hMatrixFirstTestAfterFirstIteration() {
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
	public void hMatrixThirdTestAfterZeroIteration() {
		HMatrix hMatrix = loadThirdHMatrix();

		List<Double> ranks = hMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(1.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void hMatrixThirdTestAfterFirstIteration() {
		HMatrix hMatrix = loadThirdHMatrix();
		hMatrix.computeNextIteration();

		List<Double> ranks = hMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(0.5);
		expected.add(0.5);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void hMatrixThirdTestAfterSecondIteration() {
		HMatrix hMatrix = loadThirdHMatrix();
		hMatrix.computeNextIteration();
		hMatrix.computeNextIteration();

		List<Double> ranks = hMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.25);
		expected.add(0.25);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void hMatrixThirdTestAfterThirdIteration() {
		HMatrix hMatrix = loadThirdHMatrix();
		hMatrix.computeNextIteration();
		hMatrix.computeNextIteration();
		hMatrix.computeNextIteration();

		List<Double> ranks = hMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.375);
		expected.add(0.0);
		expected.add(0.125);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void hMatrixThirdTestAfterHunderthIteration() {
		HMatrix hMatrix = loadThirdHMatrix();
		for (int i = 0; i < 100; i++) {
			hMatrix.computeNextIteration();
		}

		List<Double> ranks = hMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);

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

	@Test
	public void stochasticMatrixThirdTestAfterZeroIteration() {
		StochasticMatrix stochasticMatrix = loadThirdStochasticMatrix();

		List<Double> ranks = stochasticMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(1.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void stochasticMatrixThirdTestAfterFirstIteration() {
		StochasticMatrix stochasticMatrix = loadThirdStochasticMatrix();
		stochasticMatrix.computeNextIteration();

		List<Double> ranks = stochasticMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.0);
		expected.add(0.5);
		expected.add(0.5);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void stochasticMatrixThirdTestAfterSecondIteration() {
		StochasticMatrix stochasticMatrix = loadThirdStochasticMatrix();
		stochasticMatrix.computeNextIteration();
		stochasticMatrix.computeNextIteration();

		List<Double> ranks = stochasticMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.08333333333);
		expected.add(0.08333333333);
		expected.add(0.08333333333);
		expected.add(0.08333333333);
		expected.add(0.33333333333);
		expected.add(0.33333333333);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void stochasticMatrixThirdTestAfterThirdIteration() {
		StochasticMatrix stochasticMatrix = loadThirdStochasticMatrix();
		stochasticMatrix.computeNextIteration();
		stochasticMatrix.computeNextIteration();
		stochasticMatrix.computeNextIteration();

		List<Double> ranks = stochasticMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.04166666666);
		expected.add(0.08333333333);
		expected.add(0.05555555555);
		expected.add(0.51388888888);
		expected.add(0.08333333333);
		expected.add(0.22222222222);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void stochasticMatrixThirdTestAfterHunderthIteration() {
		StochasticMatrix stochasticMatrix = loadThirdStochasticMatrix();
		for (int i = 0; i < 100; i++) {
			stochasticMatrix.computeNextIteration();
		}

		List<Double> ranks = stochasticMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.12213740458);
		expected.add(0.18320610687);
		expected.add(0.09160305343);
		expected.add(0.27480916030);
		expected.add(0.16793893129);
		expected.add(0.16030534351);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void googleMatrixFirstTestAfterZeroIteration() {
		GoogleMatrix googleMatrix = loadFirstGoogleMatrix();

		List<Double> ranks = googleMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(1.0);
		expected.add(0.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void googleMatrixFirstTestAfterFirstIteration() {
		GoogleMatrix googleMatrix = loadFirstGoogleMatrix();
		googleMatrix.computeNextIteration();

		List<Double> ranks = googleMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.05);
		expected.add(0.95);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void googleMatrixFirstTestAfterSecondIteration() {
		GoogleMatrix googleMatrix = loadFirstGoogleMatrix();
		googleMatrix.computeNextIteration();
		googleMatrix.computeNextIteration();

		List<Double> ranks = googleMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.905);
		expected.add(0.095);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void googleMatrixFirstTestAfterThirdIteration() {
		GoogleMatrix googleMatrix = loadFirstGoogleMatrix();
		googleMatrix.computeNextIteration();
		googleMatrix.computeNextIteration();
		googleMatrix.computeNextIteration();

		List<Double> ranks = googleMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.1355);
		expected.add(0.8645);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void googleMatrixFirstTestAfterHundredthIteration() {
		GoogleMatrix googleMatrix = loadFirstGoogleMatrix();
		for (int i = 0; i < 100; i++) {
			googleMatrix.computeNextIteration();
		}

		List<Double> ranks = googleMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.5);
		expected.add(0.5);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void googleMatrixSecondTestAfterZeroIteration() {
		GoogleMatrix googleMatrix = loadSecondGoogleMatrix();

		List<Double> ranks = googleMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(1.0);
		expected.add(0.0);
		expected.add(0.0);
		expected.add(0.0);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void googleMatrixSecondTestAfterFirstIteration() {
		GoogleMatrix googleMatrix = loadSecondGoogleMatrix();

		googleMatrix.computeNextIteration();

		List<Double> ranks = googleMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.025);
		expected.add(0.325);
		expected.add(0.325);
		expected.add(0.325);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void googleMatrixSecondTestAfterSecondIteration() {
		GoogleMatrix googleMatrix = loadSecondGoogleMatrix();

		googleMatrix.computeNextIteration();
		googleMatrix.computeNextIteration();

		List<Double> ranks = googleMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.025);
		expected.add(0.0325);
		expected.add(0.6175);
		expected.add(0.325);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void googleMatrixSecondTestAfterThirdIteration() {
		GoogleMatrix googleMatrix = loadSecondGoogleMatrix();

		googleMatrix.computeNextIteration();
		googleMatrix.computeNextIteration();
		googleMatrix.computeNextIteration();

		List<Double> ranks = googleMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.025);
		expected.add(0.0325);
		expected.add(0.35425);
		expected.add(0.58825);

		assertEqualsCollections(expected, ranks);
	}

	@Test
	public void googleMatrixSecondTestAfterThousandthIteration() {
		GoogleMatrix googleMatrix = loadSecondGoogleMatrix();

		for (int i = 0; i < 1000; i++) {
			googleMatrix.computeNextIteration();
		}

		List<Double> ranks = googleMatrix.getRanks();

		List<Double> expected = new ArrayList<Double>();
		expected.add(0.025);
		expected.add(0.0325);
		expected.add(0.47894736842);
		expected.add(0.46355263157);

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

	private HMatrix loadThirdHMatrix() {
		Matrix matrix = loadMatrix(thirdTestFile);
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

	private StochasticMatrix loadThirdStochasticMatrix() {
		Matrix matrix = loadMatrix(thirdTestFile);
		return new StochasticMatrix(matrix);
	}

	private GoogleMatrix loadFirstGoogleMatrix() {
		Matrix matrix = loadMatrix(firstTestFile);
		return new GoogleMatrix(matrix);
	}

	private GoogleMatrix loadSecondGoogleMatrix() {
		Matrix matrix = loadMatrix(secondTestFile);
		return new GoogleMatrix(matrix);
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
