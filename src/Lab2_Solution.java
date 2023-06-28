import java.util.Scanner;
import java.util.Arrays;




public class Lab2_Solution {
	
	public static int linearSearch(int[] array, int key) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	public static int interpolationSearch(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;
		int mid;
		int pos;
		
		while(low <= high) {

			pos = (key - array[low]) / (array[high] - array[low]);
			mid = low + (((high - low) * pos));
			
			if(key < array[mid]) {
				high = mid - 1;
			}
			else if(array[mid] < key) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {

		// Create scanner for reading in user input:
		Scanner input = new Scanner(System.in);
		
		// Ask user for length of array and store value:
		System.out.println("Enter the number of elements in the array: ");
		int arrayLength = input.nextInt();
		
		// Initialize empty array:
		int[] array = new int[arrayLength];
		
		// Ask user for individual inputs for array and store into array:
		System.out.println("Enter the elements in the array: ");
		
		for (int i = 0; i < arrayLength; i++) {
			array[i] = input.nextInt();			
		}
		
		// Ask user for the search key and store:
		System.out.println("Enter the search key: ");
		int key = input.nextInt();
		
		
		// Run the data through linear search (NON SORTED ARRAY):
		long linStartTimeUnsorted = System.nanoTime();
		int linSearchUnsorted = linearSearch(array, key);
		long linEndTimeUnsorted = System.nanoTime();
		
		if(linSearchUnsorted == -1) {
			System.out.println("Search key NOT FOUND");
		}
		else {
			System.out.println("Search key FOUND at index " + linSearchUnsorted);
		}
		long linRuntimeUnsorted = linEndTimeUnsorted - linStartTimeUnsorted;
		System.out.println("Linear search runtime (BEFORE SORTING): " + linRuntimeUnsorted);		
		
		
		
		
		
		Arrays.sort(array);
		
		
		
		// Run the data through linear search (SORTED ARRAY):
		long linStartTime = System.nanoTime();
		int linSearch = linearSearch(array, key);
		long linEndTime = System.nanoTime();
		
		if(linSearch == -1) {
			System.out.println("Search key NOT FOUND");
		}
		else {
			System.out.println("Search key FOUND at index " + linSearch);
		}
		long linRuntime = linEndTime - linStartTime;
		System.out.println("Linear search runtime (AFTER SORTING): " + linRuntime);
		
		
		
		// Run the data through interpolation search (SORTED ARRAY):
		long interpStartTime = System.nanoTime();
		int interpSearch = interpolationSearch(array, key);
		long interpEndTime = System.nanoTime();
		
		if(interpSearch == -1) {
			System.out.println("Search key NOT FOUND");
		}
		else {
			System.out.println("Search key FOUND at index " + interpSearch);
		}
		long interpRuntime = interpEndTime - interpStartTime;
		System.out.println("Interpolation search runtime: " + interpRuntime);
		
		// Close scanner:
		input.close();
	}

}
