package q1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetOdd {

	public static void main(String[] args) {

		// Example assume input data is primitive type: int
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		/* 
		 * Collection cannot store primitive data type: int, need to convert to corresponding wrapper class: Integer.
		 * Return Odd number by filtering with a Predicate.
		*/
		List<Integer> filteredList = Arrays.stream(data).filter((x) -> x % 2 == 1).boxed().collect(Collectors.toList());
		// Print Result
		System.out.println("For Q1:");
		System.out.println(filteredList);
	}

}
