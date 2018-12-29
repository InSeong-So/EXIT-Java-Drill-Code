package junitTestCode;

import java.util.LinkedList;
import java.util.List;

public class Sort {

	public void bubbleSort(int[] numbers) {
		boolean numbersSwitched;
		do {
			numbersSwitched = false;
			for (int i = 0; i < numbers.length - 1; i++) {
				if (numbers[i + 1] < numbers[i]) {
					int tmp = numbers[i + 1];
					numbers[i + 1] = numbers[i];
					numbers[i] = tmp;
					numbersSwitched = true;
				}
			}
		} while (numbersSwitched);
	}

	public List<Integer> insertSort(List<Integer> numbers) {
		List<Integer> sortedList = new LinkedList<>();
		originalList : for (Integer number : numbers) {
			for (int i = 0; i < sortedList.size(); i++) {
				if (number < sortedList.get(i)) {
					sortedList.add(i, number);
					continue originalList;
				}
			}
			sortedList.add(sortedList.size(), number);
		}

		return sortedList;
	}
}
