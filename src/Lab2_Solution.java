import java.util.Scanner;
import java.util.Arrays;

/**
 * This class implements the necessary functions to complete 
 * Q1, Q2, and Q3 for the Lab 2 assignment.
 * 
 * @author Dillon Pullano
 *
 */
public class Lab2_Solution {
	
	/**
	 * Implements original linear search algorithm.
	 * @param array
	 * @param key
	 * @return array index of first found key match
	 */
	public static int linearSearch(int[] array, int key) {
		
		// Pass through array linearly until key is matched or end of array is reached:
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key) {
				
				// Matching index:
				return i;
			}
		}
		
		// No matching index exists:
		return -1;
	}
	
	
	/**
	 * Implements interpolation search algorithm.
	 * @param array
	 * @param key
	 * @return array index of first found key match
	 */
	public static int interpolationSearch(int[] array, int key) {
		
		//Initialize intermediate parameters:
		int low = 0;
		int high = array.length - 1;
		int mid;
		int pos;
		
		while(low <= high) {

			// Get new interpolated index for expected location of match:
			pos = (key - array[low]) / (array[high] - array[low]);
			mid = low + (((high - low) * pos));
			
			// When key is likely to be lower than mid:
			if(key < array[mid]) {
				high = mid - 1;
			}
			
			// When key is likely to be higher than mid:
			else if(array[mid] < key) {
				low = mid + 1;
			}
			
			// When there is match on first try:
			else {
				return mid;
			}
		}
		return -1;
	}
	
	
	/**
	 * Implements optimized linear search algorithm. 
	 * @param array
	 * @param key
	 * @return array index of first found key match
	 */
	public static int linearSearchOptimized(int[] array, int key) {
		
		// Calculate middle index:
		int mid = (array.length - 1) / 2;
		
		// When there is match on first try:
		if(key == array[mid]) {
			return mid;
		}
		
		// Progress linearly from middle index in the negative direction to the start of array:
		else if (key < array[mid]) {
			for(int i = mid; i >= 0; i--) {
				if(array[i] == key) {
					return i;
				}
			}
			return -1;
		}
		
		// Progress linearly from middle index in the positive direction to the end of array:
		else if(key >= array[mid]) {
			for(int j = mid; j <= array.length -1; j++) {
				if(array[j] == key) {
					return j;
				}
			}
			return -1;
		}
		
		// No match case:
		else {
			return -1;
		}
	}	
	
	
	/**
	 * Gathers user input, implements algorithms, and compares run times
	 * @param args
	 */
	public static void main(String[] args) {

		//-----------------------------------------------------------------------------------
		// Part 1 - Get user inputs and store values for array and key:
		//-----------------------------------------------------------------------------------
		
		// Create scanner for reading in user input:
		Scanner input = new Scanner(System.in);
		
		// Ask user for length of array and store value:
		System.out.print("Enter the number of elements in the array: ");
		int arrayLength = input.nextInt();
		
		// Initialize empty array:
		int[] array = new int[arrayLength];
		
		// Ask user for individual inputs for array and store into array:
		System.out.println("Enter the elements in the array: ");
		
		for (int i = 0; i < arrayLength; i++) {
			array[i] = input.nextInt();			
		}
		
		// Ask user for the search key and store:
		System.out.print("Enter the search key: ");
		int key = input.nextInt();
		
		// Sort array before passing through all algorithms:
		Arrays.sort(array);
		
		
		//-----------------------------------------------------------------------------------
		// Part 2 - Run the data through the original linear search algorithm:
		//-----------------------------------------------------------------------------------
		long linStartTime = System.nanoTime();
		int linSearch = linearSearch(array, key);
		long linEndTime = System.nanoTime();
		
		System.out.println("");
		System.out.println("Using ORIGINAL Linear Search: ");
		
		if(linSearch == -1) {
			System.out.println("Search key NOT FOUND");
		}
		else {
			System.out.println("Search key FOUND at index " + linSearch);
		}
		long linRuntime = linEndTime - linStartTime;
		System.out.println("ORIGINAL Linear search runtime: " + linRuntime);
		
		
		//-----------------------------------------------------------------------------------
		// Part 3 - Run the data through the interpolation search algorithm:
		//-----------------------------------------------------------------------------------
		long interpStartTime = System.nanoTime();
		int interpSearch = interpolationSearch(array, key);
		long interpEndTime = System.nanoTime();
		
		System.out.println("");
		System.out.println("Using Interpolation Search: ");
		
		if(interpSearch == -1) {
			System.out.println("Search key NOT FOUND");
		}
		else {
			System.out.println("Search key FOUND at index " + interpSearch);
		}
		long interpRuntime = interpEndTime - interpStartTime;
		System.out.println("Interpolation search runtime: " + interpRuntime);
		
		
		//-----------------------------------------------------------------------------------
		// Part 4 - Run the data through the OPTIMIZED linear search algorithm:
		//-----------------------------------------------------------------------------------
		long linStartTimeOp = System.nanoTime();
		int linSearchOp = linearSearchOptimized(array, key);
		long linEndTimeOp = System.nanoTime();
		
		System.out.println("");
		System.out.println("Using OPTIMIZED Linear Search: ");
		
		if(linSearchOp == -1) {
			System.out.println("Search key NOT FOUND");
		}
		else {
			System.out.println("Search key FOUND at index " + linSearchOp);
		}
		long linRuntimeOp = linEndTimeOp - linStartTimeOp;
		System.out.println("OPTIMIZED Linear search runtime: " + linRuntimeOp);		
		
		
		// Close scanner:
		input.close();
	}

}
