package junitTestCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sort {

	// 버블 정렬 알고리즘
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

	
	// 삽입 정렬 알고리즘
	public List<Integer> insertSort(List<Integer> numbers) {
		List<Integer> sortedList = new LinkedList<>();
		originalList: for (Integer number : numbers) {
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

	// 퀵 정렬 알고리즘
	public List<Integer> quickSort(List<Integer> numbers) {
		if (numbers.size() < 2) {
			return numbers;
		}

		Integer pivot = numbers.get(0);
		List<Integer> lower = new ArrayList<>();
		List<Integer> higher = new ArrayList<>();

		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i) < pivot) {
				lower.add(numbers.get(i));
			} else {
				higher.add(numbers.get(i));
			}
		}

		List<Integer> sorted = quickSort(lower);
		sorted.add(pivot);
		sorted.addAll(quickSort(higher));

		return sorted;
	}

	
	// 병합 정렬 알고리즘
	public List<Integer> mergeSort(List<Integer> values) {
		if (values.size() < 2) {
			return values;
		}

		List<Integer> leftHalf = values.subList(0, values.size() / 2);
		List<Integer> rightHalf = values.subList(values.size() / 2, values.size());
		return merge(mergeSort(leftHalf), mergeSort(rightHalf));
	}

	private List<Integer> merge(List<Integer> left, List<Integer> right) {
		int leftPtr = 0;
		int rightPtr = 0;

		List<Integer> merged = new ArrayList<>(left.size() + right.size());

		while (leftPtr < left.size() && rightPtr < right.size()) {
			if (left.get(leftPtr) < right.get(rightPtr)) {
				merged.add(left.get(leftPtr));
				leftPtr++;
			} else {
				merged.add(right.get(rightPtr));
				rightPtr++;
			}
		}

		while (leftPtr < left.size()) {
			merged.add(left.get(leftPtr));
			leftPtr++;
		}

		while (rightPtr < right.size()) {
			merged.add(right.get(rightPtr));
			rightPtr++;
		}

		return merged;
	}
}
