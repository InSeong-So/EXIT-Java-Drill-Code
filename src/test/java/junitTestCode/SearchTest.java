package junitTestCode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SearchTest {

	@Test
	public void binarySearchTest() {
		Search search = new Search();

		assertEquals(true, search.binarySearch(SortTest.sortingList, 3));

	}
}
