package junitTestCode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortTest {
	int[] numbers = { 4, 7, 1, 6, 3, 5, 4 };
	int[] afterSorting = { 1, 3, 4, 4, 5, 6, 7 };
	List<Integer> numbersList = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
	List<Integer> sortingList = Arrays.asList(1, 3, 4, 4, 5, 6, 7);
	private Sort sort = new Sort();

//	@Test
	public void bubbleSortTest() {
		sort.bubbleSort(numbers);

		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

		assertArrayEquals(numbers, afterSorting);
	}

	@Test
	public void insertSortTest() {
		assertEquals(sort.insertSort(numbersList), sortingList);
	}
}
